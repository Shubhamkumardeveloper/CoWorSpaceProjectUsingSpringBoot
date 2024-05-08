package com.ty.Springbootcoworkspaceapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Springbootcoworkspaceapplication.dao.CoWorkSpaceDao;
import com.ty.Springbootcoworkspaceapplication.dto.ResponseStructure;
import com.ty.Springbootcoworkspaceapplication.entity.CoWorkSpace;
import com.ty.Springbootcoworkspaceapplication.entity.Company;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchCompanyException;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchIdFoundException;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchWorkSpaceException;

@Service
public class CoWorkSpaceService {
	
	@Autowired
	private CoWorkSpaceDao coWorkSpaceDao;
	
	public ResponseEntity<ResponseStructure<CoWorkSpace>> saveCoWorkSpace(CoWorkSpace coWorkSpace)
	{
		CoWorkSpace coworkDao=coWorkSpaceDao.saveCoWorkSpace(coWorkSpace);
		ResponseStructure<CoWorkSpace> rs=new ResponseStructure<>();
		if(coworkDao!=null)
		{
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setMessage("CoWorkSpace save Successfully..");
			rs.setData(coworkDao);
			return new ResponseEntity<ResponseStructure<CoWorkSpace>>(rs,HttpStatus.CREATED);
		}
		rs.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		rs.setMessage("can't save Student ..");
		rs.setData(null);
		return new ResponseEntity<ResponseStructure<CoWorkSpace>>(rs,HttpStatus.NOT_ACCEPTABLE);
			
	}
	
	public ResponseEntity<ResponseStructure<CoWorkSpace>> findCoWorkSpaceById(int id)
	{
		Optional<CoWorkSpace> optional= coWorkSpaceDao.findCoWorkSpaceById(id);
		if(!optional.isPresent())
			throw new NoSuchIdFoundException();
		ResponseStructure<CoWorkSpace> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("CoWorkSpace fetched..");
		rs.setData(optional.get());
		return new ResponseEntity<ResponseStructure<CoWorkSpace>>(rs,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<CoWorkSpace>> updateCoWorkSpace(CoWorkSpace coWorkSpace)
	{
		CoWorkSpace cSpacedao= coWorkSpaceDao.updateCoWorkSpace(coWorkSpace);
		if(cSpacedao==null)
			throw new NoSuchWorkSpaceException();
		ResponseStructure<CoWorkSpace> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("CoWokSpace Update Succesfully..");
		rs.setData(cSpacedao);
		return new ResponseEntity<ResponseStructure<CoWorkSpace>>(rs,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteCoWorkSpace(int id)
	{
		Optional<CoWorkSpace> optional= coWorkSpaceDao.findCoWorkSpaceById(id);
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		coWorkSpaceDao.deleteCoWorkSpaceById(id);
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Deleted..");
		rs.setData("CoWorkSpace Deleted...");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<CoWorkSpace>>> findAllCoWorkSpace()
	{
		List<CoWorkSpace> List= coWorkSpaceDao.findAllCoWorkSpace();
		if(List.isEmpty())
			throw new NoSuchWorkSpaceException();
		ResponseStructure<List<CoWorkSpace>> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage("company fetched..");
		rs.setData(List);
		return new ResponseEntity<ResponseStructure<List<CoWorkSpace>>>(rs,HttpStatus.FOUND);
	}

}
