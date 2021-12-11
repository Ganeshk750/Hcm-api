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
@Table(name="BILL")
@NoArgsConstructor
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
}
