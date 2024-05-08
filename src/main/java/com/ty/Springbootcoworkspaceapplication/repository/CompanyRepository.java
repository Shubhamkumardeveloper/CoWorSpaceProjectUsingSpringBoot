package com.ty.Springbootcoworkspaceapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Springbootcoworkspaceapplication.entity.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

}
