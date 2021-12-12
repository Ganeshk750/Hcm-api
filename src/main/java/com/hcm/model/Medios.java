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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.NoArgsConstructor;

@Entity
@Table(name="MEDIOS")
public class Medios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MED_ID")
	private Long mId;
	
	@Column(name="MEDIOS_RECORD")
	private String mRec;
	
	@Column(name="MEDIOS_PRICE")
	private int mPrice;
	
	@Column(name="MEDIOS_QUANTITY")
	private int mQuentity;
	
	 @Column(name="MEDIOS_TOTAL")
	 private Long mTotal;
	 
	 @Temporal(TemporalType.DATE)
	 @Column(name = "MED_DATE")
	 private Date date;
	 
	 @OneToOne
	 @JoinColumn(name = "DOC_ID")
	 private Doctor doctor;
	 
	 @OneToOne
	 @JoinColumn(name = "pid")
	 private Patient patient;

	public Long getmId() {
		return mId;
	}

	public void setmId(Long mId) {
		this.mId = mId;
	}

	public String getmRec() {
		return mRec;
	}

	public void setmRec(String mRec) {
		this.mRec = mRec;
	}

	public int getmPrice() {
		return mPrice;
	}

	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}

	public int getmQuentity() {
		return mQuentity;
	}

	public void setmQuentity(int mQuentity) {
		this.mQuentity = mQuentity;
	}

	public Long getmTotal() {
		return mTotal;
	}

	public void setmTotal(Long mTotal) {
		this.mTotal = mTotal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
	  
}
