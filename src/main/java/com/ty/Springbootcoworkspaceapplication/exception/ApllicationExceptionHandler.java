package com.ty.Springbootcoworkspaceapplication.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ty.Springbootcoworkspaceapplication.dto.ResponseStructure;
@RestControllerAdvice
public class ApllicationExceptionHandler {
	
	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchIdDoesNotPresentException(NoSuchIdFoundException exception)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Not Found..");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(exception.getMessage());
		return new  ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ResponseStructure<String>> handleNullPonterException(NullPointerException e)
	{
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
		rs.setMessage("Message: "+e.getMessage());
		rs.setData("Dont deal with null");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoBuildingFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchIdDoesNotPresentException(NoBuildingFoundException exception)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Not Found..");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(exception.getMessage());
		return new  ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchCompanyException.class)
	public ResponseEntity<ResponseStructure<String>> catchIdDoesNotPresentException(NoSuchCompanyException exception)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Not Found..");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(exception.getMessage());
		return new  ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchFloorException.class)
	public ResponseEntity<ResponseStructure<String>> catchIdDoesNotPresentException(NoSuchFloorException exception)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Not Found..");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(exception.getMessage());
		return new  ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchRoomException.class)
	public ResponseEntity<ResponseStructure<String>> catchIdDoesNotPresentException(NoSuchRoomException exception)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Not Found..");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(exception.getMessage());
		return new  ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchWorkSpaceException.class)
	public ResponseEntity<ResponseStructure<String>> catchIdDoesNotPresentException(NoSuchWorkSpaceException exception)
	{
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Not Found..");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(exception.getMessage());
		return new  ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	
	
	

}
