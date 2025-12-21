package com.conceptcoding.interviewquestions.parkinglot.gates;

import com.conceptcoding.interviewquestions.parkinglot.parkingspots.ParkingSpot;
import com.conceptcoding.interviewquestions.parkinglot.payment.Payment;
import com.conceptcoding.interviewquestions.parkinglot.vehicles.Vehicle;

import java.time.LocalTime;
import java.util.Random;

public class Ticket {
    private static int counter = 10_000;
    Payment payment;
    private int ticketNo;
    private LocalTime entryTime;
    private LocalTime exitTime;
    private double parkingFee;
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;

    public Ticket(ParkingSpot spot, Vehicle vehicle) {
        this.ticketNo = ++counter;
        this.parkingSpot = spot;
        this.vehicle = vehicle;
        this.entryTime = LocalTime.now();
        vehicle.assignTicket(this);
        System.out.println("[+] Ticket Issued: " + ticketNo + " for " + vehicle.getVehicleNo());
    }

    // getters and setters
    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalTime exitTime) {
        this.exitTime = exitTime;
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getParkingDuration() {
        /*
        Correct Way:
        double hours = Duration.between(entryTime, exitTime).toHours();
        */
        double hours = getParkingTimeInHours();
        return hours;
    }

    private int getParkingTimeInHours() {
        // simulate parking time
        Random random = new Random();
        return random.nextInt(2, 5);
    }
}
