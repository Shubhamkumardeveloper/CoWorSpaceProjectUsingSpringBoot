package com.ty.Springbootcoworkspaceapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Springbootcoworkspaceapplication.entity.Building;
import com.ty.Springbootcoworkspaceapplication.repository.BuildingRepository;

@Repository
public class BuildingDao {
	
	@Autowired
	private BuildingRepository buildingRepository;
	
	public Building saveBuilding(Building building)
	{
		return buildingRepository.save(building);
	}
	
	public Optional<Building> findBuildingById(int id)
	{
		return buildingRepository.findById(id);
	}
	
	public List<Building> findAllBuilding()
	{
		 return buildingRepository.findAll();
	}
	
	public Building updateBuilding(Building building)
	{
		return buildingRepository.save(building);
	}
	
	public boolean deleteBuildingById(int id)
	{
		Optional<Building> optional= buildingRepository.findById(id);
		if(optional.isPresent())
		{
			buildingRepository.delete(optional.get());
			return true;
		}
		return false;
	}
}
