package com.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcm.model.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

}
