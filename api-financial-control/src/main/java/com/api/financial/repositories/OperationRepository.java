package com.api.financial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.financial.models.entities.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer>{
	
	List<Operation> findByUserId(Integer id);
}
