package de.tubyoub.seatReservationSystem.model;

public class Wagon {

    private int nummer;
    private int anzahlPlaetze;
    private Seat[] sitzplaetze;

    public Wagon(int pNummer, int pSeatQuantity) {
        if (pSeatQuantity % 4 != 0) {
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

    public int getNumber() {
        return nummer;
    }

    public int getNumberOfSeats() {
        return anzahlPlaetze;
    }
    public int getNumberOfFreeSeats(){
        int numberOfFreeSeats = 0;
        for (Seat seat : sitzplaetze) if (!seat.isReserved()) numberOfFreeSeats++;
        return numberOfFreeSeats;
    }

    public boolean hasEnoughSeatsFor(int pSeatQuantity){
        return getNumberOfFreeSeats() >= pSeatQuantity;
    }

    public int[] getNextFreeFourSeatArea(){
        boolean foundOne = false;
        for(int i = 3; i < sitzplaetze.length && !foundOne; i+=4){
            if(!sitzplaetze[i].isReserved() && !sitzplaetze[i-1].isReserved() && !sitzplaetze[i-2].isReserved() && !sitzplaetze[i-3].isReserved())
                return new int[]{getNumber(), i-3};
        }
        return new int[]{-1, -1};
    }

    public boolean isSeatFree(int pPlatzNr) {
        return !sitzplaetze[pPlatzNr].isReserved();
    }

    public void reserve(int pPlatzNr, String pKundenname) {
        if(!sitzplaetze[pPlatzNr].isReserved())sitzplaetze[pPlatzNr].setReservation(pKundenname);
    }

    public void deleteReservation(int pPlatzNr) {
        sitzplaetze[pPlatzNr].delReservation();
    }

    public String getReservationOnSeat(int pPlatzNr) {
            return sitzplaetze[pPlatzNr].getReservation();
    }
}