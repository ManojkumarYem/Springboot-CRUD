package com.crud.handler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.crud.common.APIResponse;
import com.crud.common.NoSuchElementException;


@ControllerAdvice
public class HandlerDomain{

	public HandlerDomain() {
		System.out.println("Exception Alerted");

	}
	@Autowired
	APIResponse response;
	
	@ExceptionHandler(NoSuchElementException.class)
	public  ResponseEntity handlerException(NoSuchElementException nE){
		System.out.println("ERoorr");
		response.setError("EMPLOYEE ID not found");
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setData("null");
		return  ResponseEntity.status(500).body(response);
	}

}
