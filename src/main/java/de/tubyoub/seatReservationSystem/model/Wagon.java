package de.tubyoub.seatReservationSystem.model;

import de.tubyoub.seatReservationSystem.util.List;
/**
 * The Wagon class represents a wagon in the seat reservation system.
 * It contains an array of Seat objects, a number representing the total number of seats, and an identifier.
 */
public class Wagon {

    private int nummer;
    private int anzahlPlaetze;
    private Seat[] sitzplaetze;

    public Wagon(int pNummer, int pSeatQuantity) {
        if (pSeatQuantity % 4 != 0) {
    /**
     * Constructor for the Wagon class.
     * Initializes the seat array and sets the identifier and the total number of seats of the wagon.
     *
     * @param pNummer The identifier of the wagon.
     * @param pAnzahlPlaetze The total number of seats in the wagon.
     */
    public Wagon(int pNummer, int pAnzahlPlaetze) {
        if (pAnzahlPlaetze % 4 != 0) {
            throw new IllegalArgumentException("Number of seats must be divisible by 4.");
        }

        nummer = pNummer;
        anzahlPlaetze = pSeatQuantity;
        sitzplaetze = new Seat[pSeatQuantity];

        // Initialize each seat in the wagon
        for (int i = 0; i < pSeatQuantity; i++) {
            sitzplaetze[i] = new Seat();
        }
    }

    /**
     * Returns the identifier of the wagon.
     *
     * @return The identifier of the wagon.
     */
    public int getNumber() {
        return nummer;
    }

    /**
     * Returns the total number of seats in the wagon.
     *
     * @return The total number of seats in the wagon.
     */
    public int getNumberOfSeats() {
        return anzahlPlaetze;
    }
    public int getNumberOfFreeSeats(){
        int numberOfFreeSeats = 0;
        for (Seat seat : sitzplaetze) if (!seat.isReserved()) numberOfFreeSeats++;
        return numberOfFreeSeats;
    }

    /**
     * Checks if there are enough free seats for a specific quantity.
     *
     * @param pSeatQuantity The quantity of seats to check for.
     * @return True if there are enough free seats, false otherwise.
     */
    public boolean hasEnoughSeatsFor(int pSeatQuantity){
        return getNumberOfFreeSeats() >= pSeatQuantity;
    }

    /**
     * Determines the first group of four free seats in the wagon.
     *
     * @return An array containing the identifiers of the first group of four free seats, or {-1, -1} if there are no such groups.
     */
    public int[] getNextFreeFourSeatArea(){
        boolean foundOne = false;
        for(int i = 3; i < sitzplaetze.length && !foundOne; i+=4){
            if(!sitzplaetze[i].isReserved() && !sitzplaetze[i-1].isReserved() && !sitzplaetze[i-2].isReserved() && !sitzplaetze[i-3].isReserved())
                return new int[]{getNumber(), i-3};
        }
        return new int[]{-1, -1};
    }

    /**
     * Checks if a specific seat in the wagon is free.
     *
     * @param pPlatzNr The number of the seat to check.
     * @return True if the seat is free, false otherwise.
     */
    public boolean isSeatFree(int pPlatzNr) {
        return !sitzplaetze[pPlatzNr].isReserved();
    }

    /**
     * Reserves a specific seat in the wagon for a customer.
     *
     * @param pPlatzNr The number of the seat to reserve.
     * @param pKundenname The name of the customer.
     */
    public void reserve(int pPlatzNr, String pKundenname) {
        sitzplaetze[pPlatzNr].setReservation(pKundenname);
    }

    /**
     * Deletes a reservation for a specific seat in the wagon.
     *
     * @param pPlatzNr The number of the seat.
     */
    public void deleteReservation(int pPlatzNr) {
        sitzplaetze[pPlatzNr].delReservation();
    }

    /**
     * Returns the reservation for a specific seat in the wagon.
     *
     * @param pPlatzNr The number of the seat.
     * @return The reservation for the seat.
     */
    public String getReservationOnSeat(int pPlatzNr) {
            return sitzplaetze[pPlatzNr].getReservation();
    }
}
