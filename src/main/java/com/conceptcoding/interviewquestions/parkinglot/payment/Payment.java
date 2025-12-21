package com.conceptcoding.interviewquestions.parkinglot.payment;

public abstract class Payment {
    protected double amount;

    public Payment(double amt) {
        this.amount = amt;
    }

    public abstract boolean processPayment();

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}