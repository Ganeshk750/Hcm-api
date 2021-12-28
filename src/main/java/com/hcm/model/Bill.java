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

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="BILL")
@NoArgsConstructor
@Getter
@Setter
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="BILL_ID")
	private Long bId;
	
	@Column(name="BILL_AMOUNT")
	private double billAmmount;
	
	@Column(name="BILL_INSURED")
	private boolean billInsuared;
	
	@Temporal(TemporalType.DATE)
	@Column(name="BILL_DATE")
	private Date billDate;
	
	
	@OneToOne
	@JoinColumn(name="INS_NO")
	private Insurance insurance;
	
	@OneToOne
	@JoinColumn(name="pid")
	private Patient patient;
}
