package com.api.financial.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.financial.models.dtos.OperationDto;
import com.api.financial.models.entities.Operation;
import com.api.financial.models.entities.User;
import com.api.financial.services.OperationService;

@RestController
@RequestMapping("/financial-control/operations")
public class OperationController {

	@Autowired
	OperationService operationService;
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody @Valid OperationDto operationDto) {
		Optional<User> userOptional = operationService.findUserById(operationDto.getUser());
		if(!userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
		Operation operation = new Operation();
		BeanUtils.copyProperties(operationDto, operation);
		operation.setUser(userOptional.get());
		
		return ResponseEntity.status(HttpStatus.OK).body(operationService.save(operation));
	}
	
	/**
	 * Retorna todos as operações de um determinado usuário
	 * **/
	@GetMapping("{userId}")
	public ResponseEntity<Object> findUserOperation(@PathVariable(value = "userId") Integer id) {
		Optional<User> userOptional = operationService.findUserById(id);
		if(!userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
		
		List<Operation> userOperations = operationService.findAllOperationUserById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(userOperations);
	}
	
	/**
	 * Retorna os operações de um usuário de acordo com o mês
	 * **/
	@GetMapping("/{userId}/{month}")
	public ResponseEntity<Object> findOperationByMonth(@PathVariable(value = "userId") Integer id,
																@PathVariable(value = "month") Integer month) {
		Optional<User> userOptional = operationService.findUserById(id);
		if(!userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
		
		List<Operation> userOperations = operationService.findAllOperationUserById(id);
		List<Operation> operationsByMonth = new ArrayList<Operation>();
		for(Operation operation : userOperations) {
			if(operation.getDateOperation().getMonthValue()==month) {
				operationsByMonth.add(operation);
			}
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(operationsByMonth);
	}
}
