package com.splitwise.repositories;

import java.util.HashMap;

import com.splitwise.model.Expense;

public class ExpenseInMemoryRepo implements IExpenseRepo {

	HashMap<Long, Expense> idToExpenseMap = new HashMap<Long, Expense>();
	@Override
	public void saveExpense(Expense expense) {
		idToExpenseMap.put(expense.getId(), expense);

	}

}
