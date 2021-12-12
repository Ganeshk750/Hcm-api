package com.hcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BILL")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bill_Id")
	private Long bId;
	
	@Column(name="BILL_AMOUNT")
	private double billAmmount;
	
	@Column(name="BILL_INSURED")
	private boolean billInsuared;
	
	@Column(name="BILL_DATE")
	private Date billDate;
	
	@OneToOne
	@JoinColumn(name = "INS_NO")
	private Insurance insurance;
	
	@OneToOne
	@JoinColumn(name = "pid")
	private Patient patient;

	public Long getbId() {
		return bId;
	}

	public void setbId(Long bId) {
		this.bId = bId;
	}

	public double getBillAmmount() {
		return billAmmount;
	}

	public void setBillAmmount(double billAmmount) {
		this.billAmmount = billAmmount;
	}

	public boolean isBillInsuared() {
		return billInsuared;
	}

	public void setBillInsuared(boolean billInsuared) {
		this.billInsuared = billInsuared;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
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
	
	
}
