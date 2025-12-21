package com.conceptcoding.interviewquestions.parkinglot.pricing;

import com.conceptcoding.interviewquestions.parkinglot.gates.Ticket;

public interface PricingStrategy {
    double calculateParkingFee(Ticket ticket);
}