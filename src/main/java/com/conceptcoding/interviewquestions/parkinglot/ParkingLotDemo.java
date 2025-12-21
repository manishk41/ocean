package com.conceptcoding.interviewquestions.parkinglot;

import com.conceptcoding.interviewquestions.parkinglot.enums.PaymentMode;
import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;
import com.conceptcoding.interviewquestions.parkinglot.gates.EntryGate;
import com.conceptcoding.interviewquestions.parkinglot.gates.ExitGate;
import com.conceptcoding.interviewquestions.parkinglot.gates.Ticket;
import com.conceptcoding.interviewquestions.parkinglot.parkingspots.ParkingSpotFactory;
import com.conceptcoding.interviewquestions.parkinglot.parkingspots.ParkingSpotManager;
import com.conceptcoding.interviewquestions.parkinglot.pricing.CostCalculator;
import com.conceptcoding.interviewquestions.parkinglot.pricing.HourlyPricingStrategy;
import com.conceptcoding.interviewquestions.parkinglot.vehicles.Car;
import com.conceptcoding.interviewquestions.parkinglot.vehicles.Motorcycle;
import com.conceptcoding.interviewquestions.parkinglot.vehicles.Truck;
import com.conceptcoding.interviewquestions.parkinglot.vehicles.Vehicle;

public class ParkingLotDemo {
    public static void main(String[] args) {
        System.out.println("\n###### LLD ParkingLot Implementation ######");
        ParkingSpotManager spotManager = ParkingSpotManager.getInstance();

        // Create parking spots using factory
        spotManager.addParkingSpot(ParkingSpotFactory.createParkingSpot("M1", VehicleType.TWO_WHEELER));
        spotManager.addParkingSpot(ParkingSpotFactory.createParkingSpot("C1", VehicleType.FOUR_WHEELER));
        spotManager.addParkingSpot(ParkingSpotFactory.createParkingSpot("L1", VehicleType.LARGE_VEHICLE));

        // Initialize pricing strategy
        CostCalculator costCalculator = new CostCalculator(new HourlyPricingStrategy());
        spotManager.setCostCalculator(costCalculator);

        // Create gates
        EntryGate entryGate = new EntryGate();
        ExitGate exitGate = new ExitGate();
        spotManager.setEntryGate(entryGate);
        spotManager.setExitGate(exitGate);

        System.out.println("=====>>> Available Spots: " + spotManager.getAvailableSpotsCount());

        // Simulate parking
        Vehicle vehicle1 = new Motorcycle("KA-01-HH-5577");
        Ticket ticket1 = entryGate.issueTicket(vehicle1);

        Vehicle vehicle2 = new Car("MH-01-HH-1234");
        Ticket ticket2 = entryGate.issueTicket(vehicle2);

        Vehicle vehicle3 = new Truck("DL-01-HH-9099");
        Ticket ticket3 = entryGate.issueTicket(vehicle3);

        // Simulate exit
        exitGate.processTicket(ticket1, PaymentMode.CASH);
        exitGate.processTicket(ticket2, PaymentMode.UPI);
        exitGate.processTicket(ticket3, PaymentMode.CREDIT_CARD);

    }
}
