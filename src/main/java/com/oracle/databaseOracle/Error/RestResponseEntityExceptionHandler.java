package com.oracle.databaseOracle.Error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.oracle.databaseOracle.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private ErrorMessage errorMessage;
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorMessage> dataNotFoundException(DataNotFoundException e, WebRequest req){
		errorMessage.setMessage(e.getMessage());
		errorMessage.setHttpStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ErrorMessage>(HttpStatus.NOT_FOUND);
	}

}
