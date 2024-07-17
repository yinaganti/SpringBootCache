package com.cache.practice.service;

import java.util.List;

import com.cache.practice.model.User;

public interface UserService {
	
	User getUser(Integer id);
	
	User editUser(Integer id, User user);
	
	void deleteUser(Integer id);
	
	List<User> getUsers();
	
	void flushCache(String name);
}
