package de.tubyoub.seatReservationSystem.model;

public class Wagon {
    private int id;
    private int seatQuantity;

    public Wagon(int id, int seatQuantity) {
        this.id = id;
        this.seatQuantity = seatQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatQuantity() {
        return seatQuantity;
    }

    public void setSeatQuantity(int seatQuantity) {
        this.seatQuantity = seatQuantity;
    }
}