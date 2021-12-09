package com.hcm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcm.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
