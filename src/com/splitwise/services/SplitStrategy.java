package com.splitwise.services;

import com.splitwise.model.Expense;

public interface SplitStrategy {
	
	public void calculateOwnedAmount(Expense expense);

}
