package com.conceptcoding.interviewquestions.parkinglot.gates;

import com.conceptcoding.interviewquestions.parkinglot.parkingspots.ParkingSpotManager;
import com.conceptcoding.interviewquestions.parkinglot.vehicles.Vehicle;

import java.util.Optional;

public class EntryGate {

    private ParkingSpotManager parkingSpotManager;

    public EntryGate() {
        this.parkingSpotManager = ParkingSpotManager.getInstance();
    }

    public Ticket issueTicket(Vehicle vehicle) {
        // Finds the ParkingSpot, assigns the Vehicle to it and generates a Ticket
        Ticket ticketIssued = Optional.ofNullable(parkingSpotManager.parkVehicle(vehicle))
                .orElseThrow(() -> new RuntimeException("[-] No available parking spot for vehicle: " + vehicle.getVehicleNo()));

        System.out.println("[+] Parking Ticket Issued: " + ticketIssued.getTicketNo()
                + " for Vehicle " + vehicle.getVehicleNo() + " at Spot: " + ticketIssued.getParkingSpot().getSpotId());

        System.out.println("[+] Available Spots: " + parkingSpotManager.getAvailableSpotsCount());

        return ticketIssued;
    }
}