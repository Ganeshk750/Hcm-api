package com.hcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name="DOCTOR")
@NoArgsConstructor
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DOCTOR_ID")
	private Long docId;
	
	@Column(name="DOCTROR_NAME")
	private String doctorName;
	
	@Column(name="DOCTROR_ADDRESS")
	private String doctorAddress;
	
	@Column(name="DOCTROR_PHONE")
	private Long phoneNo;
	
	private Department dept;
	
	private Specialization spec;
	

}
