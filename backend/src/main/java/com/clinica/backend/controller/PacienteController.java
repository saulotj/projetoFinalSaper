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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.backend.dto.paciente.PacienteRequestDTO;
import com.clinica.backend.service.PacienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	
	@GetMapping
	public ResponseEntity<Object> findAll(@RequestParam(value="date", required = false) String date) {
		return pacienteService.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable(name = "id") Long id) {
		return pacienteService.findOne(id);
	}
	
	@PostMapping
	public ResponseEntity<Object> insert(@Valid @RequestBody PacienteRequestDTO pacienteRequestDTO) {
		return pacienteService.insert(pacienteRequestDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id") Long id,
										@RequestBody PacienteRequestDTO pacienteDTO) {
		return pacienteService.update(id, pacienteDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) {
		return pacienteService.delete(id);
	}
}
