package com.conceptcoding.interviewquestions.parkinglot.parkingspots;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;
import com.conceptcoding.interviewquestions.parkinglot.vehicles.Vehicle;

public class FourWheelerSpot extends ParkingSpot {
    public FourWheelerSpot(String spotId) {
        super(spotId, 20);
    }

    public void assignVehicleToParkingSpot(Vehicle vehicle) {
        if (isAvailable()) {
            System.out.println("\n[+] A FourWheelerSpot " + getSpotId() + " is occupied by " + vehicle.getVehicleNo());
            setVehicle(vehicle);
            setAvailable(false);
        }
    }

    public boolean checkIfVehicleFits(VehicleType vehicleType) {
        return vehicleType == VehicleType.FOUR_WHEELER;
    }
}
