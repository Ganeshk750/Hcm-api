package com.hcm.dto;

import java.util.Date;

import com.hcm.model.Bill;
import com.hcm.model.Insurance;
import com.hcm.model.Patient;

public class BillDTO {
	
	private long bId;
	private double bAmt;
	private boolean isInsuared;
	private Insurance insurance;
	private Patient patient;
	private Date billDate;
	
	public long getbId() {
		return bId;
	}
	
	public void setbId(long bId) {
		this.bId = bId;
	}

	public double getbAmt() {
		return bAmt;
	}

	public void setbAmt(double bAmt) {
		this.bAmt = bAmt;
	}

	public boolean isInsuared() {
		return isInsuared;
	}

	public void setInsuared(boolean isInsuared) {
		this.isInsuared = isInsuared;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public BillDTO(Bill bill) {

		this.bId = bill.getbId();
		this.bAmt = bill.getBillAmmount();
		this.isInsuared = bill.isBillInsuared();
		this.insurance = bill.getInsurance();
		this.patient = bill.getPatient();
		this.billDate = bill.getBillDate();
	}
	
	public BillDTO() {
	}
	
}
