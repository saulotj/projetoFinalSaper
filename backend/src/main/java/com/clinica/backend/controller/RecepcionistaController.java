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

import com.clinica.backend.dto.recepcionista.RecepcionistaRequestDTO;
import com.clinica.backend.service.RecepcionistaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/recepcionista")
public class RecepcionistaController {
	@Autowired
	RecepcionistaService recepcionistaService;

	@GetMapping
	public ResponseEntity<Object> findAll() {
		return recepcionistaService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable(name = "id") Long id) {
		return recepcionistaService.findOne(id);
	}
	
	@PostMapping
	public ResponseEntity<Object> insert(@Valid @RequestBody RecepcionistaRequestDTO recepcionistaDTO) {
		return recepcionistaService.insert(recepcionistaDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id") Long id,
										 @RequestBody RecepcionistaRequestDTO recepcionistaDTO) {
		return recepcionistaService.update(id, recepcionistaDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) {
		return recepcionistaService.delete(id);
	}
}
