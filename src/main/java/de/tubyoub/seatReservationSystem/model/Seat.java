package de.tubyoub.seatReservationSystem.model;

/**
 * This class represents a seat in a wagon.
 * Each seat can be reserved for a customer.
 */
public class Seat {
    private boolean reserved; // Indicates whether the seat is reserved
    private String reservedFor; // The name of the customer the seat is reserved for

    /**
     * Constructor for the Seat class.
     * Initializes the seat as not reserved and the customer name as null.
     */
    public Seat() {
        reserved = false;
        reservedFor = null;
    }

    /**
     * Checks if the seat is reserved.
     * @return true if the seat is reserved, false otherwise
     */
    public boolean isReserved() {
        return reserved;
    }

    /**
     * Returns the name of the customer the seat is reserved for.
     * @return The name of the customer
     */
    public String getReservation() {
        return reservedFor;
    }

    /**
     * Reserves the seat for a customer.
     * If the seat is already reserved, does nothing.
     * @param pCustomerName The name of the customer
     */
    public void setReservation(String pCustomerName) {
        if (!reserved) {
            reserved = true;
            reservedFor = pCustomerName;
        }
    }

    /**
     * Deletes the reservation on the seat.
     * If the seat is not reserved, does nothing.
     */
    public void delReservation() {
        if (reserved) {
            reserved = false;
            reservedFor = null;
        }
    }
}