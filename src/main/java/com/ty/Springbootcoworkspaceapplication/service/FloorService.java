package com.ty.Springbootcoworkspaceapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Springbootcoworkspaceapplication.dao.BuildingDao;
import com.ty.Springbootcoworkspaceapplication.dao.FloorDao;
import com.ty.Springbootcoworkspaceapplication.dto.ResponseStructure;
import com.ty.Springbootcoworkspaceapplication.entity.Building;
import com.ty.Springbootcoworkspaceapplication.entity.CoWorkSpace;
import com.ty.Springbootcoworkspaceapplication.entity.Floor;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchFloorException;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchIdFoundException;

@Service
public class FloorService {
	
	@Autowired
	private FloorDao floorDao;
	
	@Autowired
	private BuildingDao buildingDao;
	
	public ResponseEntity<ResponseStructure<Floor>> savefloor(Floor floor)
	{
		Floor resDao=floorDao.savefloor(floor);
		ResponseStructure<Floor> rs=new ResponseStructure<>();
		if(resDao!=null)
		{
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setMessage("Floor save Successfully..");
			rs.setData(resDao);
			return new ResponseEntity<ResponseStructure<Floor>>(rs,HttpStatus.CREATED);
		}
		rs.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		rs.setMessage("can't save Company ..");
		rs.setData(null);
		return new ResponseEntity<ResponseStructure<Floor>>(rs,HttpStatus.NOT_ACCEPTABLE);
	}
	
	public ResponseEntity<ResponseStructure<Floor>> updateFloor(Floor floor)
	{
		Floor resDao=floorDao.updateFloor(floor);
		if(resDao==null)
			throw new NoSuchFloorException();
		ResponseStructure<Floor> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Floor Update Succesfully..");
		rs.setData(resDao);
		return new ResponseEntity<ResponseStructure<Floor>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteFloorById(int id)
	{
		Optional<Floor> optional= floorDao.findFloorById(id);
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		else
			floorDao.deleteFloorById(id);
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Deleted..");
		rs.setData("Floor Deleted...");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Floor>> findFloorById(int id)
	{
		Optional<Floor> optional= floorDao.findFloorById(id);
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		ResponseStructure<Floor> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Room fetched..");
		rs.setData(optional.get());
		return new ResponseEntity<ResponseStructure<Floor>>(rs,HttpStatus.OK); 
	}
	
	public ResponseEntity<ResponseStructure<List<Floor>>> findAllFloor()
	{
		List<Floor> List= floorDao.findAllFloor();
		if(List.isEmpty())
			throw new NoSuchFloorException();
		ResponseStructure<List<Floor>> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Floor fetched..");
		rs.setData(List);
		return new ResponseEntity<ResponseStructure<List<Floor>>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Building>> savefloor(Floor floor, int buildingId) {
		Optional<Building> optional= buildingDao.findBuildingById(buildingId);
		ResponseStructure<Building> rs=new ResponseStructure<>();
		if(!optional.isPresent())
			throw new NoSuchIdFoundException();
		Building building = optional.get();
		List<Floor> list= building.getFlores();
		if(!list.isEmpty())
		{
			list.add(floor);
			building.setFlores(list);
		}
		else
		{
			ArrayList<Floor> list2=new ArrayList<>();
			list2.add(floor);
			building.setFlores(list2);
		}
		Building building2 = buildingDao.saveBuilding(building);
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("floor save Successfully..");
		rs.setData(building2);
		return new ResponseEntity<ResponseStructure<Building>>(rs,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteFloorById(int buildingId, int id) {
		
		Optional<Building> optional = buildingDao.findBuildingById(buildingId);
		Optional<Floor> optional2 = floorDao.findFloorById(id);
		
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		if(optional2.isEmpty())
			throw new NoSuchIdFoundException();
		
		Building building =optional.get();
		Floor floor=optional2.get();
		
		 List<Floor> floors = building.getFlores();
		 floors.remove(floor);
		 building.setFlores(floors);
		 buildingDao.updateBuilding(building);
		floorDao.deleteFloorById(id);
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Deleted..");
		rs.setData("Floor Deleted...");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}

	

}
