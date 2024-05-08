package com.ty.Springbootcoworkspaceapplication.exception;

public class NoSuchCompanyException extends RuntimeException {

	@Override
	public String getMessage() {
		return  "NO such company found in database...";
	}
}
