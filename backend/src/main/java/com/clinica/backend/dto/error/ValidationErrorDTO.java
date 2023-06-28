package com.clinica.backend.dto.error;

public class ValidationErrorDTO {
	public String field;
	public String error;
	
	public ValidationErrorDTO(String field, String error) {
		this.field = field;
		this.error = error;
	}
}
