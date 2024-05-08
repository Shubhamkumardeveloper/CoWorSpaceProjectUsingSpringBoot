package com.ty.Springbootcoworkspaceapplication.exception;

public class NoSuchIdFoundException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "No Such Id Found In DataBase..";
	}

}
