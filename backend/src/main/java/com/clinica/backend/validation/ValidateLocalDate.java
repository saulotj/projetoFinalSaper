package com.clinica.backend.validation;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidateLocalDate implements ConstraintValidator<LocalDateConstraint, String>{
	@Override
	public void initialize(LocalDateConstraint date) {}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		try {
			LocalDate.parse(value);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
}
