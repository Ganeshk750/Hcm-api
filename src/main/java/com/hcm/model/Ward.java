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
@Table(name="WARD")
@NoArgsConstructor
@Setter
@Getter
public class Ward {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="WARD_ID")
	private Long wid;
	
	@Column(name="WARD_NAME")
	private String wardName;
	
	@OneToOne
	@JoinColumn(name="pid")
	private Patient patient;
	
	@OneToOne
	@JoinColumn(name="DOC_ID")
	private Doctor doctor;
}
