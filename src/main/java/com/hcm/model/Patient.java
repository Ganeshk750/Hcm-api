package com.hcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name="PATIENT")
@NoArgsConstructor
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private Long pid;
	
	@Column(name="pname")
	private String pName;
	
	@Column(name="pdob")
	private String pDob;
	
	@Column(name="paddress")
	private String pAddress;
	
	@Column(name="pmobile")
	private Long pMobileNo;
	
//	private Doctor doc;
//	
//	
//	private Test test;

}
