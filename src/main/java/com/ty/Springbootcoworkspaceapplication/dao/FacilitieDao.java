package com.ty.Springbootcoworkspaceapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Springbootcoworkspaceapplication.entity.Facilitie;
import com.ty.Springbootcoworkspaceapplication.repository.FaciliteRepository;

@Repository
public class FacilitieDao {
	
	@Autowired
	private FaciliteRepository faciliteRepository;
	
	public Facilitie saveFacilite(Facilitie facilitie)
	{
		return faciliteRepository.save(facilitie);
	}
	
	public Facilitie updateFacilite(Facilitie facilitie)
	{
		return faciliteRepository.save(facilitie);
	}
	
	public void deleteFaciliteById(int id)
	{
		faciliteRepository.deleteById(id);
	}
	
	public Optional<Facilitie> findFaciliteById(int id)
	{
		return faciliteRepository.findById(id);
	}
	
	public List<Facilitie> findAllFacilite()
	{
		return faciliteRepository.findAll();
	}

}
