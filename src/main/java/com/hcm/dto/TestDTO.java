package com.hcm.dto;

import java.util.Date;

import com.hcm.model.Doctor;

import lombok.Data;

@Data
public class TestDTO {
	
	private long tid;
	private String tName;
	private Date tDate;
	private Doctor doctor;

}
