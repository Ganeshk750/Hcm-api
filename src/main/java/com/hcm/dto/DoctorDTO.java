package com.hcm.dto;

import com.hcm.model.Department;
import com.hcm.model.Specialization;

import lombok.Data;

@Data
public class DoctorDTO {
	
	private long doctorId;
	private String doctorName;
	private String doctorAddress;
	private long doctorPhoneNo;
	private Department department;
	private Specialization specialization;

}
