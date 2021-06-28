package com.splitwise.model;

import java.util.Set;

public class Group {
	
	String name;
	String description;
	User admin;
	
	Set<User> participants;
	Set<Expense> expenses;

}
