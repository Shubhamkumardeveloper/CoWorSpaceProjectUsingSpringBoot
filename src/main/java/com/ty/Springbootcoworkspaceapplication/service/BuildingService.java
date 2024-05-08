package com.ty.Springbootcoworkspaceapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Springbootcoworkspaceapplication.dao.BuildingDao;
import com.ty.Springbootcoworkspaceapplication.dao.CoWorkSpaceDao;
import com.ty.Springbootcoworkspaceapplication.dto.ResponseStructure;
import com.ty.Springbootcoworkspaceapplication.entity.Building;
import com.ty.Springbootcoworkspaceapplication.entity.CoWorkSpace;
import com.ty.Springbootcoworkspaceapplication.exception.NoBuildingFoundException;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchIdFoundException;

@Service
public class BuildingService {
	
	@Autowired
	private BuildingDao buildingDao;
	
	@Autowired
	private CoWorkSpaceDao coWorkSpaceDao;
	
	public ResponseEntity<ResponseStructure<Building>> saveCoWorkSpace(Building building)
	{
		Building buildDao = buildingDao.saveBuilding(building);
		ResponseStructure<Building> rs=new ResponseStructure<>();
		if(buildDao!=null)
		{
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setMessage("Bulding save Successfully..");
			rs.setData(buildDao);
			return new ResponseEntity<ResponseStructure<Building>>(rs,HttpStatus.CREATED);
		}
		
		rs.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		rs.setMessage("can't save Building ..");
		rs.setData(null);
		return new ResponseEntity<ResponseStructure<Building>>(rs,HttpStatus.NOT_ACCEPTABLE);
	}
	
	public ResponseEntity<ResponseStructure<List<Building>>> findAllBuilding()
	{
		List<Building> listDao= buildingDao.findAllBuilding();
		if(listDao.isEmpty())
			throw new NoBuildingFoundException();
		ResponseStructure<List<Building>> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Building fetched..");
		rs.setData(listDao);
		return new ResponseEntity<ResponseStructure<List<Building>>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Building>> updateBuilding(Building building)
	{
		Building builDao= buildingDao.updateBuilding(building);
		if(builDao==null)
			throw new NoBuildingFoundException();
		ResponseStructure<Building> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Building Update Succesfully..");
		rs.setData(builDao);
		return new ResponseEntity<ResponseStructure<Building>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteBuildingById(int id)
	{
		Optional<Building> optional= buildingDao.findBuildingById(id);
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		buildingDao.deleteBuildingById(id);
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Deleted..");
		rs.setData("Bulding Deleted...");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Building>> findBuildingById(int id)
	{
		Optional<Building> optional= buildingDao.findBuildingById(id);
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		ResponseStructure<Building> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Building fetched..");
		rs.setData(optional.get());
		return new ResponseEntity<ResponseStructure<Building>>(rs,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<CoWorkSpace>> saveCoWorkSpace(Building building, int coworkspaceId) 
	{
		Optional<CoWorkSpace> optional= coWorkSpaceDao.findCoWorkSpaceById(coworkspaceId);
		ResponseStructure<CoWorkSpace> rs=new ResponseStructure<>();
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		CoWorkSpace coworkspace = optional.get();
		List<Building> list= coworkspace.getBuilding();
		if(!list.isEmpty())
		{
			list.add(building);
			coworkspace.setBuilding(list);
		}
		else
		{
			ArrayList<Building> list2=new ArrayList<>();
			list2.add(building);
			coworkspace.setBuilding(list2);
		}
		CoWorkSpace coWorkSpace = coWorkSpaceDao.saveCoWorkSpace(coworkspace);
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("Bulding save Successfully..");
		rs.setData(coWorkSpace);
		return new ResponseEntity<ResponseStructure<CoWorkSpace>>(rs,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<String>> deleteBuildingById(int coworkspaceId, int id) {
		
		Optional<CoWorkSpace> optional=coWorkSpaceDao.findCoWorkSpaceById(id);
		Optional<Building> optional2= buildingDao.findBuildingById(id);
		
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		if(optional2.isEmpty())
			throw new NoSuchIdFoundException();
		
		CoWorkSpace coWorkSpace=optional.get();
		Building building=optional2.get();
		
		List<Building> buildings= coWorkSpace.getBuilding();
		buildings.remove(building);
		
		coWorkSpace.setBuilding(buildings);//up
		coWorkSpaceDao.updateCoWorkSpace(coWorkSpace);
		
		buildingDao.deleteBuildingById(id);
		
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Deleted..");
		rs.setData("Bulding Deleted...");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}
}
