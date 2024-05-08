package com.ty.Springbootcoworkspaceapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Springbootcoworkspaceapplication.entity.WorkSpace;
import com.ty.Springbootcoworkspaceapplication.repository.WorkSpaceRepository;

@Repository
public class WorkSpaceDao {
	
	@Autowired
	private WorkSpaceRepository workSpaceRepository;
	
	public WorkSpace saveWorkSpace(WorkSpace workSpace)
	{
		return workSpaceRepository.save(workSpace);
	}
	
	public WorkSpace updateWorkSpace(WorkSpace workSpace)
	{
		return workSpaceRepository.save(workSpace);
	}
	
	public void deleteWorkSpaceById(int id)
	{
		workSpaceRepository.deleteById(id);
	}
	
	public Optional<WorkSpace> findWorkSpaceById(int id)
	{
		return workSpaceRepository.findById(id);
	}
	
	public List<WorkSpace> FindAllWorkSpace()
	{
		return workSpaceRepository.findAll();
	}

}
