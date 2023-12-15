package de.tubyoub.seatReservationSystem.service;

import de.tubyoub.seatReservationSystem.model.Train;
import de.tubyoub.seatReservationSystem.util.List;

/**
 * The TrainManagement class provides methods for managing trains in the seat reservation system.
 * It contains methods for getting trains, reserving seats, deleting reservations, and adding trains.
 */
public class TrainManagement {

  /**
 * The TrainManagement class provides methods for managing trains in the seat reservation system.
 * It contains methods for getting trains, reserving seats, deleting reservations, and adding trains.
 */
  public TrainManagement() {
  }

  /**
 * The TrainManagement class provides methods for managing trains in the seat reservation system.
 * It contains methods for getting trains, reserving seats, deleting reservations, and adding trains.
 */
  public List<Train> gibZuege() {
    return null;
  }

  /**
     * Reserves a seat in a specific wagon of a specific train for a customer.
     *
     * @param pZugBezeichner The identifier of the train.
     * @param pWaggonNr The number of the wagon.
     * @param pPlatzNr The number of the seat.
     * @param pKundenname The name of the customer.
     */
  public void reserve(String pZugBezeichner, int pWaggonNr, int pPlatzNr, String pKundenname) {
  }

  /**
     * Deletes a reservation for a seat in a specific wagon of a specific train.
     *
     * @param pZugBezeichner The identifier of the train.
     * @param pWaggonNr The number of the wagon.
     * @param pPlatzNr The number of the seat.
     */
  public void deleteReservation(String pZugBezeichner, int pWaggonNr, int pPlatzNr) {
  }

  /**
     * Adds a new train to the system.
     *
     * @param pTrain The train to add.
     */
  public void addTrain(Train pTrain) {

  }
}
