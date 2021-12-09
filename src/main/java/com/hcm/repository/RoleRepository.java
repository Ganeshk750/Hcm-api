package com.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcm.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
