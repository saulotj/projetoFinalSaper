package com.clinica.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinica.backend.service.LoggableUserService;

@RestController
@RequestMapping("/user")
public class LoggableUserController {
	
	@Autowired
	LoggableUserService loggableUserService;

	@GetMapping("/{username}")
	public ResponseEntity<Object> findByUsername(@PathVariable(name = "username") String username){
		return loggableUserService.findByUsername(username);
	}
}
