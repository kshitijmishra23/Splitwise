package com.splitwise.controller;

import java.util.List;
import java.util.Set;

import com.splitwise.model.Expense;
import com.splitwise.model.Group;
import com.splitwise.model.User;
import com.splitwise.repositories.IExpenseRepo;
import com.splitwise.repositories.IGroupRepo;
import com.splitwise.repositories.IUserRepo;
import com.splitwise.services.PaymentStrategy;
import com.splitwise.services.SplitStrategy;

public class ExpenseController {
	IUserRepo userRepo;
	IExpenseRepo expenseRepo;
	IGroupRepo groupRepo;
	
	
	public ExpenseController(IUserRepo userRepository, IExpenseRepo expenseRepository) {
		this.userRepo = userRepository;
		this.expenseRepo = expenseRepository;
	}
	public Expense createExpenseWithOtherUsers(
			String name, 
			String description,
			List<String> participants,
			Long createdById,
			Double amount,
			SplitStrategy splitStrategy,
			PaymentStrategy paymentStrategy
			) {
		
		
		User createdBy = userRepo.findById(createdById);
		
		
		
		Set<User> participantUsers = userRepo.getUsers(participants);
		
		Expense expense = new Expense(name, description, createdBy, amount);
		expense.setParticipants(participantUsers);
		splitStrategy.calculateOwnedAmount(expense);
		paymentStrategy.calculatePaidAmount(expense);
		expenseRepo.saveExpense(expense);
		System.out.println("Expense added:");
		System.out.println(expense.toString());
		return expense;
		
	}
	public Expense createExpenseInGroup(
			String name, 
			String description,
			Long groupId,
			Long createdById,
			Double amount,
			SplitStrategy splitStrategy,
			PaymentStrategy paymentStrategy
			) {
		
		
		User createdBy = userRepo.findById(createdById);
		Group group = groupRepo.findByID(groupId);
		
		
		Expense expense = new Expense(name, description, createdBy, amount);
		expense.setGroup(group);
		splitStrategy.calculateOwnedAmount(expense);
		paymentStrategy.calculatePaidAmount(expense);
		expenseRepo.saveExpense(expense);
		System.out.println("Expense added:");
		System.out.println(expense.toString());
		return expense;
		
	}
	

}
