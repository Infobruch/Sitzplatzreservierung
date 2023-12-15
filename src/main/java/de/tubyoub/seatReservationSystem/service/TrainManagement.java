package de.tubyoub.seatReservationSystem.service;

import de.tubyoub.seatReservationSystem.model.Train;
import de.tubyoub.seatReservationSystem.util.List;

public class TrainManagement {
  List<Train> trains;
  public TrainManagement() {
    trains = new List<Train>();
  }

  public List<Train> getTrains() {
    return trains;
  }

  public void reserve(String pTrainID, int pWagonID, int pSeatID, String pCustomer) {
    searchForTrain(pTrainID);
    trains.getContent().reserve(pWagonID, pSeatID, pCustomer);
  }

  public void deleteReservation(String pTrainID, int pWagonID, int pSeatID) {
    searchForTrain(pTrainID);
    trains.getContent().deleteReservation(pWagonID, pSeatID);
  }

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