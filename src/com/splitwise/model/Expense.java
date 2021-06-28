package com.splitwise.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Expense {
	
	String name;
	String description;
	
	User createdBy;
	Set<User> participants;
	
	Double totalAmount;
	
	HashMap<User, Double> amountPaid;
	HashMap<User, Double> amountOwned;
	
	public Expense(Date date, User currentUser, Set<User> participantUsers, String name2, String description2) {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public Set<User> getParticipants() {
		return participants;
	}
	public void setParticipants(Set<User> participants) {
		this.participants = participants;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public HashMap<User, Double> getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(HashMap<User, Double> amountPaid) {
		this.amountPaid = amountPaid;
	}
	public HashMap<User, Double> getAmountOwned() {
		return amountOwned;
	}
	public void setAmountOwned(HashMap<User, Double> amountOwned) {
		this.amountOwned = amountOwned;
	}
	
	

}
