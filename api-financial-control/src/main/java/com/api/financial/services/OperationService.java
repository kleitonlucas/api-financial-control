package com.api.financial.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.financial.models.entities.Operation;
import com.api.financial.models.entities.User;
import com.api.financial.repositories.OperationRepository;
import com.api.financial.repositories.UserRepository;

@Service
public class OperationService {

	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public Operation save(Operation operation) {
		return operationRepository.save(operation);
	}
	
	public Optional<User> findUserById(Integer id) {
		return userRepository.findById(id);
	}
	
	public List<Operation> findAllOperationUserById(Integer id) {
		return operationRepository.findByUserId(id);
	}
}
