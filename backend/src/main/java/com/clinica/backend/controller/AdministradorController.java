package com.clinica.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.backend.dto.administrador.AdministradorRequestDTO;
import com.clinica.backend.service.AdministradorService;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {
	@Autowired
	AdministradorService administradorService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable(name = "id") Long id) {
		return administradorService.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody AdministradorRequestDTO admDTO) {
		return administradorService.insert(admDTO);
	}
}
