package com.clinica.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clinica.backend.dto.administrador.AdministradorRequestDTO;
import com.clinica.backend.dto.administrador.AdministradorResponseDTO;
import com.clinica.backend.exception.UsernameAlreadyTakenException;
import com.clinica.backend.model.Administrador;
import com.clinica.backend.repository.AdministradorRepository;

@Service
public class AdministradorService {
	@Autowired
	AdministradorRepository administradorRepository;
	@Autowired
	RoleService roleService;
	
	public ResponseEntity<Object> insert(AdministradorRequestDTO admDTO) {
		Optional<Administrador> administradorOptional = administradorRepository.findByUsername(admDTO.username);
		if (administradorOptional.isPresent()) throw new UsernameAlreadyTakenException();
		
		Administrador adm = new Administrador(admDTO);
		roleService.setRoleAsAdmin(adm);
		administradorRepository.save(adm);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	public ResponseEntity<Object> findById(Long id) {
		Administrador adm = administradorRepository.findById(id).orElseThrow();
		return ResponseEntity.status(HttpStatus.OK).body(new AdministradorResponseDTO(adm));		
	}
}
