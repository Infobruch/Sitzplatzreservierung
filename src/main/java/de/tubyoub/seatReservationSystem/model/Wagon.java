package de.tubyoub.seatReservationSystem.model;

import de.tubyoub.seatReservationSystem.util.List;
public class Wagon {

    private int nummer;
    private int anzahlPlaetze;
        private List<Seat> sitzplaetze;

    public Wagon(int pNummer, int pAnzahlPlaetze) {
        if (pAnzahlPlaetze % 4 != 0) {
            throw new IllegalArgumentException("Number of seats must be divisible by 4.");
        }

        nummer = pNummer;
        anzahlPlaetze = pAnzahlPlaetze;
        sitzplaetze = new List<>();

        // Initialize each seat in the wagon
        for (int i = 0; i < pAnzahlPlaetze; i++) {
            sitzplaetze.append(new Seat());
        }
    }

    public int getNumber() {
        return nummer;
    }

    public int getNumberOfSeats() {
        return anzahlPlaetze;
    }

    public boolean isSeatFree(int pPlatzNr) {
        return true;
    }

    public void reserve(int pPlatzNr, String pKundenname) {

    }

    public void deleteReservation(int pPlatzNr) {
    }

    public int determineNumberOfFreeSeats() {
        int freiePlaetze = 0;
        return freiePlaetze;
    }

    public String getReservationOnSeat(int pPlatzNr) {
            return null;
    }
}
