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
@Table(name="BILL")
@NoArgsConstructor
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BILL_ID")
	private Long bId;
	
	@Column(name="BILL_AMOUNT")
	private double billAmmount;
	
	@Column(name="BILL_INSURED")
	private boolean billInsuared;
	
	@Column(name="BILL_DATE")
	private Date billDate;
	
	private Insurance insurance;
	
	private Patient patient;
}
