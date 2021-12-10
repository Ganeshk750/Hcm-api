package com.hcm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcm.model.ERole;
import com.hcm.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	
	Optional<Role> findByName(ERole name);
}

