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
import com.ty.Springbootcoworkspaceapplication.entity.Building;
import com.ty.Springbootcoworkspaceapplication.entity.CoWorkSpace;
import com.ty.Springbootcoworkspaceapplication.service.BuildingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/building")
public class BuildingController {
	
	@Autowired
	private BuildingService buildingService;
	
	@Operation(description = "To save the Building details",summary = "To save The Building into postresql db")
	@ApiResponses(value = @ApiResponse(description ="BuildingSaved",responseCode = "201") )
	@PostMapping
	public ResponseEntity<ResponseStructure<Building>> saveBuilding(@RequestBody Building building)
	{
		return buildingService.saveCoWorkSpace(building);
	}
	
	

	@Operation(description = "To save the Building details with spaceific coworkspace",summary = "To save The Building into postresql db by Specific coworkspcace")
	@ApiResponses(value = @ApiResponse(description ="BuildingSaved",responseCode = "201") )
	@PostMapping("/{coworkspaceId}")
	public ResponseEntity<ResponseStructure<CoWorkSpace>> saveBuilding(@RequestBody Building building , @PathVariable int coworkspaceId)
	{
		return buildingService.saveCoWorkSpace(building,coworkspaceId);
	}
	
	@Operation(description = "To find All the Building details",summary = "To find All The Building details into postresql db")
	@ApiResponses(value = @ApiResponse(description ="BuildingFound",responseCode = "302") )
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Building>>> findAll()
	{
		return buildingService.findAllBuilding();
	}
	
	@Operation(description = "To Update the Building detail",summary = "To Update the Building detail into postresql db")
	@ApiResponses(value = @ApiResponse(description ="BuildingUpdated",responseCode = "200") )
	@PutMapping
	public ResponseEntity<ResponseStructure<Building>> updateBuilding(@RequestBody Building building)
	{
		return buildingService.saveCoWorkSpace(building);
	}
	
	@Operation(description = "To delete the Building by id ",summary = "To delete the Building by id into postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="BuildingDeleted",responseCode = "200") )
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id)
	{
		return buildingService.deleteBuildingById(id);
	}
	
	@Operation(description = "To delete the Building by id ",summary = "To delete the Building by id into postresql db by id of specific coworksapce")
	@ApiResponses(value = @ApiResponse(description ="BuildingDeleted",responseCode = "200") )
	@DeleteMapping("/{coworkspaceId}/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int coworkspaceId, @PathVariable int id)
	{
		return buildingService.deleteBuildingById(coworkspaceId,id);
	}
	
	@Operation(description = "To find the Building detail by id",summary = "To find The Building from postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="BuildingFound",responseCode = "200") )
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Building>> findBuildingById(@PathVariable int id)
	{
		return buildingService.findBuildingById(id);
	}
}
