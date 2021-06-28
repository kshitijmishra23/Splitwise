package com.splitwise.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.splitwise.model.Expense;
import com.splitwise.model.User;
import com.splitwise.repositories.IExpenseRepo;
import com.splitwise.repositories.IUserRepo;
import com.splitwise.services.SplitStrategy;

public class ExpenseController {
	IUserRepo userRepo;
	IExpenseRepo expenseRepo;
	
	
	public Expense createExpenseWithOtherUsers(
			String name, 
			String description,
			List<String> participants,
			String createdById,
			Double amount,
			SplitStrategy splitStrategy,
			Date date) {
		
		
		User currentUser = userRepo.findById(createdById);
		//if user is not registered => UserNotFound;
		
		//check for every id in the participants list as well
		Set<User> participantUsers = userRepo.getUsers(participants);
		
		Expense expense = new Expense (date, currentUser, participantUsers, name, description);
		splitStrategy.calculatePaidAmount(expense);
		return null;
		
	}
	

}
