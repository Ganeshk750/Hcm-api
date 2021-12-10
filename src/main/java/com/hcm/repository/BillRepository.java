package com.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcm.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{

}
