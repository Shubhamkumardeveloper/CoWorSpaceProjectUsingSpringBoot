package com.ty.Springbootcoworkspaceapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Springbootcoworkspaceapplication.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {

}
