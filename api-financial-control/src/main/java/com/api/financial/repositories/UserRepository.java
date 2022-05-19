package com.api.financial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.financial.models.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	boolean existsByEmail(String email);
}
