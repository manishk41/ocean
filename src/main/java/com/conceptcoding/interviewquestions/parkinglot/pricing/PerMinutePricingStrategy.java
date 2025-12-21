package com.conceptcoding.interviewquestions.parkinglot.pricing;

import com.conceptcoding.interviewquestions.parkinglot.gates.Ticket;

public class PerMinutePricingStrategy implements PricingStrategy {
    private static final Double TWO_WHEELER_COST_PER_MINUTE = 0.5;
    private static final Double FOUR_WHEELER_COST_PER_MINUTE = 0.75;
    private static final Double LARGE_VEHICLE_COST_PER_MINUTE = 1.0;

    @Override
    public double calculateParkingFee(Ticket ticket) {
        double minutes = ticket.getParkingDuration() * 60;
        return switch (ticket.getVehicle().getVehicleType()) {
            case TWO_WHEELER -> ticket.getParkingSpot().getBasePrice() + minutes * TWO_WHEELER_COST_PER_MINUTE;
            case FOUR_WHEELER -> ticket.getParkingSpot().getBasePrice() + minutes * FOUR_WHEELER_COST_PER_MINUTE;
            case LARGE_VEHICLE -> ticket.getParkingSpot().getBasePrice() + minutes * LARGE_VEHICLE_COST_PER_MINUTE;
        };
    }
}