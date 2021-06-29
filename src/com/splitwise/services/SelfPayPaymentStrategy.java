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
				System.out.println("Payer is :"+payer.getUserName()+" "+amountPaid);
				
				expense.getAmountPaid().put(participant, amountPaid);
				System.out.println("Amount === "+expense.getAmountPaid().get(payer));
			}else {
				expense.getAmountPaid().put(participant, 0.0);
			}
		}
	}

}
