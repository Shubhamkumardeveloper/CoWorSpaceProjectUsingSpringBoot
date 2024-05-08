package com.ty.Springbootcoworkspaceapplication.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ty.Springbootcoworkspaceapplication.dto.ResponseStructure;
import com.ty.Springbootcoworkspaceapplication.entity.Users;
import com.ty.Springbootcoworkspaceapplication.service.UsersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UsersService usersService;
	
	@Operation(description = "To save the User details",summary = "To save The User into postresql db")
	@ApiResponses(value = @ApiResponse(description ="UserSaved",responseCode = "201") )
	@PostMapping
	public ResponseEntity<ResponseStructure<Users>> saveUsers(Users users)
	{
		return usersService.saveUsers(users);
	}
	
	@Operation(description = "To find the User detail by id",summary = "To find The User from postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="UserFound",responseCode = "200") )
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Users>> findUserById(int id)
	{
		return usersService.findUserById(id);
	}
	
	@Operation(description = "To Update the User detail",summary = "To Update the User detail into postresql db")
	@ApiResponses(value = @ApiResponse(description ="UserUpdated",responseCode = "200") )
	@PutMapping
	public ResponseEntity<ResponseStructure<Users>> updateUser(Users users)
	{
		return usersService.updateUser(users);
	}
	
	@Operation(description = "To delete the User by id ",summary = "To delete the User by id into postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="UserDeleted",responseCode = "200") )
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUserById(int id)
	{
		return usersService.deleteUserById(id);
	}
	
	@Operation(description = "To find All the User details",summary = "To find All The User details into postresql db")
	@ApiResponses(value = @ApiResponse(description ="UserFound",responseCode = "302") )
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Users>>> findAllUser()
	{
		return usersService.findAllUser();
	}

}
