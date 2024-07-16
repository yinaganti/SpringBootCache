package com.cache.practice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cache.practice.model.User;
import com.cache.practice.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	Map<Integer, User> map = new HashMap<>();
	
	{
		map.put(001, new User(001, "sri", 25000L, true));
		map.put(002, new User(002, "varun", 4000L, true));
		map.put(003, new User(003, "purush", 12000L, true));
		map.put(004, new User(004, "raju", 10000L, true));
	}

	@Override
	@Cacheable(value = "user", key = "#id")
	public User getUser(Integer id) {
		System.out.println("getUser method:::::");
		return map.entrySet().stream().filter(entry -> entry.getKey()==id).findFirst().get().getValue();
	}

	@Override
	@CachePut(value = "user", key = "#id")
	public User editUser(Integer id, User user) {
		System.out.println("update method;;;");
		User olduser = map.entrySet().stream().filter(entry -> entry.getKey()==id).findFirst()
						.orElseThrow(()->new RuntimeException("invalid id")).getValue();
		olduser = (User)user;
		map.put(id, olduser);
		return olduser;
	}

	@Override
	@CacheEvict(value = "user", key = "#id")
	public void deleteUser(Integer id) {
		System.out.println("delete method");
		map.entrySet().stream().filter(entry -> entry.getKey()==id).findFirst()
				.orElseThrow(()->new RuntimeException("invalid id")).getValue();
		map.remove(id);
	}

	@Override
	@Cacheable(value = "users", key = "'allUsers'")
	public List<User> getUsers() {
		System.out.println("all users method");
		return map.values().stream().collect(Collectors.toList());
	}
}
