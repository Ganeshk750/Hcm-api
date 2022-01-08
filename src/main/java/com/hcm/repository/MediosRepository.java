package com.hcm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcm.model.Medicos;

public interface MediosRepository extends JpaRepository<Medicos, Long> {

	public List<Medicos> findAllByPatientPid(Long pid);
	
}
