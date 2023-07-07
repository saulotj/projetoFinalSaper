package com.clinica.backend;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.clinica.backend.dto.calendario.CalendarioRequestDTO;
import com.clinica.backend.model.Administrador;
import com.clinica.backend.model.Medico;
import com.clinica.backend.model.Recepcionista;
import com.clinica.backend.repository.AdministradorRepository;
import com.clinica.backend.repository.MedicoRepository;
import com.clinica.backend.repository.RecepcionistaRepository;
import com.clinica.backend.service.CalendarioService;
import com.clinica.backend.service.RoleService;

@SpringBootApplication
public class BackendApplication {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(BackendApplication.class, args);
		
		//===== Setting Initial Models =====
		AdministradorRepository administradorRepository =
				configurableApplicationContext.getBean(AdministradorRepository.class);
		MedicoRepository medicoRepository =
				configurableApplicationContext.getBean(MedicoRepository.class);
		RecepcionistaRepository recepcionistaRepository =
				configurableApplicationContext.getBean(RecepcionistaRepository.class);
		CalendarioService calendarioService =
				configurableApplicationContext.getBean(CalendarioService.class);
		
		RoleService roleService =
				configurableApplicationContext.getBean(RoleService.class);
		
		Administrador admin = new Administrador("admin", "123");
		roleService.setRoleAsAdmin(admin);
		administradorRepository.save(admin);
		
		Medico medico = new Medico("admin-medic", "123", "Mock Vagner",
				"admin@clinica.com", "85985999999", "CE545594", "Geral");
		roleService.setRoleAsMedico(medico);
		medicoRepository.save(medico);
		
		Recepcionista recepcionista = new Recepcionista("admin-recepcionista", "123",
				 "Mock Andreza", "admin@clinica.com");
		roleService.setRoleAsRecepcionista(recepcionista);
		recepcionistaRepository.save(recepcionista);
		
		CalendarioRequestDTO calendarioRequestDTO =
				new CalendarioRequestDTO(
						LocalDate.of(2023, 1, 1), //Initial date
						LocalDate.of(2023, 12, 31)); // Final date
		
		calendarioService.insert(calendarioRequestDTO);
		//======== ==========
	}

	@Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
        
      }
    };
  }

}
