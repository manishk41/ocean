package com.conceptcoding.interviewquestions.parkinglot.pricing;

import com.conceptcoding.interviewquestions.parkinglot.gates.Ticket;

public class HourlyPricingStrategy implements PricingStrategy {
    private static final Double TWO_WHEELER_COST_PER_HOUR = 5.0;
    private static final Double FOUR_WHEELER_COST_PER_HOUR = 7.0;
    private static final Double LARGE_VEHICLE_COST_PER_HOUR = 10.0;

    @Override
    public double calculateParkingFee(Ticket ticket) {
        double hours = ticket.getParkingDuration();
        return switch (ticket.getVehicle().getVehicleType()) {
            case TWO_WHEELER -> ticket.getParkingSpot().getBasePrice() + hours * TWO_WHEELER_COST_PER_HOUR;
            case FOUR_WHEELER -> ticket.getParkingSpot().getBasePrice() + hours * FOUR_WHEELER_COST_PER_HOUR;
            case LARGE_VEHICLE -> ticket.getParkingSpot().getBasePrice() + hours * LARGE_VEHICLE_COST_PER_HOUR;
        };
    }
}