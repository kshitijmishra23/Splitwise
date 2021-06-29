package com.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.splitwise.controller.ExpenseController;
import com.splitwise.controller.UserController;
import com.splitwise.model.User;
import com.splitwise.repositories.ExpenseInMemoryRepo;
import com.splitwise.repositories.IExpenseRepo;
import com.splitwise.repositories.IUserRepo;
import com.splitwise.repositories.UserInMemoryRepository;
import com.splitwise.services.SelfPayPaymentStrategy;
import com.splitwise.services.SplitByPercentageStrategy;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IUserRepo userRepo = new UserInMemoryRepository();
		IExpenseRepo expenseRepo = new ExpenseInMemoryRepo();
		
		UserController c = new UserController(userRepo);
		User u1 = c.registerUser("u1","u1password", "9234576890");
		User u2 = c.registerUser("u2","u1password", "9234576890");
		User u3 = c.registerUser("u3","u1password", "9234576890");
		ExpenseController e = new ExpenseController(userRepo, expenseRepo);
		List<String> participants = new ArrayList<String>();
		participants.add(u1.getUserName());
		participants.add(u2.getUserName());
		participants.add(u3.getUserName());
		HashMap<Long, Double> percentage = new HashMap<Long, Double>();
		percentage.put(u1.getId(), 30.0);
		percentage.put(u2.getId(), 50.0);
		percentage.put(u3.getId(), 20.0);
		e.createExpenseWithOtherUsers("First", "First expense", participants, u1.getId(), 1000.0, new SplitByPercentageStrategy(percentage), new SelfPayPaymentStrategy());

	}

}
