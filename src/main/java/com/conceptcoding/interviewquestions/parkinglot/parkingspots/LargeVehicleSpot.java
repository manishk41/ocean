package com.conceptcoding.interviewquestions.parkinglot.parkingspots;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;
import com.conceptcoding.interviewquestions.parkinglot.vehicles.Vehicle;

public class LargeVehicleSpot extends ParkingSpot {
    public LargeVehicleSpot(String spotId) {
        super(spotId, 30);
    }

    public void assignVehicleToParkingSpot(Vehicle vehicle) {
        if (isAvailable()) {
            System.out.println("\n[+] A LargeVehicleSpot " + getSpotId() + " is occupied by " + vehicle.getVehicleNo());
            setVehicle(vehicle);
            setAvailable(false);
        }
    }

    public boolean checkIfVehicleFits(VehicleType vehicleType) {
        return vehicleType == VehicleType.LARGE_VEHICLE;
    }
}
