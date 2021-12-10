package com.hcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name="INSURANCE")
@NoArgsConstructor
public class Insurance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="INSURANCE_ID")
	private Long iNo;
	
	@Column(name="insurance_AMOUNT")
	private double insuranceAmmount;
	
	@Column(name="INSURANCE_EXPIRY")
	private String insuranceExp;
	
    private Patient pait;
}
