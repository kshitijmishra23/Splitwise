package com.splitwise.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.splitwise.model.Expense;
import com.splitwise.model.Group;
import com.splitwise.model.User;
import com.splitwise.repositories.IExpenseRepo;
import com.splitwise.repositories.IGroupRepo;
import com.splitwise.repositories.IUserRepo;
import com.splitwise.services.SplitStrategy;

public class ExpenseController {
	IUserRepo userRepo;
	IExpenseRepo expenseRepo;
	IGroupRepo groupRepo;
	
	
	public Expense createExpenseWithOtherUsers(
			String name, 
			String description,
			List<String> participants,
			Long createdById,
			Double amount,
			SplitStrategy splitStrategy
			) {
		
		
		User createdBy = userRepo.findById(createdById);
		
		
		
		Set<User> participantUsers = userRepo.getUsers(participants);
		
		Expense expense = new Expense(name, description, createdBy, participantUsers, amount);
		splitStrategy.calculatePaidAmount(expense);
		return expense;
		
	}
	public Expense createExpenseInGroup(
			String name, 
			String description,
			Long groupId,
			Long createdById,
			Double amount,
			SplitStrategy splitStrategy
			) {
		
		
		User createdBy = userRepo.findById(createdById);
		Group group = groupRepo.findByID(groupId);
		
		Set<User> participantUsers = group.getParticipants();
		
		Expense expense = new Expense(name, description, createdBy, participantUsers, amount);
		splitStrategy.calculatePaidAmount(expense);
		return expense;
		
	}
	

}
