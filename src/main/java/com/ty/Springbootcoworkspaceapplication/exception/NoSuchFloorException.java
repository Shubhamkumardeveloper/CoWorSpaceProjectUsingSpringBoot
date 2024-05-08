package com.ty.Springbootcoworkspaceapplication.exception;

public class NoSuchFloorException extends RuntimeException{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No Such Floor Find in database...";
	}
}
