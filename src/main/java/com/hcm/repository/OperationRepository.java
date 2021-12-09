package com.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcm.model.Operation;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
