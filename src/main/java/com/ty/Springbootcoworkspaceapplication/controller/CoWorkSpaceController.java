package com.ty.Springbootcoworkspaceapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.Springbootcoworkspaceapplication.dto.ResponseStructure;
import com.ty.Springbootcoworkspaceapplication.entity.CoWorkSpace;
import com.ty.Springbootcoworkspaceapplication.service.CoWorkSpaceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/coworkspace")
public class CoWorkSpaceController {
	
	
	@Autowired
	private CoWorkSpaceService coWorkSpaceService;
	
	@Operation(description = "To save the CoWorkSpace details",summary = "To save The coWorkSpace into postresql db")
	@ApiResponses(value = @ApiResponse(description ="CoworkSpaceSaved",responseCode = "201") )
	
	@PostMapping
	public ResponseEntity<ResponseStructure<CoWorkSpace>> saveCoWokSpace(@RequestBody CoWorkSpace coWorkSpace)
	{
		return coWorkSpaceService.saveCoWorkSpace(coWorkSpace);
	}
	
	@Operation(description = "To find the CoWorkSpace detail by id",summary = "To find The coWorkSpace from postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="CoworkSpaceFinded",responseCode = "200") )
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<CoWorkSpace>> findById(@PathVariable int id)
	{
		return coWorkSpaceService.findCoWorkSpaceById(id);
	}
	
	@Operation(description = "To Update the CoWorkSpace detail",summary = "To Update the CoWorkSpace detail into postresql db")
	@ApiResponses(value = @ApiResponse(description ="CoworkSpacwupdated",responseCode = "200") )
	@PutMapping
	public ResponseEntity<ResponseStructure<CoWorkSpace>> updateCoWorkSpace(@RequestBody CoWorkSpace coWorkSpace)
	{
		return coWorkSpaceService.updateCoWorkSpace(coWorkSpace);
	}
	
	@Operation(description = "To delete the CoWorkSpace by id ",summary = "To delete the CoWorkSpace by id into postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="CoworkSpaceDeleted",responseCode = "200") )
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteCoWorkSpace(@PathVariable int id)
	{
		return coWorkSpaceService.deleteCoWorkSpace(id);
	}
	
	@Operation(description = "To find All the CoWorkSpace details",summary = "To find All The coWorkSpace details into postresql db")
	@ApiResponses(value = @ApiResponse(description ="CoworkSpaceFounds",responseCode = "302") )
	@GetMapping
	public ResponseEntity<ResponseStructure<List<CoWorkSpace>>> getAllCoWorkSpace()
	{
		return coWorkSpaceService.findAllCoWorkSpace();
	}

}
