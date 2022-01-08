package com.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcm.model.Patient;

public interface PatientRepositoy extends JpaRepository<Patient, Long> {

	public Patient findByPMobileNo(Long pMobileNo);
	
}
