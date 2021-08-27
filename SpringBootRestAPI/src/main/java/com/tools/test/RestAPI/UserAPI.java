package com.tools.test.RestAPI;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tools.test.controller.UserController;
import com.tools.test.entity.Users;

@RestController
public class UserAPI {
	@Autowired
	
	private UserController controller;
	@PostMapping("/user/create")
	public ResponseEntity<Users> createUsers(@RequestBody Users user)
	{
		Users u = null;
		try {
			u = this.controller.addUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body(u);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer userId) {

		try {
			this.controller.deleteUser(userId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/user/{Id}")
	public ResponseEntity<Users> updateUser(@RequestBody Users user, @PathVariable("Id") Integer userId) {
		try {
			this.controller.updateUser(user, userId);
			return ResponseEntity.ok().body(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<Users>> getAllUser() {
		List<Users> list = controller.getAllUsers();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<Optional<Users>> getUserById(@PathVariable("id") Integer id) {

		Optional<Users> user = this.controller.getUserById(id);
		if (user != null) {
			return ResponseEntity.of(Optional.of(user));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
