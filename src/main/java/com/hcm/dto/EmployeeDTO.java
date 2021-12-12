package com.hcm.dto;

import com.hcm.model.Department;
import com.hcm.model.Employee;

public class EmployeeDTO {
	private long empId;
    private String empName;
	private long empMobileNo;
	private String empAdd;
	private Department department;
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public long getEmpMobileNo() {
		return empMobileNo;
	}
	public void setEmpMobileNo(long empMobileNo) {
		this.empMobileNo = empMobileNo;
	}
	public String getEmpAdd() {
		return empAdd;
	}
	public void setEmpAdd(String empAdd) {
		this.empAdd = empAdd;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public EmployeeDTO(Employee employee) {
		this.empId =employee.getEmpId(); 
		this.empName = employee.getEmpName();
		this.empMobileNo = employee.getEmpMob();
		this.empAdd = employee.getEmpAddress();
		this.department = employee.getDept();
	}
	public EmployeeDTO() {
	
	}
	

}
