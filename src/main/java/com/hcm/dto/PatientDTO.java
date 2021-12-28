package com.hcm.dto;

import com.hcm.model.Doctor;
import com.hcm.model.Test;

import lombok.Data;


@Data
public class PatientDTO {
	
	private long pid;
	private String pName;
	private String pDob;
	private String pAdd;
	private long pMobileNo;
	private Doctor doc;
	private Test test;

}
