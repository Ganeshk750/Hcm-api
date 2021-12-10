package com.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcm.model.Department;

public interface DepartmentRepositrory extends JpaRepository<Department, Long> {

}
