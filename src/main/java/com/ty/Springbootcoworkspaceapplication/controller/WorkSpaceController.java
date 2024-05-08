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
import com.ty.Springbootcoworkspaceapplication.entity.Floor;
import com.ty.Springbootcoworkspaceapplication.entity.WorkSpace;
import com.ty.Springbootcoworkspaceapplication.service.WorkSpaceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/workspace")
public class WorkSpaceController {
	
	@Autowired
	private WorkSpaceService workSpaceService;
	
	@Operation(description = "To save the WorkSpace details",summary = "To save The WorkSpace into postresql db")
	@ApiResponses(value = @ApiResponse(description ="BuildingSaved",responseCode = "201") )
	@PostMapping
	public ResponseEntity<ResponseStructure<WorkSpace>> saveWorkSpace(@RequestBody WorkSpace workSpace)
	{
		return workSpaceService.saveWorkSpace(workSpace);
	}
	
	@Operation(description = "To save the WorkSpace details with spaceific floorId",summary = "To save The WorkSpace into postresql db by Specific floorId")
	@ApiResponses(value = @ApiResponse(description ="WorkSpaceSaved",responseCode = "201") )
	@PostMapping("/{floorId}")
	public ResponseEntity<ResponseStructure<Floor>> saveWorkSpace(@RequestBody WorkSpace workSpace,@PathVariable int floorId)
	{
		return workSpaceService.saveWorkSpace(workSpace,floorId);
	}
	
	@Operation(description = "To Update the WorkSpace detail",summary = "To Update the WorkSpace detail into postresql db")
	@ApiResponses(value = @ApiResponse(description ="WorkSpaceUpdated",responseCode = "200") )
	@PutMapping
	public ResponseEntity<ResponseStructure<WorkSpace>> updateWorkSpace(@RequestBody WorkSpace workSpace)
	{
		return workSpaceService.updateWorkSpace(workSpace);
	}
	
	@Operation(description = "To delete the workSpace by id ",summary = "To delete the workSpace by id into postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="workSpaceDeleted",responseCode = "200") )
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteWorkSpaceById(@PathVariable int id)
	{
		return workSpaceService.deleteWorkSpaceById(id);
	}
	
	@Operation(description = "To delete the workSpace by id ",summary = "To delete the workSpace by id into postresql db by id of specific floorId")
	@ApiResponses(value = @ApiResponse(description ="workSpaceDeleted",responseCode = "200") )
	@DeleteMapping("/{floorId}/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteWorkSpaceById(@PathVariable int floorId,@PathVariable int id)
	{
		return workSpaceService.deleteWorkSpaceById(floorId,id);
	}
	
	@Operation(description = "To find the WorkSpace detail by id",summary = "To find The WorkSpace from postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="WorkSpaceFound",responseCode = "200") )
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<WorkSpace>> findWorkSpaceById(@PathVariable int id)
	{
		return workSpaceService.findWorkSpaceById(id);
	}
	
	@Operation(description = "To find All the WorkSpace details",summary = "To find All The WorkSpace details into postresql db")
	@ApiResponses(value = @ApiResponse(description ="WorkSpaceFound",responseCode = "302") )
	@GetMapping
	public ResponseEntity<ResponseStructure<List<WorkSpace>>> FindAllWorkSpace()
	{
		return workSpaceService.FindAllWorkSpace();
	}

}
