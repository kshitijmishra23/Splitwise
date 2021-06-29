package com.splitwise.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Group extends AuditableEntity{
	private static Long ID = 0L;
	String name;
	String description;
	User admin;
	
	Set<User> participants;
	Set<Expense> expenses;
	
	private Date date;
	
	public Group(String name, String description, User admin, Set<User>participants) {
		super(ID++);
		this.name = name;
		this.description = description;
		this.admin = admin;
		this.participants = participants;
		this.expenses = new HashSet<Expense>();
		this.date = new Date();
		for(User participant : participants) {
			participant.addGroup(this);
		}
	}

	public Set<User> getParticipants() {		
		return this.participants;
	}

	public void addExpense(Expense expense) {
		this.expenses.add(expense);
		for(User participant : this.participants) {
			participant.addExpense(expense);
		}		
	}

}
