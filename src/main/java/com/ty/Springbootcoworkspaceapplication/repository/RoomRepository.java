package com.ty.Springbootcoworkspaceapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.Springbootcoworkspaceapplication.entity.Room;

public interface RoomRepository extends JpaRepository<Room,Integer> {

}
