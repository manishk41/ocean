package com.conceptcoding.interviewquestions.parkinglot.parkingspots;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;
import com.conceptcoding.interviewquestions.parkinglot.gates.EntryGate;
import com.conceptcoding.interviewquestions.parkinglot.gates.ExitGate;
import com.conceptcoding.interviewquestions.parkinglot.gates.Ticket;
import com.conceptcoding.interviewquestions.parkinglot.pricing.CostCalculator;
import com.conceptcoding.interviewquestions.parkinglot.vehicles.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotManager {
    private static ParkingSpotManager instance;
    private Map<String, ParkingSpot> parkingSpots;
    private Map<Integer, Ticket> tickets;
    private EntryGate entryGate;
    private ExitGate exitGate;
    private CostCalculator costCalculator;

    private ParkingSpotManager() {
        this.parkingSpots = new HashMap<>();
        this.tickets = new HashMap<>();
    }

    public static synchronized ParkingSpotManager getInstance() {
        if (instance == null) {
            instance = new ParkingSpotManager();
        }
        return instance;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots.values()) {
            if (spot.isAvailable() && spot.checkIfVehicleFits(vehicle.getVehicleType())) {
                spot.assignVehicleToParkingSpot(vehicle);
                Ticket ticket = generateParkingTicket(spot, vehicle);
                return ticket;
            }
        }
        return null;
    }

    public void unParkVehicle(String spotId) {
        ParkingSpot spot = parkingSpots.get(spotId);
        if (spot != null) spot.removeVehicleFromParkingSpot();
        System.out.println("[+] Available Parking Spots: " + this.getAvailableSpotsCount());
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.put(spot.getSpotId(), spot);
    }

    public void removeParkingSpot(ParkingSpot spot) {
        parkingSpots.remove(spot.getSpotId());
    }

    public int getAvailableSpotsCount() {
        return (int) parkingSpots.values().stream()
                .filter(ParkingSpot::isAvailable)
                .count();
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }

    public void setExitGate(ExitGate exitGate) {
        this.exitGate = exitGate;
    }

    public CostCalculator getCostCalculator() {
        return costCalculator;
    }

    public void setCostCalculator(CostCalculator costCalculator) {
        this.costCalculator = costCalculator;
    }

    private Ticket generateParkingTicket(ParkingSpot spot, Vehicle vehicle) {
        if (isFull(vehicle.getVehicleType())) {
            throw new RuntimeException("[-] No available parking spot for vehicle: " + vehicle.getVehicleNo());
        }
        Ticket ticket = new Ticket(spot, vehicle);
        tickets.put(ticket.getTicketNo(), ticket);
        return ticket;
    }

    public boolean isFull(VehicleType type) {
        return parkingSpots.values().stream()
                .noneMatch(spot -> spot.checkIfVehicleFits(type));

    }
}
