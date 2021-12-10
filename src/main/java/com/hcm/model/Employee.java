package com.hcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name="EMPLOYEE")
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EMPLOYEE_ID")
	private Long eId;
	
	@Column(name="EMPLOYEE_NAME")
	private String empName;
	
	@Column(name="EMPLOYEE_MOB")
	private Long empMob;
	
	@Column(name="EMPLOYEE_ADDRESS")
	private String empAddress;
	
	private Department dept;
	

}
