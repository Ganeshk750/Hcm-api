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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="MEDIOS")
@NoArgsConstructor
@Getter
@Setter
public class Medios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MEDIOS_ID")
	private Long medId;
	
	@Column(name="MEDIOS_RECORD")
	private String mRecord;
	
	@Column(name="MEDIOS_PRICE")
	private int mPrice;
	
	@Column(name="MEDIOS_QUANTITY")
	private int mQuentity;
	
	 @Column(name="MEDIOS_TOTAL")
	 private Long mTotal;
	
	 @Temporal(TemporalType.DATE)
	 @Column(name="MED_DATE")
	 private Date date;
	 
	 @OneToOne
	 @JoinColumn(name="DOC_ID")
	 private Doctor doctor;
	 
	 @OneToOne
	 @JoinColumn(name="pid")
	 private Patient patient;

}
