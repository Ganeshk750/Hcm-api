package com.hcm.dto;

import java.util.Date;

import com.hcm.model.Bill;
import com.hcm.model.Insurance;
import com.hcm.model.Patient;

import lombok.Data;

@Data
public class BillDTO {
	
	private long bId;
	private double bAmt;
	private boolean isInsured;
	private Insurance ins;
	private Patient patient;
	private Date billDate;
	
	
	public BillDTO(Bill bill) {
		this.bId = bill.getBId();
		this.bAmt = bill.getBillAmmount();
		this.ins = bill.getInsurance();
		this.isInsured = bill.isBillInsuared();
		this.patient = bill.getPatient();
		this.billDate = bill.getBillDate();
	}
	
	
	
	
	

}
