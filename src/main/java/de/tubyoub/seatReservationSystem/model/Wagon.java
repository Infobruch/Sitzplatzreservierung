package de.tubyoub.seatReservationSystem.model;

/**
 * This class represents a wagon in a train.
 * Each wagon has a number, a certain number of seats, and an array of Seat objects.
 */
public class Wagon {

    private int number; // The number of the wagon
    private int SeatQuantity; // The total number of seats in the wagon
    private Seat[] seats; // An array of Seat objects representing the seats in the wagon

    /**
     * Constructor for the Wagon class.
     * Initializes the number of the wagon, the total number of seats, and the array of Seat objects.
     * @param pNumber The number of the wagon
     * @param pSeatQuantity The total number of seats in the wagon
     * @throws IllegalArgumentException if the total number of seats is not divisible by 4
     */
    public Wagon(int pNumber, int pSeatQuantity) {
        if (pSeatQuantity % 4 != 0) {
            throw new IllegalArgumentException("Number of seats must be divisible by 4.");
        }

        number = pNumber;
        SeatQuantity = pSeatQuantity;
        seats = new Seat[pSeatQuantity];

        // Initialize each seat in the wagon
        for (int i = 0; i < pSeatQuantity; i++) {
            seats[i] = new Seat();
        }
    }

    /**
     * Returns the number of the wagon.
     * @return The number of the wagon
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the total number of seats in the wagon.
     * @return The total number of seats in the wagon
     */
    public int getNumberOfSeats() {
        return SeatQuantity;
    }

    /**
     * Returns the number of free seats in the wagon.
     * @return The number of free seats in the wagon
     */
    public int getNumberOfFreeSeats(){
        int numberOfFreeSeats = 0;
        for (Seat seat : seats) if (!seat.isReserved()) numberOfFreeSeats++;
        return numberOfFreeSeats;
    }

    /**
     * Checks if there are enough free seats for a certain quantity.
     * @param pSeatQuantity The quantity of seats to check for
     * @return true if there are enough free seats, false otherwise
     */
    public boolean hasEnoughSeatsFor(int pSeatQuantity){
        return getNumberOfFreeSeats() >= pSeatQuantity;
    }

    /**
     * Returns the next free four-seat area in the wagon.
     * @return An array of two integers representing the number of the wagon and the starting seat number of the free area, or {-1, -1} if no such area is found
     */
    public int[] getNextFreeFourSeatArea(){
        boolean foundOne = false;
        for(int i = 3; i < seats.length && !foundOne; i+=4){
            if(!seats[i].isReserved() && !seats[i-1].isReserved() && !seats[i-2].isReserved() && !seats[i-3].isReserved())
                return new int[]{getNumber(), i-3};
        }
        return new int[]{-1, -1};
    }

    /**
     * Checks if a certain seat is free.
     * @param pPlatzNr The number of the seat to check
     * @return true if the seat is free, false otherwise
     */
    public boolean isSeatFree(int pPlatzNr) {
        return !seats[pPlatzNr].isReserved();
    }

    /**
     * Reserves a certain seat for a customer.
     * @param pPlatzNr The number of the seat to reserve
     * @param pKundenname The name of the customer
     */
    public void reserve(int pPlatzNr, String pKundenname) {
        if(!seats[pPlatzNr].isReserved())seats[pPlatzNr].setReservation(pKundenname);
    }

    /**
     * Deletes a reservation on a certain seat.
     * @param pPlatzNr The number of the seat to delete the reservation from
     */
    public void deleteReservation(int pPlatzNr) {
        seats[pPlatzNr].delReservation();
    }

    /**
     * Returns the reservation on a certain seat.
     * @param pPlatzNr The number of the seat to get the reservation from
     * @return The reservation on the seat
     */
    public String getReservationOnSeat(int pPlatzNr) {
            return seats[pPlatzNr].getReservation();
    }
}