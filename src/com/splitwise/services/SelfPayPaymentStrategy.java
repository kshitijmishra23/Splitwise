package com.splitwise.services;

import java.util.Set;

import com.splitwise.model.Expense;
import com.splitwise.model.User;

public class SelfPayPaymentStrategy implements PaymentStrategy {

	@Override
	public void calculatePaidAmount(Expense expense) {
		User payer = expense.getCreatedBy();
		Set<User> participants = expense.getParticipants();
		Double amountPaid = expense.getTotalAmount();
		for(User participant : participants) {
			if(participant.equals(payer)) {
				expense.getAmountPaid().put(payer, amountPaid);
			}else {
				expense.getAmountPaid().put(payer, 0.0);
			}
		}
	}

}
