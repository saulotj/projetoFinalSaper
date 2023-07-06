package com.clinica.backend.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clinica.backend.dto.recepcionista.RecepcionistaRequestDTO;
import com.clinica.backend.dto.recepcionista.RecepcionistaResponseDTO;
import com.clinica.backend.exception.UsernameAlreadyTakenException;
import com.clinica.backend.model.Recepcionista;
import com.clinica.backend.repository.RecepcionistaRepository;
import com.clinica.backend.util.ObjectProperties;

import jakarta.transaction.Transactional;

@Service
public class RecepcionistaService {
	@Autowired
	RecepcionistaRepository recepcionistaRepository;
	
	@Autowired
	RoleService roleService;
	
	public ResponseEntity<Object> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(
				recepcionistaRepository.findAll().stream().map(recepcionista -> new RecepcionistaResponseDTO(recepcionista))
		);
	}

	@Transactional
	public ResponseEntity<Object> update(Long id, RecepcionistaRequestDTO recepcionistaDTO) {
		Recepcionista recepcionista = recepcionistaRepository.findById(id).orElseThrow();
		ObjectProperties.myCopyProperties(recepcionistaDTO, recepcionista);
		recepcionistaRepository.save(recepcionista);
		return ResponseEntity.status(HttpStatus.OK).body(new RecepcionistaResponseDTO(recepcionista));
	}

	@Transactional
	public ResponseEntity<Object> delete(Long id) {
		Recepcionista recepcionista = recepcionistaRepository.findById(id).orElseThrow();		
		recepcionistaRepository.delete(recepcionista);
		return ResponseEntity.status(HttpStatus.OK).build();		
	}

	public ResponseEntity<Object> insert(RecepcionistaRequestDTO recepcionistaDTO) {
		Optional<Recepcionista> recepcionistaOptional = recepcionistaRepository.findByUsername(recepcionistaDTO.username);
		if (recepcionistaOptional.isPresent()) throw new UsernameAlreadyTakenException();
		
		Recepcionista recepcionista = new Recepcionista(recepcionistaDTO);
		roleService.setRoleAsRecepcionista(recepcionista);
		recepcionistaRepository.save(recepcionista);
		
		return ResponseEntity.status(HttpStatus.OK).body(new RecepcionistaResponseDTO(recepcionista));
	}

	public ResponseEntity<Object> findOne(Long id) {
		Recepcionista recepcionista = recepcionistaRepository.findById(id).orElseThrow();
		return ResponseEntity.status(HttpStatus.OK).body(new RecepcionistaResponseDTO(recepcionista));
	}
}
