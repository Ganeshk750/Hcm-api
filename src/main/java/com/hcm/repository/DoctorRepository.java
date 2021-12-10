package com.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcm.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
