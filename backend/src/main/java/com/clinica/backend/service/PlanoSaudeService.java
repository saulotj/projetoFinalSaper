package com.clinica.backend.service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clinica.backend.dto.planoSaude.PlanoSaudeRequestDTO;
import com.clinica.backend.dto.planoSaude.PlanoSaudeResponseDTO;
import com.clinica.backend.model.PlanoSaude;
import com.clinica.backend.repository.PlanoSaudeRepository;
import com.clinica.backend.util.ObjectProperties;

import jakarta.transaction.Transactional;

@Service
public class PlanoSaudeService {
	@Autowired
	PlanoSaudeRepository planoSaudeRepository;
	
	public ResponseEntity<Object> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(planoSaudeRepository.findAll());
	}
	
	@Transactional
	public ResponseEntity<Object> update(Long id, PlanoSaudeRequestDTO planoSaudeRequestDTO) {
		Optional<PlanoSaude> planoOptional = planoSaudeRepository.findById(id);
		if (planoOptional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		List<String> nullAttributes = Arrays.asList(ObjectProperties.getNullPropertyNames(planoSaudeRequestDTO));
		if (nullAttributes.size() != 0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing:" + nullAttributes);
				
		PlanoSaude planoSaude = planoOptional.get();
		ObjectProperties.myCopyProperties(planoSaudeRequestDTO, planoSaude);
		return ResponseEntity.status(HttpStatus.OK).body(planoSaudeRepository.save(planoSaude));
	}

	@Transactional
	public ResponseEntity<Object> delete(Long id) {
		Optional<PlanoSaude> planoSaudeOptional = planoSaudeRepository.findById(id);
		if (planoSaudeOptional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		planoSaudeRepository.delete(planoSaudeOptional.get());
		return ResponseEntity.status(HttpStatus.OK).build();		
	}

	@Transactional
	public ResponseEntity<Object> insert(PlanoSaudeRequestDTO planoDTO) {
		List<String> nullProps = Arrays.asList(ObjectProperties.getNullPropertyNames(planoDTO));
		if (nullProps.size() != 0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing: " + nullProps);
		PlanoSaude plano = new PlanoSaude(planoDTO);
		planoSaudeRepository.save(plano);
		return ResponseEntity.status(HttpStatus.OK).body(new PlanoSaudeResponseDTO(plano));
	}
}
