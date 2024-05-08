package com.ty.Springbootcoworkspaceapplication.exception;

public class NoBuildingFoundException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "No Nuilding present in dataBase..";
	}

}
