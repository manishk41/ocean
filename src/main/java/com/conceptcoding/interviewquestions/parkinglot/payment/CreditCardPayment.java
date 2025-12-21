package com.conceptcoding.interviewquestions.parkinglot.payment;

public class CreditCardPayment extends Payment {

    public CreditCardPayment(double amt) {
        super(amt);
    }

    @Override
    public boolean processPayment() {
        System.out.println("\n[+] Paid $" + amount + " using credit card.");
        return true;
    }
}
