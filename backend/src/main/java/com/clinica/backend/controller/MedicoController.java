package com.clinica.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.backend.dto.medico.MedicoRequestDTO;
import com.clinica.backend.service.MedicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medico")
public class MedicoController {
	
	@Autowired
	MedicoService medicoService;
	
	@GetMapping
	public ResponseEntity<Object> findAll() {
		return medicoService.findAll();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id") Long id,
										 @RequestBody MedicoRequestDTO medicoDTO) {
		return medicoService.update(id, medicoDTO);
	}
	
	@PostMapping
	public ResponseEntity<Object> insert(@Valid @RequestBody MedicoRequestDTO medicoDTO) {
		return medicoService.insert(medicoDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id){
		return medicoService.delete(id);
	}
}
