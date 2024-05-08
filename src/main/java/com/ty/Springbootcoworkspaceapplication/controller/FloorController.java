package com.ty.Springbootcoworkspaceapplication.controller;

import java.util.List;
import java.util.Optional;

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
import com.ty.Springbootcoworkspaceapplication.entity.Building;
import com.ty.Springbootcoworkspaceapplication.entity.Floor;
import com.ty.Springbootcoworkspaceapplication.service.FloorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/floor")
public class FloorController {
	
	@Autowired
	private FloorService floorService;
	
	@Operation(description = "To save the Floor details",summary = "To save The Floor into postresql db")
	@ApiResponses(value = @ApiResponse(description ="FloorSaved",responseCode = "201") )
	@PostMapping
	public ResponseEntity<ResponseStructure<Floor>> savefloor(@RequestBody Floor floor)
	{
		return floorService.savefloor(floor);
	}
	
	@Operation(description = "To save the floor details with spaceific building",summary = "To save The floor into postresql db by Specific building")
	@ApiResponses(value = @ApiResponse(description ="FloorSaved",responseCode = "201") )
	@PostMapping("/{buildingId}")
	public ResponseEntity<ResponseStructure<Building>> savefloor(@RequestBody Floor floor,@PathVariable int buildingId)
	{
		return floorService.savefloor(floor,buildingId);
	}
	
	@Operation(description = "To Update the floor detail",summary = "To Update the floor detail into postresql db")
	@ApiResponses(value = @ApiResponse(description ="floorUpdated",responseCode = "200") )
	@PutMapping
	public ResponseEntity<ResponseStructure<Floor>> updateFloor(@RequestBody Floor floor)
	{
		return floorService.updateFloor(floor); 
	}
	
	@Operation(description = "To delete the floor by id ",summary = "To delete the floor by id into postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="floorDeleted",responseCode = "200") )
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteFloorById(@PathVariable int id)
	{
		return floorService.deleteFloorById(id); 
	}
	
	@Operation(description = "To delete the floor by id ",summary = "To delete the floor by id into postresql db by id of specific building")
	@ApiResponses(value = @ApiResponse(description ="floorDeleted",responseCode = "200") )
	@DeleteMapping("/{buildingId}/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteFloorById(@PathVariable int buildingId,@PathVariable int id)
	{
		return floorService.deleteFloorById(buildingId,id); 
	}
	
	@Operation(description = "To find the floor detail by id",summary = "To find The floor from postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="BuildingFound",responseCode = "200") )
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Floor>> findFloorById(@PathVariable int id)
	{
		return floorService.findFloorById(id); 
	}
	
	@Operation(description = "To find All the floor details",summary = "To find All The floor details into postresql db")
	@ApiResponses(value = @ApiResponse(description ="floorFound",responseCode = "302") )
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Floor>>> findAllFloor()
	{
		return floorService.findAllFloor();
	}

}
