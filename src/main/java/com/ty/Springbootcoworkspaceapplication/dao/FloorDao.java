package com.ty.Springbootcoworkspaceapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Springbootcoworkspaceapplication.entity.Floor;
import com.ty.Springbootcoworkspaceapplication.repository.FloorRepository;

@Repository
public class FloorDao {
	
	@Autowired
	private FloorRepository floorRepository;

	public Floor savefloor(Floor floor)
	{
		return floorRepository.save(floor);
	}
	
	public Floor updateFloor(Floor floor)
	{
		return floorRepository.save(floor); 
	}
	
	public void deleteFloorById(int id)
	{
		 floorRepository.deleteById(id); 
	}
	
	public Optional<Floor> findFloorById(int id)
	{
		return floorRepository.findById(id); 
	}
	
	public List<Floor> findAllFloor()
	{
		return floorRepository.findAll();
	}
}
