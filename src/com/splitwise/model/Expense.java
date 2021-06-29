package com.splitwise.model;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
	private Group group;
	
	public Expense(String name, String description, User createdBy, Double totalAmount) {
		super(ID++);
		this.name = name;
		this.description = description;
		this.createdBy = createdBy;
		this.totalAmount = totalAmount;
		this.amountPaid =  new HashMap<User, Double>();
		this.amountOwned = new HashMap<User, Double>();
		this.date = new Date();
		this.participants = new HashSet<User>();
		
	
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
		for(User participant : participants) {
			participant.addExpense(this);
		}
		
	}
	public void addParticipant(User user) {
		this.participants.add(user);
		user.addExpense(this);
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
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
		group.addExpense(this);
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: "+this.name+"\n");
		sb.append("Description: "+this.description+"\n");
		sb.append("CreatedBy: "+this.createdBy.getUserName()+"\n");
		sb.append("Paid amount:\n");
		for(User user : this.amountPaid.keySet()) {
			sb.append(user.getUserName()+"::"+this.amountPaid.get(user)+"\n");
		}
		sb.append("Owned amount:\n");
		for(User user : this.amountOwned.keySet()) {
			sb.append(user.getUserName()+"::"+this.amountOwned.get(user)+"\n");
		}
		return sb.toString();
	}
	

}
