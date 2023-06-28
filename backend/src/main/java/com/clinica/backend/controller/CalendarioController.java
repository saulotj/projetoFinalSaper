package com.clinica.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.backend.dto.calendario.CalendarioRequestDTO;
import com.clinica.backend.service.CalendarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {
	@Autowired
	CalendarioService calendarioService;
	
	@GetMapping(value = {"/{year}/{month}/{day}"})
	public ResponseEntity<Object> getDay(@PathVariable(name = "year") Integer year,
										 @PathVariable(name = "month") Integer month,
										 @PathVariable(name = "day") Integer day,
										 @RequestParam(name = "interval", required = false) Integer interval) {
		
		if (interval == null) return calendarioService.getDay(year, month, day); 
		return calendarioService.getDay(year, month, day, interval);
	}
	
	@GetMapping(value = {"/{year}/{month}"})
	public ResponseEntity<Object> getMonth(@PathVariable(name = "year") Integer year,
			 							   @PathVariable(name = "month") Integer month) {
		return calendarioService.getMonth(year, month);
	}
	
	@GetMapping(value = {"/{year}"})
	public ResponseEntity<Object> getYear(@PathVariable(name = "year") Integer year) {
		return calendarioService.getYear(year);
	}
	
	// essa rota deve ser acessada somente pelo administrador
	@PostMapping("/popular")
	public ResponseEntity<Object> insert(@Valid @RequestBody CalendarioRequestDTO calendarioDTO) {
		return calendarioService.insert(calendarioDTO);
	}
}
