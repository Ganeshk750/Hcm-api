package com.hcm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcm.model.Medios;

public interface MediosRepository extends JpaRepository<Medios, Long> {

	public List<Medios> findAllByPatientPid(Long pid);
}
