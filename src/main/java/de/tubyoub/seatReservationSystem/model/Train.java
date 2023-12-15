package de.tubyoub.seatReservationSystem.model;
import de.tubyoub.seatReservationSystem.util.List;

/**
 * This class represents a train, which consists of a list of wagons.
 */
public class Train {
  // List of wagons in the train
  List<Wagon> wagonList;
  // Identifier for the train
  String id;

  /**
   * Constructor for the Train class.
   * Initializes the list of wagons and the identifier of the train.
   * @param pTrainName The identifier of the train
   */
  public Train(String pTrainName) {
    wagonList = new List<Wagon>();
    id = pTrainName;
  }

  /**
   * Appends a new wagon to the train.
   * @param pWagonID The identifier of the new wagon
   * @param pSeatQuantity The number of seats in the new wagon
   */
  public void appendNewWagon(int pWagonID, int pSeatQuantity){
    this.wagonList.append(new Wagon(pWagonID, pSeatQuantity));
  }

  /**
   * Clears all reservations in a specific wagon.
   * @param pWagonID The identifier of the wagon to clear
   */
  public void clearWagon(int pWagonID){
    searchForWagon(pWagonID);
    Wagon wagonToClear = wagonList.getContent();
    wagonList.toFirst();
    for (int e = 0; e < wagonToClear.getNumberOfSeats(); e++) {
      if(!wagonToClear.isSeatFree(e)){
        while(wagonList.hasAccess() && (wagonToClear == wagonList.getContent() || wagonList.getContent().getNumberOfFreeSeats() == 0))wagonList.next();
      }
    }
  }

  /**
   * Returns the identifier of the train.
   * @return The identifier of the train
   */
  public String getIdentifier() {
    return id;
  }

  /**
   * Reserves a specific seat in a specific wagon for a customer.
   * @param pWaggonID The identifier of the wagon
   * @param pSeatNumber The number of the seat to reserve
   * @param pCustomerName The name of the customer
   */
  public void reserve(int pWaggonID, int pSeatNumber, String pCustomerName) {
    searchForWagon(pWaggonID);
    wagonList.getContent().reserve(pSeatNumber, pCustomerName);
  }

  /**
   * Deletes a reservation on a specific seat in a specific wagon.
   * @param pWaggonID The identifier of the wagon
   * @param pSeatNumber The number of the seat to delete the reservation from
   */
  public void deleteReservation(int pWaggonID, int pSeatNumber) {
    searchForWagon(pWaggonID);
    wagonList.getContent().deleteReservation(pSeatNumber);
  }

  /**
   * Determines the first free seat in a given wagon.
   * @param pWagon The wagon to search for a free seat
   * @return The number of the first free seat, or -1 if no free seat is found
   */
  public int determineFirstFreeSeat(Wagon pWagon) {
    for (int i = 0; i < pWagon.getNumberOfSeats(); i++) {
        if (pWagon.isSeatFree(i)) {
            return i;
        }
    }
    return -1;
  }

  /**
   * Determines the first group of four free seats in the train.
   * @return An array of two integers representing the number of the wagon and the starting seat number of the free area, or {-1, -1} if no such area is found
   */
  public int[] determineFirstFourFreeSeats(){
    boolean foundFirstFourSeatGroup = false;
    for(wagonList.toFirst(); wagonList.hasAccess() && !foundFirstFourSeatGroup; wagonList.next()){
      if(wagonList.getContent().hasEnoughSeatsFor(4)){
        if(wagonList.getContent().getNextFreeFourSeatArea()[1] != -1 && wagonList.getContent().getNextFreeFourSeatArea()[0] != -1)
          return wagonList.getContent().getNextFreeFourSeatArea();
      }
    }
    return new int[]{-1, -1};
  }

  /**
   * Searches for a wagon in the train.
   * @param pWagonID The identifier of the wagon to search for
   */
  public void searchForWagon(int pWagonID){
    for (wagonList.toFirst(); wagonList.getContent().getNumber() != pWagonID && wagonList.hasAccess(); wagonList.next()) {
    }
  }
}