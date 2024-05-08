package com.ty.Springbootcoworkspaceapplication.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkSpace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workspaceId;
	@OneToOne(cascade = CascadeType.ALL)
	private Company company;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Room> rooms;
	

}
