package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GolbalExceptionHandler {

	@ExceptionHandler(customerException.class)
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(customerException ce , WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> LoginExceptionHandler(LoginException le , WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(le.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorDetails> NotFoundExceptionHandler(NotFoundException nfe , WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(nfe.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(Exception e , WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDateTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.NOT_FOUND);
		
	}
	
}
