package com.conceptcoding.interviewquestions.parkinglot.payment;

public class UPIPayment extends Payment {

    public UPIPayment(double amt) {
        super(amt);
    }

    @Override
    public boolean processPayment() {
        System.out.println("\n[+] Paid $" + amount + " using UPI.");
        return true;
    }
}
