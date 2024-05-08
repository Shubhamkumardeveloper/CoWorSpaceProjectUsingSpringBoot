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
import com.ty.Springbootcoworkspaceapplication.entity.Company;
import com.ty.Springbootcoworkspaceapplication.service.CompanyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@Operation(description = "To save the company details",summary = "To save The company into postresql db")
	@ApiResponses(value = @ApiResponse(description ="companySaved",responseCode = "201") )
	@PostMapping
	public ResponseEntity<ResponseStructure<Company>> saveCompany(@RequestBody Company company)
	{
		return companyService.saveCompany(company);
	}
	
	@Operation(description = "To Update the Company detail",summary = "To Update the Company detail into postresql db")
	@ApiResponses(value = @ApiResponse(description ="ComapnyUpdated",responseCode = "200") )
	@PutMapping
	public ResponseEntity<ResponseStructure<Company>> updateCompany(@RequestBody Company company)
	{
		return companyService.updateCompany(company);
	}
	
	@Operation(description = "To delete the Company by id ",summary = "To delete the company by id into postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="CompanyDeleted",responseCode = "200") )
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteCompanyById(@PathVariable int id)
	{
		return companyService.deleteCompanyById(id);
	}
	
	@Operation(description = "To delete the company by id ",summary = "To delete the company by id into postresql db by id")
	@ApiResponses(value = @ApiResponse(description ="companyDeleted",responseCode = "200") )
	@GetMapping("/{id}")
	public  ResponseEntity<ResponseStructure<Company>> findById(@PathVariable int id)
	{
		return companyService.findById(id);
	}
	
	@Operation(description = "To find All the Comapny details",summary = "To find All The Company details into postresql db")
	@ApiResponses(value = @ApiResponse(description ="CompanyFound",responseCode = "302") )
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Company>>> FindAllCompany()
	{
		return companyService.FindAllCompany();
	}

}
