package com.api.financial.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.financial.models.entities.User;
import com.api.financial.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}
	
	@Transactional
	public void delete(User user) {
		userRepository.delete(user);
	}
}
