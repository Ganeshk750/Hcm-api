package com.hcm.dto;

import java.util.Date;

import com.hcm.model.Doctor;
import com.hcm.model.Medios;
import com.hcm.model.Patient;

public class MedicosDTO {
	private long mId;
	private String mRecord;
	private Date date;
	private int price;
	private int quantity;
	private long total;
	private Doctor doctor;
	private Patient patient;
	public long getmId() {
		return mId;
	}
	public void setmId(long mId) {
		this.mId = mId;
	}
	public String getmRecord() {
		return mRecord;
	}
	public void setmRecord(String mRecord) {
		this.mRecord = mRecord;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public MedicosDTO(Medios medios) {
		this.mId = medios.getmId();
		this.mRecord = medios.getmRec();
		this.date = medios.getDate();
		this.price = medios.getmPrice();
		this.quantity = medios.getmPrice();
		this.total = medios.getmTotal();
		this.doctor = medios.getDoctor();
		this.patient = medios.getPatient();
	}
	public MedicosDTO() {
		
	}

}
