package com.ty.Springbootcoworkspaceapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Springbootcoworkspaceapplication.entity.Room;
import com.ty.Springbootcoworkspaceapplication.repository.RoomRepository;

@Repository
public class RoomDao {
	
	@Autowired
	private RoomRepository roomRepository;
	
	public Room saveRoom(Room room)
	{
		return roomRepository.save(room);
	}
	
	public Room updateRoom(Room room)
	{
		return roomRepository.save(room);
	}
	
	public Optional<Room> findRoomById( int id)
	{
		return roomRepository.findById(id);
	}
	
	public void deleteRoomById(int id)
	{
		roomRepository.deleteById(id);
	}
	
	public List<Room> findAllRoom()
	{
		return roomRepository.findAll();
	}
}
