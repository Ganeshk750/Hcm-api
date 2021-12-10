package com.hcm.dto;

import java.util.Date;

import com.hcm.model.Insurance;
import com.hcm.model.Patient;

import lombok.Data;

@Data
public class BillDTO {
	
	private long bId;
	private double bAmt;
	private boolean isInsured;
	private Insurance insurance;
	private Patient patient;
	private Date billDate;
	
	

}
