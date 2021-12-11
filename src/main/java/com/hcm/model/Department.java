package com.hcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name="DEPARTMENT")
@NoArgsConstructor
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEP_ID")
	private Long deptId;
	
	@Column(name="DEPARTMENT_NAME")
	private String deptName;

}
