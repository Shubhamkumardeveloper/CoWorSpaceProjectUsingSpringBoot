package com.ty.Springbootcoworkspaceapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Springbootcoworkspaceapplication.entity.CoWorkSpace;
import com.ty.Springbootcoworkspaceapplication.repository.CoWorkSpaceRepository;

@Repository
public class CoWorkSpaceDao {
	
	@Autowired
	private CoWorkSpaceRepository coWorkSpaceRepository;
	
	public CoWorkSpace saveCoWorkSpace(CoWorkSpace coWorkSpace)
	{
		return coWorkSpaceRepository.save(coWorkSpace);
	}
	
	public CoWorkSpace updateCoWorkSpace(CoWorkSpace coWorkSpace)
	{
		return coWorkSpaceRepository.save(coWorkSpace);
	}
	
	public Optional<CoWorkSpace> findCoWorkSpaceById(int id)
	{
		return coWorkSpaceRepository.findById(id);
	}
	
	public boolean deleteCoWorkSpaceById(int id)
	{
		Optional<CoWorkSpace> opt= findCoWorkSpaceById(id);
		if(opt.isEmpty())
		{
			coWorkSpaceRepository.delete(opt.get());
			return true;
		}
		return false;
	}
	
	public List<CoWorkSpace> findAllCoWorkSpace()
	{
		return coWorkSpaceRepository.findAll();
	}
}
