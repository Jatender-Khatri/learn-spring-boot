package com.tools.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tools.test.dao.UserReporitary;
import com.tools.test.entity.Users;

@Component
public class TestController {

	@Autowired
	private UserReporitary reporitary;

	public List<Users> getAllUsers() {
		List<Users> user = (List<Users>) this.reporitary.findAll();
		return user;
	}

	public Optional<Users> getUserById(Integer userId) {
		Optional<Users> users = null;

		users = this.reporitary.findById(userId);

		return users;
	}

	public Users addUser(Users u) {
		Users users = this.reporitary.save(u);
		return users;
	}

	public void deleteUser(Integer userId) {
		this.reporitary.deleteById(userId);
	}

	public void updateUser(Users user, Integer userId) {
		user.setId(userId);
		this.reporitary.save(user);
	}
}
