package com.conceptcoding.interviewquestions.bookmyshow.booking;

import com.conceptcoding.interviewquestions.bookmyshow.enums.BookingStatus;

import java.util.ArrayList;
import java.util.List;

public class Booking {

    String bookingId;
    Show show;
    List<Seat> bookedSeats = new ArrayList<>();
    Payment payment;
    BookingStatus bookingStatus;
    double totalAmount;

    public double calculateTotalAmount() {
        generateBookingId();
        return bookedSeats.size() * show.getScreen().getSeats().size() * 100;
    }

    private void generateBookingId() {
        bookingId = "BMS" + (int) (Math.random() * (52222 - 10001 + 1) + 10001);
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public String toString() {
        return "Booking [bookingId=" + bookingId + ", show=" + show + ", bookedSeats=" + bookedSeats + ", payment="
                + payment + ", bookingStatus=" + bookingStatus + ", totalAmount=" + totalAmount + "]";
    }
}