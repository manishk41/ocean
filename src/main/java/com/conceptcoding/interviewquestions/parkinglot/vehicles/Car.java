package com.conceptcoding.interviewquestions.parkinglot.vehicles;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;

public class Car extends Vehicle {

    public Car(String vehicleNumber) {
        super(vehicleNumber, VehicleType.FOUR_WHEELER);
    }
}
