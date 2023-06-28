package com.clinica.backend.exception;

import java.time.DateTimeException;
import java.time.Instant;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.clinica.backend.dto.error.ErrorDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RestControllerExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Set<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException exception,
													HttpServletRequest request) {
		Set<ErrorDTO> errorList = new HashSet<>();

		exception
		.getBindingResult()
		.getAllErrors()
		.forEach(error -> {
			errorList.add(new ErrorDTO(
						Instant.now(),
						HttpStatus.BAD_REQUEST.toString(),
						((FieldError) error).getField(),
						error.getDefaultMessage(),
						request.getRequestURI()
					));
		});
		
		return errorList;
	};
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Set<ErrorDTO> handleHttpMessageNotReadableExceptionException(HttpMessageNotReadableException ex,
    									 HttpServletRequest request) {
		Set<ErrorDTO> errorList = new HashSet<>();
		
        ErrorDTO error = new ErrorDTO(
        		Instant.now(),
        		HttpStatus.BAD_REQUEST.toString(),
        		"Invalid data",
        		ex.getMostSpecificCause().toString(),
        		request.getRequestURI()
        		);
        
        errorList.add(error);
        return errorList;
    }
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public ErrorDTO handleNoSuchElementException(NoSuchElementException exception,
													  HttpServletRequest request){
		return new ErrorDTO(
				Instant.now(),
				HttpStatus.NOT_FOUND.toString(),
				"resource not found",
				exception.getMessage(),
				request.getRequestURI()
				);		
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UsernameAlreadyTakenException.class)
	public ErrorDTO handleUsernameAlreadyTakenException(UsernameAlreadyTakenException exception,
														HttpServletRequest request) {
		
		return new ErrorDTO(
				Instant.now(),
				HttpStatus.BAD_REQUEST.toString(),
				"Username already taken",
				exception.getMessage(),
				request.getRequestURI()
				);
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidDateParamException.class)
	public ErrorDTO handleInvalidDateParamException(InvalidDateParamException exception,
													HttpServletRequest request) {
		return new ErrorDTO(
				Instant.now(),
				HttpStatus.BAD_REQUEST.toString(),
				"Invalid Date Param Exception",
				exception.getMessage(),
				request.getRequestURI()
				);				
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DateTimeException.class)
	public ErrorDTO handleDateTimeException(DateTimeException exception,
			HttpServletRequest request) {
		return new ErrorDTO(
				Instant.now(),
				HttpStatus.BAD_REQUEST.toString(),
				"Invalid Date Param",
				exception.getMessage(),
				request.getRequestURI()
				);
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ResourceNotFoundException.class)
	public ErrorDTO handleResourceNotFoundException(
			ResourceNotFoundException exception,
			HttpServletRequest request) {
		
		return new ErrorDTO(
				Instant.now(),
				HttpStatus.NOT_FOUND.toString(),
				"Resource not found",
				exception.getMessage(),
				request.getRequestURI()
				);
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(Exception.class)
	public ErrorDTO handleException(Exception exception,
			  						HttpServletRequest request) {
		return new ErrorDTO(
				Instant.now(),
				HttpStatus.BAD_REQUEST.toString(),
				"Unknow error",
				exception.getMessage(),
				request.getRequestURI()
				);
	}
	
}

