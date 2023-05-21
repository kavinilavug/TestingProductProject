package com.product.app.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.product.app.exception.ProductNotFoundException;

@ControllerAdvice
public class MyProductControllerAdvice {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleEmptyInput(ProductNotFoundException productNotFndExcep){
		return new ResponseEntity<String>("Input field empty please look into it",HttpStatus.BAD_REQUEST) ;
		
	}
	
}
