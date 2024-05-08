package com.ty.Springbootcoworkspaceapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Springbootcoworkspaceapplication.entity.Users;
import com.ty.Springbootcoworkspaceapplication.repository.UsersRepository;

@Repository
public class UsersDao {
	
	@Autowired
	private UsersRepository usersRepository;
	
	public Users saveUsers(Users users)
	{
		return usersRepository.save(users);
	}
	
	public Optional<Users> findUserById(int id)
	{
		return usersRepository.findById(id);
	}
	
	public Users updateUser(Users users)
	{
		return usersRepository.save(users);
	}
	
	public void deleteUserById(int id)
	{
		usersRepository.deleteById(id);
	}
	
	public List<Users> findAllUser()
	{
		return usersRepository.findAll();
	}
}
