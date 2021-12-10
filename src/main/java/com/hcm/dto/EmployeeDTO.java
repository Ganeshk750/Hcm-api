package com.hcm.dto;

import com.hcm.model.Department;

import lombok.Data;

@Data
public class EmployeeDTO {
	
	private long empId;
	private String empName;
	private String empMobileNo;
	private String empAdd;
	private Department department;
	

}
