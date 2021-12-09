package com.hcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name="WARD")
@NoArgsConstructor
public class Ward {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="WARD_ID")
	private Long wid;
	
	@Column(name="WARD_NAME")
	private String wardName;
	
	
	private Patient patient;
	
	
	private Doctor doctor;
}
