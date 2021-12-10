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
import lombok.ToString;

@Entity
@Table(name="TEST")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tid")
	private Long tid;
	
	@Column(name="tName")
	private String tName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="tDate")
	private Date tDate;
	
	@OneToOne
	@JoinColumn(name="DOC_ID")
	private Doctor doctor;
	
	

}
