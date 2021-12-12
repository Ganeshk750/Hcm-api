package com.hcm.dto;

import com.hcm.model.Insurance;
import com.hcm.model.Patient;

public class InsuranceDTO {
	
	private long iNo;
	private double iAmt;
	private String iExpiryDate;
	private Patient patient;
	public long getiNo() {
		return iNo;
	}
	public void setiNo(long iNo) {
		this.iNo = iNo;
	}
	public double getiAmt() {
		return iAmt;
	}
	public void setiAmt(double iAmt) {
		this.iAmt = iAmt;
	}
	public String getiExpiryDate() {
		return iExpiryDate;
	}
	public void setiExpiryDate(String iExpiryDate) {
		this.iExpiryDate = iExpiryDate;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public InsuranceDTO(Insurance insurance) {
		this.iNo = insurance.getiNo();
		this.iAmt = insurance.getInsuranceAmmount();
		this.iExpiryDate = insurance.getInsuranceExp();
		this.patient = insurance.getPait();
	}
	public InsuranceDTO() {
		
	}
	
	
	

}
