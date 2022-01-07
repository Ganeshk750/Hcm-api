package com.hcm.dto;

import com.hcm.model.Department;

import lombok.Data;

@Data
public class EmployeeDTO {
	
	private long empId;
	private String empName;
	private long empMobNo;
	private String empAdd;
	private Department department;
	

}
