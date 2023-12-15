package de.tubyoub.seatReservationSystem.service;

import de.tubyoub.seatReservationSystem.model.Train;
import de.tubyoub.seatReservationSystem.util.List;

/**
 * The TrainManagement class provides methods for managing trains in the seat reservation system.
 * It contains methods for getting trains, reserving seats, deleting reservations, and adding trains.
 */
public class TrainManagement {
  List<Train> trains;

  /**
 * The TrainManagement class provides methods for managing trains in the seat reservation system.
 * It contains methods for getting trains, reserving seats, deleting reservations, and adding trains.
 */
  public TrainManagement() {
    trains = new List<Train>();
  }

  public List<Train> getTrains() {
    return trains;
  /**
 * The TrainManagement class provides methods for managing trains in the seat reservation system.
 * It contains methods for getting trains, reserving seats, deleting reservations, and adding trains.
 */
  public List<Train> gibZuege() {
    return null;
  }

  public void reserve(String pTrainID, int pWagonID, int pSeatID, String pCustomer) {
    searchForTrain(pTrainID);
    trains.getContent().reserve(pWagonID, pSeatID, pCustomer);
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

  public void deleteReservation(String pTrainID, int pWagonID, int pSeatID) {
    searchForTrain(pTrainID);
    trains.getContent().deleteReservation(pWagonID, pSeatID);
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
    trains.append(pTrain);
  }
  public void deleteTrain(String pTrainID){
    searchForTrain(pTrainID);
    trains.remove();
  }
  public void appendWagon(String pTrainID, int pWagonID, int pSeatQuantity){
    searchForTrain(pTrainID);
    trains.getContent().appendNewWagon(pWagonID, pSeatQuantity);
  }
  public void searchForTrain(String pTrainID){
    for (trains.toFirst(); !trains.getContent().getIdentifier().equals(pTrainID) && trains.hasAccess(); trains.next());
  }
}
