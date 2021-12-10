package com.hcm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name="MEDIOS")
@NoArgsConstructor
public class Medios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MEDIOS_ID")
	private Long medId;
	
	@Column(name="MEDIOS_RECORD")
	private String mRec;
	
	@Column(name="MEDIOS_PRICE")
	private int mPrice;
	
	@Column(name="MEDIOS_QUANTITY")
	private int mQuentity;
	
	 @Column(name="MEDIOS_TOTAL")
	 private Long mTotal;
	
	 private Date date;
	 
	 private Doctor doctor;
	 
	 private Patient patient;

}
