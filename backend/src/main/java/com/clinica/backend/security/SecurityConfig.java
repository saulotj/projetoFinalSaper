package com.clinica.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.clinica.backend.repository.LoggableUserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	AuthenticatorService AuthenticatorService;
	
	@Autowired
	LoggableUserRepository loggableUserRepository;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeHttpRequests()
		//RECEPCIONISTA & MEDICO
		.requestMatchers("/paciente/**").hasAnyRole("RECEPCIONISTA", "ADM")
		.requestMatchers("/consulta/**").hasAnyRole("RECEPCIONISTA", "ADM")
		.requestMatchers("/user/**").hasRole("ADM")
		.requestMatchers("/administrador/**").hasRole("ADM")
		.requestMatchers(HttpMethod.PUT, "/consulta/**").hasAnyRole("RECEPCIONISTA", "MEDICO", "ADM")
		.requestMatchers(HttpMethod.GET, "/calendario/**").hasAnyRole("RECEPCIONISTA", "MEDICO", "ADM")
		.requestMatchers(HttpMethod.GET, "/medico/**").hasAnyRole("RECEPCIONISTA", "ADM")
		
		//ADM
		.requestMatchers("/recepcionista/**").hasRole("ADM")
		.requestMatchers("/plano-saude/**").hasRole("ADM")
		.requestMatchers("/medico/**").hasRole("ADM")
		.requestMatchers("/calendario/**").hasRole("ADM")
		
		.anyRequest().denyAll();
		http.cors();
		http.csrf().disable();
		return http.build();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new AuthenticatorService(loggableUserRepository))
		.passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder() {};
	}
}
