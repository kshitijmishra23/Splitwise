package com.splitwise.services;

import java.util.HashMap;
import java.util.Set;

import com.splitwise.model.Expense;
import com.splitwise.model.User;

public class SplitByPercentageStrategy implements SplitStrategy {

	//Map from userId to percentage
	private HashMap<Long, Double> percentage;
	public SplitByPercentageStrategy(HashMap<Long, Double> percentage) {
		this.percentage = percentage;
	}
	 
	@Override
	public void calculateOwnedAmount(Expense expense) {
		Double totalAmount = expense.getTotalAmount();
		Set<User> participants = expense.getParticipants();
		
		for(User participant : participants) {
			Double percentageShare =  percentage.get(participant.getId());
			Double amountOwned = (percentageShare*totalAmount)/100;
			expense.getAmountOwned().put(participant, amountOwned);
		}
	}

}
