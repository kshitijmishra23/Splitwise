package com.splitwise.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Expense extends AuditableEntity{
	private static Long ID = 0L;
	private String name;
	private String description;
	
	private User createdBy;
	private Set<User> participants;
	
	private Double totalAmount;
	
	private HashMap<User, Double> amountPaid;
	private HashMap<User, Double> amountOwned;
	
	
	public Expense(Long id, String name, String description, User createdBy, Set<User> participants, Double totalAmount,
			HashMap<User, Double> amountPaid, HashMap<User, Double> amountOwned) {
		super(ID++);
		this.name = name;
		this.description = description;
		this.createdBy = createdBy;
		this.participants = participants;
		this.totalAmount = totalAmount;
		this.amountPaid = amountPaid;
		this.amountOwned = amountOwned;
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
