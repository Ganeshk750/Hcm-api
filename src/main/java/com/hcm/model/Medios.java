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

import lombok.NoArgsConstructor;

@Entity
@Table(name="MEDIOS")
@NoArgsConstructor
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
	
//	 private Date date;
	 
	 @OneToOne
	 @JoinColumn(name = "DOC_ID")
	 private Doctor doctor;
	 
	 @OneToOne
	 @JoinColumn(name = "pid")
	 private Patient patient;

}
