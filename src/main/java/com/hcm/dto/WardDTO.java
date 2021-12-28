package com.hcm.dto;

import com.hcm.model.Doctor;
import com.hcm.model.Patient;

import lombok.Data;

@Data
public class WardDTO {
	
	private long wid;
	private String wardNumber;
    private Patient patient;
    private Doctor doctor;
}
