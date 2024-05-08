package com.ty.Springbootcoworkspaceapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Springbootcoworkspaceapplication.dao.RoomDao;
import com.ty.Springbootcoworkspaceapplication.dao.WorkSpaceDao;
import com.ty.Springbootcoworkspaceapplication.dto.ResponseStructure;
import com.ty.Springbootcoworkspaceapplication.entity.Building;
import com.ty.Springbootcoworkspaceapplication.entity.CoWorkSpace;
import com.ty.Springbootcoworkspaceapplication.entity.Room;
import com.ty.Springbootcoworkspaceapplication.entity.WorkSpace;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchIdFoundException;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchRoomException;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchWorkSpaceException;

@Service
public class RoomService {
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private WorkSpaceDao workSpaceDao;
	
	public ResponseEntity<ResponseStructure<Room>> saveRoom(Room room)
	{
		Room rdao= roomDao.saveRoom(room);
		ResponseStructure<Room> rs=new ResponseStructure<>();
		if(rdao!=null)
		{
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setMessage("Room save Successfully..");
			rs.setData(rdao);
			return new ResponseEntity<ResponseStructure<Room>>(rs,HttpStatus.CREATED);
		}
		rs.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		rs.setMessage("can't save Room ..");
		rs.setData(null);
		return new ResponseEntity<ResponseStructure<Room>>(rs,HttpStatus.NOT_ACCEPTABLE);
			
	}
	
	public ResponseEntity<ResponseStructure<Room>> updateRoom(Room room)
	{
		Room resDao= roomDao.updateRoom(room);
		if(resDao==null)
			throw new NoSuchRoomException();
		ResponseStructure<Room> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("Room Update Succesfully..");
		rs.setData(resDao);
		return new ResponseEntity<ResponseStructure<Room>>(rs,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Room>> findRoomById( int id)
	{
		Optional<Room> optional= roomDao.findRoomById(id);
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		ResponseStructure<Room> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Room fetched..");
		rs.setData(optional.get());
		return new ResponseEntity<ResponseStructure<Room>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteRoomById(int id)
	{
		Optional<Room> optional= roomDao.findRoomById(id);
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		else
			roomDao.deleteRoomById(id);
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Deleted..");
		rs.setData("Room Deleted...");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Room>>> findAllRoom()
	{
		List<Room> rList= roomDao.findAllRoom();
		if(rList.isEmpty())
			throw new NoSuchRoomException();
		ResponseStructure<List<Room>> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Room fetched..");
		rs.setData(rList);
		return new ResponseEntity<ResponseStructure<List<Room>>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<WorkSpace>> saveRoom(Room room, int workspaceId) {
		Optional<WorkSpace> optional = workSpaceDao.findWorkSpaceById(workspaceId);
		ResponseStructure<WorkSpace> rs=new ResponseStructure<>();
		if(!optional.isPresent())
			throw new NoSuchIdFoundException();
		WorkSpace workspace = optional.get();
		List<Room> list= workspace.getRooms();
		if(!list.isEmpty())
		{
			list.add(room);
			workspace.setRooms(list);
		}
		else
		{
			ArrayList<Room> list2=new ArrayList<>();
			list2.add(room);
			workspace.setRooms(list2);
		}
		workspace= workSpaceDao.saveWorkSpace(workspace);
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("Bulding save Successfully..");
		rs.setData(workspace);
		return new ResponseEntity<ResponseStructure<WorkSpace>>(rs,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteRoomById(int workspaceId, int id) {
		
		Optional<WorkSpace> optional = workSpaceDao.findWorkSpaceById(workspaceId);
		Optional<Room> optional2= roomDao.findRoomById(id);
		
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		if(optional2.isEmpty())
			throw new NoSuchIdFoundException();
		
		WorkSpace workspace = optional.get();
		Room room = optional2.get();
		
		List<Room> rooms = workspace.getRooms();
		rooms.remove(room);
		
		workspace.setRooms(rooms);
		workSpaceDao.updateWorkSpace(workspace);
		roomDao.deleteRoomById(id);
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Deleted..");
		rs.setData("Room Deleted...");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}

}
