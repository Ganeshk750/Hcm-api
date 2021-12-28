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
@Table(name="OPERATION")
@NoArgsConstructor
@Setter
@Getter
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="OP_ID")
	private Long oid;
	
	@Column(name="OP_NAME")
	private String opName;
	
	@OneToOne
	@JoinColumn(name="pid")
	private Patient patient;
	
	
	@OneToOne
	@JoinColumn(name="DOC_ID")
	private Doctor doctor;

}
