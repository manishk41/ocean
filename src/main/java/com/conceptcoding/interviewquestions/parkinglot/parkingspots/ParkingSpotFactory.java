package com.conceptcoding.interviewquestions.parkinglot.parkingspots;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;

public class ParkingSpotFactory {
    public static ParkingSpot createParkingSpot(String spotId, VehicleType type) {
        return switch (type) {
            case TWO_WHEELER -> new TwoWheelerSpot(spotId);
            case FOUR_WHEELER -> new FourWheelerSpot(spotId);
            case LARGE_VEHICLE -> new LargeVehicleSpot(spotId);
            default -> throw new IllegalArgumentException("The ParkingSpotFactory does not support " + type);
        };
    }
}
