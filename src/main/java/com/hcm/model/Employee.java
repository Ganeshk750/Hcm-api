package com.hcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name="EMPLOYEE")
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Emp_Id")
	private Long empId;
	
	@Column(name="EMPLOYEE_NAME")
	private String empName;
	
	@Column(name="EMPLOYEE_MOB")
	private Long empMob;
	
	@Column(name="EMPLOYEE_ADDRESS")
	private String empAddress;
	
//	@OneToOne
//	@Column(name = "DEP_ID")
//	private Department dept;
	
	@OneToOne
	@JoinColumn(name = "DEP_ID")
	private Department dept;
	

}
