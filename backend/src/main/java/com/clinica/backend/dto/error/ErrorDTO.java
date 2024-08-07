package com.clinica.backend.dto.error;

import java.time.Instant;

public class ErrorDTO {
	public Instant timestamp;
	public String status;
	public String error;
	public String message;
	public String path;
	
	public ErrorDTO() {
	}

	public ErrorDTO(Instant timestamp, String status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
}
