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

import com.clinica.backend.dto.consulta.ConsultaCreateDTO;
import com.clinica.backend.model.Consulta;
import com.clinica.backend.service.ConsultaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	@Autowired
	ConsultaService consultaService;
	
	@GetMapping
	public ResponseEntity<Object> findAll() {
		return consultaService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findOne(@PathVariable(name = "id") Long id){
		return consultaService.findById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id") Long id,
										 @RequestBody Consulta consultaDTO) {
		return consultaService.update(id, consultaDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) {
		return consultaService.delete(id);
	}
	
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody ConsultaCreateDTO consultaDTO) {
		return consultaService.create(consultaDTO);		
	}
}
