package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> userNotFoundException(UserNotFoundException ex, WebRequest req){
		ErrorMessage error = new ErrorMessage(
											HttpStatus.NOT_FOUND.value(),
											ex.getMessage(), 
											new Date(),
											req.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleOtherException(Exception ex, WebRequest req){
		ErrorMessage error = new ErrorMessage(
											HttpStatus.INTERNAL_SERVER_ERROR.value(),
											ex.getMessage(), 
											new Date(),
											req.getDescription(false));
		
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
