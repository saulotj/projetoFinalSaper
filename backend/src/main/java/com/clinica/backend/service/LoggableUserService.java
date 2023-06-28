package com.clinica.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.clinica.backend.repository.LoggableUserRepository;

@Service
public class LoggableUserService {
	@Autowired
	LoggableUserRepository loggableUserRepository;
	
	public ResponseEntity<Object> findByUsername(String username) {
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(loggableUserRepository.findByUsername(username).get());
	}
}
