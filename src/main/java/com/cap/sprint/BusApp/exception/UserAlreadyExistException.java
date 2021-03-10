package com.cap.sprint.BusApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Http Status at input time to confirm what the issue is
@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserAlreadyExistException extends RuntimeException{
	
	public UserAlreadyExistException() {
	}
	
	public UserAlreadyExistException(String message) {
		super(message);
	}

}