package com.clinica.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clinica.backend.dto.medico.MedicoRequestDTO;
import com.clinica.backend.dto.medico.MedicoResponseDTO;
import com.clinica.backend.exception.UsernameAlreadyTakenException;
import com.clinica.backend.model.Medico;
import com.clinica.backend.repository.MedicoRepository;
import com.clinica.backend.util.ObjectProperties;

import jakarta.transaction.Transactional;

@Service
public class MedicoService {
	@Autowired
	MedicoRepository medicoRepository;
	
	@Autowired
	RoleService roleService;

	public ResponseEntity<Object> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findAll().stream().map(medico -> new MedicoResponseDTO(medico)));
	}
	
	@Transactional
	public ResponseEntity<Object> insert(MedicoRequestDTO medicoDTO) {
		Optional<Medico> medicoOptional = medicoRepository.findByUsername(medicoDTO.username);
		if (medicoOptional.isPresent()) throw new UsernameAlreadyTakenException();
		
		Medico medico = new Medico(medicoDTO);
		roleService.setRoleAsMedico(medico);
		medicoRepository.save(medico);
		return ResponseEntity.status(HttpStatus.OK).body(new MedicoResponseDTO(medico));
	}

	@Transactional
	public ResponseEntity<Object> update(Long id, MedicoRequestDTO medicoDTO) {
		Medico medico = medicoRepository.findById(id).orElseThrow();
		ObjectProperties.myCopyProperties(medicoDTO, medico);
		medicoRepository.save(medico);
		return ResponseEntity.status(HttpStatus.OK).body(new MedicoResponseDTO(medico));
	}

	@Transactional
	public ResponseEntity<Object> delete(Long id) {
		Medico medico = medicoRepository.findById(id).orElseThrow();
		medicoRepository.delete(medico);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	public ResponseEntity<Object> findOne(Long id) {
		Medico medico = medicoRepository.findById(id).orElseThrow();
		return ResponseEntity.status(HttpStatus.OK).body(new MedicoResponseDTO(medico));
	}
}
