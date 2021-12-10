package com.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcm.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
