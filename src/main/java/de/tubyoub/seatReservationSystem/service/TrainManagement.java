package de.tubyoub.seatReservationSystem.service;

import de.tubyoub.seatReservationSystem.model.Train;
import de.tubyoub.seatReservationSystem.util.List;

/**
 * This class is responsible for managing trains and their reservations.
 */
public class TrainManagement {
  // List of all trains
  List<Train> trains;

  /**
   * Constructor for TrainManagement class.
   * Initializes the list of trains.
   */
  public TrainManagement() {
    trains = new List<Train>();
  }

  /**
   * Returns the list of all trains.
   * @return List of trains
   */
  public List<Train> getTrains() {
    return trains;
  }

  /**
   * Reserves a seat on a specific train.
   * @param pTrainID ID of the train
   * @param pWagonID ID of the wagon
   * @param pSeatID ID of the seat
   * @param pCustomer Name of the customer
   */
  public void reserve(String pTrainID, int pWagonID, int pSeatID, String pCustomer) {
    searchForTrain(pTrainID);
    trains.getContent().reserve(pWagonID, pSeatID, pCustomer);
  }

  /**
   * Deletes a reservation on a specific train.
   * @param pTrainID ID of the train
   * @param pWagonID ID of the wagon
   * @param pSeatID ID of the seat
   */
  public void deleteReservation(String pTrainID, int pWagonID, int pSeatID) {
    searchForTrain(pTrainID);
    trains.getContent().deleteReservation(pWagonID, pSeatID);
  }

  /**
   * Adds a new train to the list.
   * @param pTrain Train object to be added
   */
  public void addTrain(Train pTrain) {
    trains.append(pTrain);
  }

  /**
   * Deletes a train from the list.
   * @param pTrainID ID of the train to be deleted
   */
  public void deleteTrain(String pTrainID){
    searchForTrain(pTrainID);
    trains.remove();
  }

  /**
   * Appends a new wagon to a specific train.
   * @param pTrainID ID of the train
   * @param pWagonID ID of the new wagon
   * @param pSeatQuantity Number of seats in the new wagon
   */
  public void appendWagon(String pTrainID, int pWagonID, int pSeatQuantity){
    searchForTrain(pTrainID);
    trains.getContent().appendNewWagon(pWagonID, pSeatQuantity);
  }

  /**
   * Searches for a train in the list.
   * @param pTrainID ID of the train to be searched
   */
  public void searchForTrain(String pTrainID){
    for (trains.toFirst(); !trains.getContent().getIdentifier().equals(pTrainID) && trains.hasAccess(); trains.next());
  }
}