package com.hcm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PATIENT")
@NoArgsConstructor
@Setter
@Getter
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private Long pid;
	
	@Column(name="pname")
	private String pName;
	
	@Column(name="pdob")
	private String pDob;
	
	@Column(name="paddress")
	private String pAddress;
	
	@Column(name="pmobile")
	private Long pMobileNo;
	
	@OneToOne
	@JoinColumn(name="DOC_ID")
	private Doctor doc;
	
	
	@OneToOne
	@JoinColumn(name="tid")
	private Test test;

}
