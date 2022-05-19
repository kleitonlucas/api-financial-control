package com.api.financial.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.financial.models.entities.User;
import com.api.financial.services.UserService;

@RestController
@RequestMapping("/financial-control/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<Object> saveUser(@RequestBody @Valid User user) {
		if(userService.existsByEmail(user.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já cadastrado!");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUser(@PathVariable(value = "id") Integer id) {
		Optional<User> userOptional = userService.findById(id);
		if(!userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Integer id){
		Optional<User> userOptional = userService.findById(id);
		if(!userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		}
		userService.delete(userOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
	}
	
	@PutMapping("/{id}")	
	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Integer id, @RequestBody @Valid User user){
		Optional<User> userOptional = userService.findById(id);
		if(!userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
		}
		User updateUser = new User();
		BeanUtils.copyProperties(user, updateUser);
		updateUser.setId(userOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(userService.save(updateUser));
	}
}
