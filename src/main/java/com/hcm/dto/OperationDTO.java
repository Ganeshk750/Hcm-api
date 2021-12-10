package com.hcm.dto;

import com.hcm.model.Doctor;
import com.hcm.model.Patient;

import lombok.Data;

@Data
public class OperationDTO {
	
	private long oid;
	private String oName;
	private Patient patient;
	private Doctor doctor;
	

}
