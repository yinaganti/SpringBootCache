package com.cache.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cache.practice.model.User;
import com.cache.practice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable Integer id) {
		return userService.getUser(id);
	}
	
	@PutMapping("/{id}")
	public User editUser(@PathVariable Integer id, @RequestBody User user) {
		return userService.editUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return "SUCCESS";
	}
	
	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}
	
}
