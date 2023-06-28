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

import com.clinica.backend.dto.planoSaude.PlanoSaudeRequestDTO;
import com.clinica.backend.service.PlanoSaudeService;

@RestController
@RequestMapping("/plano-saude")
public class PlanoSaudeController {
	@Autowired
	PlanoSaudeService planoSaudeService;
	
	@GetMapping
	public ResponseEntity<Object> findAll() {
		return planoSaudeService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody PlanoSaudeRequestDTO planoDTO) {
		return planoSaudeService.insert(planoDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(name = "id") Long id,
										 @RequestBody PlanoSaudeRequestDTO planoSaudeRequestDTO) {
		return planoSaudeService.update(id, planoSaudeRequestDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id) {
		return planoSaudeService.delete(id);
	}
}
