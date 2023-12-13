package de.tubyoub.seatReservationSystem.model;

public class Seat {
    private boolean reserved;

    private String reservedFor;

    public Seat() {
        reserved = false;
        reservedFor = null;
    }

    public boolean isReserved() {
        return reserved;
    }

    public String getReservation() {
        return reservedFor;
    }

    public void setReservation(String pCustomerName) {
        if (!reserved) {
            reserved = true;
            reservedFor = pCustomerName;
        }
    }

    public void delReservation() {
        if (reserved) {
            reserved = false;
            reservedFor = null;
        }
    }
}
