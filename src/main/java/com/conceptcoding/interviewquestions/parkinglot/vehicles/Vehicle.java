package
        com.conceptcoding.interviewquestions.parkinglot.vehicles;

import com.conceptcoding.interviewquestions.parkinglot.enums.VehicleType;
import com.conceptcoding.interviewquestions.parkinglot.gates.Ticket;

public abstract class Vehicle {
    private final String vehicleNo;
    private VehicleType vehicleType;
    private Ticket ticket;

    public Vehicle(String vehicleNo, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void assignTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
