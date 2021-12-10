package com.hcm.dto;

import com.hcm.model.Patient;

import lombok.Data;

@Data
public class InsuranceDTO {
	
	private long iNo;
	private double iAmt;
	private String iExpiryDate;
	private Patient patient;
	

}
