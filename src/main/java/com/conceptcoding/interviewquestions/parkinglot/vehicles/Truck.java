package com.conceptcoding.interviewquestions.parkinglot.vehicles;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;

public class Truck extends Vehicle {

    public Truck(String vehicleNumber) {
        super(vehicleNumber, VehicleType.LARGE_VEHICLE);
    }
}
