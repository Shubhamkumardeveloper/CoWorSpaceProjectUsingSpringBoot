package com.ty.Springbootcoworkspaceapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.Springbootcoworkspaceapplication.dao.UsersDao;
import com.ty.Springbootcoworkspaceapplication.dto.ResponseStructure;
import com.ty.Springbootcoworkspaceapplication.entity.CoWorkSpace;
import com.ty.Springbootcoworkspaceapplication.entity.Users;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchIdFoundException;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchWorkSpaceException;

@Service
public class UsersService {
	
	@Autowired
	private UsersDao usersDao;
	
	public ResponseEntity<ResponseStructure<Users>> saveUsers(Users users)
	{
		Users user = usersDao.saveUsers(users);
		ResponseStructure<Users> rs=new ResponseStructure<>();
		if(user!=null)
		{
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setMessage("CoWorkSpace save Successfully..");
			rs.setData(user);
			return new ResponseEntity<ResponseStructure<Users>>(rs,HttpStatus.CREATED);
		}
		rs.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		rs.setMessage("can't save Users ..");
		rs.setData(null);
		return new ResponseEntity<ResponseStructure<Users>>(rs,HttpStatus.NOT_ACCEPTABLE);
			
	}
	
	public ResponseEntity<ResponseStructure<Users>> findUserById(int id)
	{
		Optional<Users> optional= usersDao.findUserById(id);
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		ResponseStructure<Users> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("User fetched..");
		rs.setData(optional.get());
		return new ResponseEntity<ResponseStructure<Users>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Users>> updateUser(Users users)
	{
		Users user = usersDao.updateUser(users);
		if(user==null)
			throw new NoSuchWorkSpaceException();
		ResponseStructure<Users> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("CoWokSpace Update Succesfully..");
		rs.setData(user);
		return new ResponseEntity<ResponseStructure<Users>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteUserById(int id)
	{
		Optional<Users> optional= usersDao.findUserById(id);
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		usersDao.deleteUserById(id);
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Deleted..");
		rs.setData("User Deleted...");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Users>>> findAllUser()
	{
		List<Users> List=usersDao.findAllUser();
		if(List.isEmpty())
			throw new NoSuchWorkSpaceException();
		ResponseStructure<List<Users>> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("company fetched..");
		rs.setData(List);
		return new ResponseEntity<ResponseStructure<List<Users>>>(rs,HttpStatus.OK);
	}

}
