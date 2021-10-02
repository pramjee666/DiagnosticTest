package com.demo.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.rest.entity.DiagnosticTestErrorResponse;

@ControllerAdvice
public class DiagnosticTestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<DiagnosticTestErrorResponse> handleException(DiagnosticTestNotFoundException exception){
		DiagnosticTestErrorResponse error = new DiagnosticTestErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);//404 not found
	}
	
	@ExceptionHandler
	public ResponseEntity<DiagnosticTestErrorResponse> handleException(DiagnosticTestFoundException exception){
		DiagnosticTestErrorResponse error = new DiagnosticTestErrorResponse();
		
		error.setStatus(HttpStatus.FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.FOUND);//404 not found
	}

}
