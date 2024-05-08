package com.ty.Springbootcoworkspaceapplication.entity;

import com.ty.Springbootcoworkspaceapplication.util.Type;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;
	@OneToOne(cascade = CascadeType.ALL)
	private Facilitie facilities;
	@Enumerated(EnumType.STRING)
	private Type type;

}
