package com.splitwise.services;

import com.splitwise.model.Expense;

public interface PaymentStrategy {
	public void calculatePaidAmount(Expense expense);
}
