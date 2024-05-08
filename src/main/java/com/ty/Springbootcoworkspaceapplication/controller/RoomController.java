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
import com.ty.Springbootcoworkspaceapplication.entity.Room;
import com.ty.Springbootcoworkspaceapplication.entity.WorkSpace;
import com.ty.Springbootcoworkspaceapplication.service.RoomService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/room")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@Operation(description = "To Room the Building details",summary = "To save The Room into postresql db")
	@ApiResponses(value = @ApiResponse(description ="RoomSaved",responseCode = "201") )
	@PostMapping
	public ResponseEntity<ResponseStructure<Room>> saveRoom(@RequestBody Room room)
	{
		return roomService.saveRoom(room);
	}
	
	@Operation(description = "To save the Room details with spaceific workspaceId",summary = "To save The Room into postresql db by Specific workspaceId")
	@ApiResponses(value = @ApiResponse(description ="RoomSaved",responseCode = "201") )
	@PostMapping("/{workspaceId}")
	public ResponseEntity<ResponseStructure<WorkSpace>> saveRoom(@RequestBody Room room,@PathVariable int workspaceId )
	{
		return roomService.saveRoom(room,workspaceId);
	}
	
	@Operation(description = "To Update the Room detail",summary = "To Update the Room detail into postresql db")
	@ApiResponses(value = @ApiResponse(description ="RoomUpdated",responseCode = "200") )
	@PutMapping
	public ResponseEntity<ResponseStructure<Room>> updateRoom(@RequestBody Room room)
	{
		return roomService.updateRoom(room);
	}
	
	@Operation(description = "To delete the Room by id ",summary = "To delete the Room by id into postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="RoomDeleted",responseCode = "200") )
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteRoomById(@PathVariable int id)
	{
		return roomService.deleteRoomById(id);
	}
	
	@Operation(description = "To delete the Room by id ",summary = "To delete the Room by id into postresql db by id of specific workspaceId")
	@ApiResponses(value = @ApiResponse(description ="RoomDeleted",responseCode = "200") )
	@DeleteMapping("/{workspaceId}/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteRoomById(@PathVariable int workspaceId,@PathVariable int id)
	{
		return roomService.deleteRoomById(workspaceId,id);
	}
	
	@Operation(description = "To find the Room detail by id",summary = "To find The Room from postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="RoomFound",responseCode = "200") )
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Room>> findById(@PathVariable int id)
	{
		return roomService.findRoomById(id);
	}
	
	@Operation(description = "To find All the Room details",summary = "To find All The Room details into postresql db")
	@ApiResponses(value = @ApiResponse(description ="RoomFound",responseCode = "302") )
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Room>>> findAllRoom()
	{
		return roomService.findAllRoom();
	}

}
