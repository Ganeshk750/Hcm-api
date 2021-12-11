package com.hcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.NoArgsConstructor;

@Entity
@Table(name="TEST")
@NoArgsConstructor
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tid")
	private Long tid;
	
	@Column(name="tName")
	private String tName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="tDate")
	private Date tDate;
	
	
	
//	private Doctor doctor;
	
	

}
