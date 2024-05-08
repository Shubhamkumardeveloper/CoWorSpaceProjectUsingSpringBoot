package com.ty.Springbootcoworkspaceapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Springbootcoworkspaceapplication.entity.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
