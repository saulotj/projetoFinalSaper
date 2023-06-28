package com.clinica.backend.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.clinica.backend.repository.LoggableUserRepository;
import com.clinica.backend.model.LoggableUser;

@Service
public class AuthenticatorService implements UserDetailsService{
	LoggableUserRepository loggableUserRepository;
	
	public AuthenticatorService(LoggableUserRepository loggableUserRepository) {
		this.loggableUserRepository = loggableUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Optional<LoggableUser> loggableUser = loggableUserRepository.findByUsername(nome);
		if (loggableUser.isPresent()) return loggableUser.get();
		
		throw new UsernameNotFoundException("Recepcionista/Medico não encontrado");
	}
}
