package com.ty.Springbootcoworkspaceapplication.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.Springbootcoworkspaceapplication.dao.CompanyDao;
import com.ty.Springbootcoworkspaceapplication.dto.ResponseStructure;
import com.ty.Springbootcoworkspaceapplication.entity.Company;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchCompanyException;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchIdFoundException;
import com.ty.Springbootcoworkspaceapplication.exception.NoSuchRoomException;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyDao companyDao;
	public ResponseEntity<ResponseStructure<Company>> saveCompany(Company company)
	{
		Company resDao=companyDao.saveCompany(company);
		ResponseStructure<Company> rs=new ResponseStructure<>();
		if(resDao!=null)
		{
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setMessage("Company save Successfully..");
			rs.setData(resDao);
			return new ResponseEntity<ResponseStructure<Company>>(rs,HttpStatus.CREATED);
		}
		rs.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		rs.setMessage("can't save Company ..");
		rs.setData(null);
		return new ResponseEntity<ResponseStructure<Company>>(rs,HttpStatus.NOT_ACCEPTABLE);
			
	}
	
	public ResponseEntity<ResponseStructure<Company>> updateCompany(Company company)
	{
		Company resDao= companyDao.updateCompany(company);
		if(resDao==null)
			throw new NoSuchCompanyException();
		ResponseStructure<Company> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Room Update Succesfully..");
		rs.setData(resDao);
		return new ResponseEntity<ResponseStructure<Company>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteCompanyById(int id)
	{
		Optional<Company> optional= companyDao.findById(id);
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		else
			companyDao.deleteCompanyById(id);
		ResponseStructure<String> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Deleted..");
		rs.setData("company Deleted...");
		return new ResponseEntity<ResponseStructure<String>>(rs,HttpStatus.OK);
	}
	
	public  ResponseEntity<ResponseStructure<Company>> findById(int id)
	{
		Optional<Company> optional= companyDao.findById(id);
		if(optional.isEmpty())
			throw new NoSuchIdFoundException();
		ResponseStructure<Company> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Room fetched..");
		rs.setData(optional.get());
		return new ResponseEntity<ResponseStructure<Company>>(rs,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Company>>> FindAllCompany()
	{
		List<Company> List= companyDao.FindAllCompany();
		if(List.isEmpty())
			throw new NoSuchCompanyException();
		ResponseStructure<List<Company>> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("company fetched..");
		rs.setData(List);
		return new ResponseEntity<ResponseStructure<List<Company>>>(rs,HttpStatus.OK);
	}
}
