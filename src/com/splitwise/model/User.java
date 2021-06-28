package com.splitwise.model;

import java.util.HashSet;
import java.util.Set;

public class User extends AuditableEntity{
	private static Long ID = 1L;
	private String userName;
	private String phNumber;
	
	//Store the salted hashed password
	private String password;
	
	private Set<Expense> expenses;
	private Set<Group> groups;
	
	public User(String name, String phNo, String password) {
		super(ID++);
		this.userName = name;
		this.phNumber = phNo;
		//don't directly store it
		
		this.password = password;
		this.expenses = new HashSet<Expense>();
		this.groups = new HashSet<Group>();
	}	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
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
	
	public String toString() {
		StringBuilder userJson = new StringBuilder();
		userJson.append("ID: "+this.getId()+'\n');
		userJson.append("Username: "+this.userName+'\n');
		userJson.append("ph Number: "+this.phNumber);
		return userJson.toString();
		
	}
	
	
	

}
