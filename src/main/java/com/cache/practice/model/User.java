package com.cache.practice.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User implements Serializable{
	
	private Integer id;
	private String name;
	private long salary;
	private boolean isActive;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public User(Integer id, String name, long salary, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.isActive = isActive;
	}
	public User() {
		super();
	}
	
	
}
