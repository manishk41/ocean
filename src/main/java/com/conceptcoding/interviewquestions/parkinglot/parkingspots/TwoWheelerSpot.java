package com.conceptcoding.interviewquestions.parkinglot.parkingspots;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;
import com.conceptcoding.interviewquestions.parkinglot.vehicles.Vehicle;

public class TwoWheelerSpot extends ParkingSpot {
    public TwoWheelerSpot(String spotId) {
        super(spotId, 10);
    }

    public void assignVehicleToParkingSpot(Vehicle vehicle) {
        if (isAvailable()) {
            System.out.println("\n[+] A TwoWheelerSpot " + getSpotId() + " is occupied by " + vehicle.getVehicleNo());
            setVehicle(vehicle);
            setAvailable(false);
        }
    }

    public boolean checkIfVehicleFits(VehicleType vehicleType) {
        return vehicleType == VehicleType.TWO_WHEELER;
    }
}
