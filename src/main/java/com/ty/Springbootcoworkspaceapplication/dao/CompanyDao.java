package com.ty.Springbootcoworkspaceapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Springbootcoworkspaceapplication.entity.Company;
import com.ty.Springbootcoworkspaceapplication.repository.CompanyRepository;

@Repository
public class CompanyDao {
	
	@Autowired
	private CompanyRepository companyRepository;
	public Company saveCompany(Company company)
	{
		return companyRepository.save(company);
	}
	
	public Company updateCompany(Company company)
	{
		return companyRepository.save(company);
	}
	
	public void deleteCompanyById(int id)
	{
		companyRepository.deleteById(id);
	}
	
	public  Optional<Company> findById(int id)
	{
		return companyRepository.findById(id);
	}
	
	public List<Company> FindAllCompany()
	{
		return companyRepository.findAll();
	}

}
