package com.conceptcoding.interviewquestions.parkinglot.payment;

public class CashPayment extends Payment {

    public CashPayment(double amt) {
        super(amt);
    }

    @Override
    public boolean processPayment() {
        System.out.println("\n[+] Paid $" + amount + " using cash.");
        return true;
    }
}
