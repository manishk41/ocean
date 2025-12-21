package com.conceptcoding.interviewquestions.parkinglot.vehicles;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;

public class Motorcycle extends Vehicle {

    public Motorcycle(String vehicleNumber) {
        super(vehicleNumber, VehicleType.TWO_WHEELER);
    }
}
