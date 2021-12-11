package com.hcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.NoArgsConstructor;

@Entity
@Table(name="OPERATION")
@NoArgsConstructor
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="OP_ID")
	private Long oid;
	
	@Column(name="OP_NAME")
	private String opName;
	
	
//	private Patient patient;
//	
//	
//	private Doctor doctor;

}
