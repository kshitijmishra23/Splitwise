package com.splitwise.model;

import java.util.Set;

public class Group extends AuditableEntity{
	private static Long ID = 0L;
	String name;
	String description;
	User admin;
	
	Set<User> participants;
	Set<Expense> expenses;
	
	public Group(String name, String description, User admin, Set<User>participants, Set<Expense> expenses) {
		super(ID++);
		this.name = name;
		this.description = description;
		this.admin = admin;
		this.participants = participants;
		this.expenses = expenses;
		
	}

}
