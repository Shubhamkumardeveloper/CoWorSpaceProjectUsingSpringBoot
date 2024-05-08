package com.ty.Springbootcoworkspaceapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Springbootcoworkspaceapplication.dao.CompanyDao;
import com.ty.Springbootcoworkspaceapplication.dao.FloorDao;
import com.ty.Springbootcoworkspaceapplication.dao.WorkSpaceDao;
import com.ty.Springbootcoworkspaceapplication.dto.ResponseStructure;
import com.ty.Springbootcoworkspaceapplication.entity.Building;
import com.ty.Springbootcoworkspaceapplication.entity.CoWorkSpace;
import com.ty.Springbootcoworkspaceapplication.entity.Company;
import com.ty.Springbootcoworkspaceapplication.entity.Floor;
import com.ty.Springbootcoworkspaceapplication.entity.WorkSpace;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchCompanyException;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchIdFoundException;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchWorkSpaceException;

@Service
public class WorkSpaceService {

	@Autowired
	private WorkSpaceDao workSpaceDao;
	
	@Autowired
	private FloorDao floorDao;
	
	public ResponseEntity<ResponseStructure<WorkSpace>> saveWorkSpace(WorkSpace workSpace) {
		WorkSpace resDao = workSpaceDao.saveWorkSpace(workSpace);
		ResponseStructure<WorkSpace> rs = new ResponseStructure<>();
		if (resDao != null) {
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setMessage("WorkSpace save Successfully..");
			rs.setData(resDao);
			return new ResponseEntity<ResponseStructure<WorkSpace>>(rs, HttpStatus.CREATED);
		}
		rs.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		rs.setMessage("can't save Company ..");
		rs.setData(null);
		return new ResponseEntity<ResponseStructure<WorkSpace>>(rs, HttpStatus.NOT_ACCEPTABLE);
	}

	public ResponseEntity<ResponseStructure<WorkSpace>> updateWorkSpace(WorkSpace workSpace) {
		WorkSpace resDao = workSpaceDao.updateWorkSpace(workSpace);
		if (resDao == null)
			throw new NoSuchWorkSpaceException();
		ResponseStructure<WorkSpace> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Room Update Succesfully..");
		rs.setData(resDao);
		return new ResponseEntity<ResponseStructure<WorkSpace>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteWorkSpaceById(int id) {
		Optional<WorkSpace> optional = workSpaceDao.findWorkSpaceById(id);
		if (optional.isEmpty())
			throw new NoSuchIdFoundException();
		else
			workSpaceDao.deleteWorkSpaceById(id);
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Deleted..");
		rs.setData("WorkSpace Deleted...");
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<WorkSpace>> findWorkSpaceById(int id) {
		Optional<WorkSpace> optional = workSpaceDao.findWorkSpaceById(id);
		if (optional.isEmpty())
			throw new NoSuchIdFoundException();
		ResponseStructure<WorkSpace> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Company fetched..");
		rs.setData(optional.get());
		return new ResponseEntity<ResponseStructure<WorkSpace>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<WorkSpace>>> FindAllWorkSpace() {
		List<WorkSpace> List = workSpaceDao.FindAllWorkSpace();
		if (List.isEmpty())
			throw new NoSuchCompanyException();
		ResponseStructure<List<WorkSpace>> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("WorkSpace fetched..");
		rs.setData(List);
		return new ResponseEntity<ResponseStructure<List<WorkSpace>>>(rs, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Floor>> saveWorkSpace(WorkSpace workSpace, int floorId) {
		
		Optional<Floor> optional = floorDao.findFloorById(floorId);
		ResponseStructure<Floor> rs=new ResponseStructure<>();
		if(!optional.isPresent())
			throw new NoSuchIdFoundException();
		Floor floor = optional.get();
		List<WorkSpace> list= floor.getWorkspaces();
		if(!list.isEmpty())
		{
			list.add(workSpace);
			floor.setWorkspaces(list);
		}
		else
		{
			ArrayList<WorkSpace> list2=new ArrayList<>();
			list2.add(workSpace);
			floor.setWorkspaces(list2);
		}
		floor= floorDao.savefloor(floor);
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("Bulding save Successfully..");
		rs.setData(floor);
		return new ResponseEntity<ResponseStructure<Floor>>(rs,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<String>> deleteWorkSpaceById(int floorId, int id) {
		
		Optional<Floor> optional = floorDao.findFloorById(floorId);
		Optional<WorkSpace> optional2 = workSpaceDao.findWorkSpaceById(id);
		
		if (optional.isEmpty())
			throw new NoSuchIdFoundException();
		if (optional2.isEmpty())
			throw new NoSuchIdFoundException();
		
		Floor floor = optional.get();
		WorkSpace workspace = optional2.get();
		
		List<WorkSpace> workspaces = floor.getWorkspaces();
		workspaces.remove(workspace);
		
		floor.setWorkspaces(workspaces);
		floorDao.updateFloor(floor);
		workSpaceDao.deleteWorkSpaceById(id);
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Deleted..");
		rs.setData("WorkSpace Deleted...");
		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
	}
}
