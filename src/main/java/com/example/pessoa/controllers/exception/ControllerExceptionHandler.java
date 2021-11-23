package com.example.pessoa.controllers.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.pessoa.services.exception.EmptyResultDataAccessException;
import com.example.pessoa.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(),"Pessoa não encontrada", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);	
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<StandardError> empty(EmptyResultDataAccessException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_MODIFIED;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Id não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
