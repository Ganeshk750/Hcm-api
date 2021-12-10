package com.hcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="EMPLOYEE")
@NoArgsConstructor
@Getter
@Setter
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
	
	@OneToOne
	@JoinColumn(name="DEPT_ID")
	private Department dept;
	

}
