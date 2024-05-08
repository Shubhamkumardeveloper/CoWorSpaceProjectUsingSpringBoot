package com.ty.Springbootcoworkspaceapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Springbootcoworkspaceapplication.entity.WorkSpace;

public interface WorkSpaceRepository extends JpaRepository<WorkSpace,Integer> {

}
