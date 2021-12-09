package com.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcm.model.Ward;

public interface WardRepository extends JpaRepository<Ward, Long> {

}
