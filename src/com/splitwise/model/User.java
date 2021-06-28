package com.splitwise.model;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private String name;
	private String phNumber;
	
	//Store the salted hashed password
	private String password;
	
	private Set<Expense> expenses;
	private Set<Group> groups;
	
	public User(String name, String phNo, String password) {
		this.name = name;
		this.phNumber = phNo;
		//don't directly store it
		
		this.password = password;
		this.expenses = new HashSet<Expense>();
		this.groups = new HashSet<Group>();
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	public Set<Expense> getExpenses() {
		return expenses;
	}
	
	public Set<Group> getGroups() {
		return groups;
	}
	
	
	
	

}
