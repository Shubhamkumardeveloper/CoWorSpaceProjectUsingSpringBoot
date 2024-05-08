package com.ty.Springbootcoworkspaceapplication.exception;

public class NoSuchRoomException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "NO Room Present in DataBase...";
	}

}
