package com.ty.Springbootcoworkspaceapplication.exception;

public class NoSuchWorkSpaceException extends RuntimeException{
	
	@Override
	public String getMessage() {
		return "NO WorkSpace Present in DataBase...s";
	}

}
