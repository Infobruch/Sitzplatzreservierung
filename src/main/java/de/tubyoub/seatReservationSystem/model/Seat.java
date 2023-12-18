package de.tubyoub.seatReservationSystem.model;

public class Seat {
    private int id;
    private String customer;

    public Seat(int id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}