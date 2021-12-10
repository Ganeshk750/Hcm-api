package com.hcm.dto;

import java.util.Date;

import com.hcm.model.Doctor;
import com.hcm.model.Patient;

import lombok.Data;

@Data
public class MedicosDTO {
	
	private long mId;
	private String mRecord;
	private Date date;
	private int price;
	private int quantity;
	private long total;
	private Doctor doctor;
	private Patient patient;

}
