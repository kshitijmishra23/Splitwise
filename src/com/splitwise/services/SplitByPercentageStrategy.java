package com.splitwise.services;

import java.util.HashMap;

import com.splitwise.model.Expense;
import com.splitwise.model.User;

public class SplitByPercentageStrategy implements SplitStrategy {

	//Map from userId to percentage
	private HashMap<String, Double> percentage;
	 
	@Override
	public void calculatePaidAmount(Expense expense) {
		//we have the total ammount in expense 
		Double totalAmount = expense.getTotalAmount();

	}

}
