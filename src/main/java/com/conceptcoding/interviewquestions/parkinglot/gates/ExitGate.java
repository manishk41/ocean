package com.conceptcoding.interviewquestions.parkinglot.gates;

import com.conceptcoding.interviewquestions.parkinglot.enums.PaymentMode;
import com.conceptcoding.interviewquestions.parkinglot.parkingspots.ParkingSpotManager;
import com.conceptcoding.interviewquestions.parkinglot.payment.Payment;
import com.conceptcoding.interviewquestions.parkinglot.payment.PaymentFactory;

import java.time.LocalTime;

public class ExitGate {
    private ParkingSpotManager parkingSpotManager;

    public ExitGate() {
        this.parkingSpotManager = ParkingSpotManager.getInstance();
    }

    public void processTicket(Ticket ticket, PaymentMode paymentMode) {
        // Calculate parking duration and total fees
        ticket.setExitTime(LocalTime.now());
        double amountToPay = parkingSpotManager.getCostCalculator().calculateTicketCost(ticket);
        ticket.setParkingFee(amountToPay);

        // set the Mode of Payment opted by Customer
        Payment paymentInstance = PaymentFactory.getPaymentInstance(paymentMode, amountToPay);
        ticket.setPayment(paymentInstance);

        // Process Payment and Free the Parking Spot
        paymentInstance.processPayment();
        System.out.println("[+] Ticket " + ticket.getTicketNo() + " processed. Cost: $" + amountToPay);

        // Free the Parking Spot
        ParkingSpotManager.getInstance().unParkVehicle(ticket.getParkingSpot().getSpotId());
    }
}