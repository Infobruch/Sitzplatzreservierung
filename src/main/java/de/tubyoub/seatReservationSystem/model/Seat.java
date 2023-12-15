package de.tubyoub.seatReservationSystem.model;
/**
 * The Seat class represents a seat in the seat reservation system.
 * It contains a boolean indicating whether the seat is reserved and a string representing the name of the customer who reserved the seat.
 */

public class Seat {
    private boolean reserved;

    private String reservedFor;

    /**
     * Constructor for the Seat class.
     * Initializes the seat as not reserved and the reservation as null.
     */
    public Seat() {
        reserved = false;
        reservedFor = null;
    }

    /**
     * Checks if the seat is reserved.
     *
     * @return True if the seat is reserved, false otherwise.
     */
    public boolean isReserved() {
        return reserved;
    }

    /**
     * Returns the name of the customer who reserved the seat.
     *
     * @return The name of the customer who reserved the seat.
     */
    public String getReservation() {
        return reservedFor;
    }

    /**
     * Reserves the seat for a specific customer.
     *
     * @param pCustomerName The name of the customer.
     */
    public void setReservation(String pCustomerName) {
        if (!reserved) {
            reserved = true;
            reservedFor = pCustomerName;
        }
    }

    /**
     * Deletes the reservation for the seat.
     */
    public void delReservation() {
        if (reserved) {
            reserved = false;
            reservedFor = null;
        }
    }
}
