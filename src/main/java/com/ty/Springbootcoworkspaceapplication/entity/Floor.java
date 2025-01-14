package com.ty.Springbootcoworkspaceapplication.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Floor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int floorId;
	@OneToMany(cascade = CascadeType.ALL)
	private List<WorkSpace> workspaces;

}
