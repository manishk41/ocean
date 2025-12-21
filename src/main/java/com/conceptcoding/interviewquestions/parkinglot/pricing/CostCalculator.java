package com.conceptcoding.interviewquestions.parkinglot.pricing;

import com.conceptcoding.interviewquestions.parkinglot.gates.Ticket;

public class CostCalculator {
    private PricingStrategy pricingStrategy;

    public CostCalculator(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateTicketCost(Ticket ticket) {
        return pricingStrategy.calculateParkingFee(ticket);
    }
}