package com.splitwise.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Expense extends AuditableEntity{
	private static Long ID = 1L;
	private String name;
	private String description;
	
	private User createdBy;
	private Set<User> participants;
	
	private Double totalAmount;
	
	private HashMap<User, Double> amountPaid;
	private HashMap<User, Double> amountOwned;
	private Date date;
	
	
	public Expense(String name, String description, User createdBy, Set<User> participants, Double totalAmount) {
		super(ID++);
		this.name = name;
		this.description = description;
		this.createdBy = createdBy;
		this.participants = participants;
		this.totalAmount = totalAmount;
		this.amountPaid =  new HashMap<User, Double>();
		this.amountOwned = new HashMap<User, Double>();
		this.date = new Date();
		for(User participant : participants) {
			participant.addExpense(this);
		}
	
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
