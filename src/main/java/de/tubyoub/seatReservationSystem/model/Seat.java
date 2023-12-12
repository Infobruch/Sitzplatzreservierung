package de.tubyoub.seatReservationSystem.model;

public class Seat {
    private boolean reserved;

    private String seservedFor;

    public Seat() {
        reserved = false;
        seservedFor = null;
    }

    public boolean isReserved() {
        return reserved;
    }

    public String getReservation() {
        return seservedFor;
    }

    public void setReservation(String pCustomerName) {
        if (!reserved) {
            reserved = true;
            seservedFor = pCustomerName;
        }
    }

    public void delReservation() {
        if (reserved) {
            reserved = false;
            seservedFor = null;
        }
    }
}
