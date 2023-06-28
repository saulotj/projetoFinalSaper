package com.clinica.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clinica.backend.repository.PacienteRepository;
import com.clinica.backend.util.ObjectProperties;

import jakarta.transaction.Transactional;

import com.clinica.backend.dto.paciente.PacienteRequestDTO;
import com.clinica.backend.dto.paciente.PacienteResponseDTO;
import com.clinica.backend.model.Paciente;
import java.util.Optional;

@Service
public class PacienteService {
	@Autowired
	PacienteRepository pacienteRepository;
	
	public ResponseEntity<Object> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(pacienteRepository.findAll().stream().map((paciente -> new PacienteResponseDTO(paciente)))); 
	}
	
	public ResponseEntity<Object> findOne(Long id) {
		Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
		if (pacienteOptional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
		return ResponseEntity.status(HttpStatus.OK).body(new PacienteResponseDTO(pacienteOptional.get()));
	}
	
	@Transactional
	public ResponseEntity<Object> insert(PacienteRequestDTO pacienteDTO) {
		Paciente paciente = new Paciente(pacienteDTO);
		paciente = pacienteRepository.save(paciente);
		return ResponseEntity.status(HttpStatus.OK).body(new PacienteResponseDTO(paciente));
	}
	
	@Transactional
	public ResponseEntity<Object> update(Long id, PacienteRequestDTO pacienteDTO) {
		Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
		if ( pacienteOptional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
		Paciente paciente = pacienteOptional.get();
		ObjectProperties.myCopyProperties(pacienteDTO, paciente);
		pacienteRepository.save(paciente);
		return ResponseEntity.status(HttpStatus.OK).body(new PacienteResponseDTO(paciente));
	}

	@Transactional
	public ResponseEntity<Object> delete(Long id) {
		Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
		if (pacienteOptional.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
		pacienteRepository.delete(pacienteOptional.get());
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
