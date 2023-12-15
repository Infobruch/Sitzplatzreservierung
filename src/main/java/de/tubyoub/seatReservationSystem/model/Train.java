package de.tubyoub.seatReservationSystem.model;
import de.tubyoub.seatReservationSystem.util.List;

/**
 * The Train class represents a train in the seat reservation system.
 * It contains a list of Wagon objects and an identifier.
 */

public class Train {
  List<Wagon> wagonList;
  String id;

  /**
   * Constructor for the Train class.
   * Initializes the wagon list and sets the identifier of the train.
   *
   * @param pBezeichner The identifier of the train.
   */
  public Train(String pBezeichner) {
    List<Wagon> wagonList = new List<Wagon>();
    id = pBezeichner;
  }

  /**
   * Appends a new wagon to the train.
   *
   * @param pID The identifier of the new wagon.
   * @param pSeatQuantity The number of seats in the new wagon.
   */
  public void appendNewWagon(int pID, int pSeatQuantity){
    wagonList.append(new Wagon(pID, pSeatQuantity));
  }

  /**
   * Returns the identifier of the train.
   *
   * @return The identifier of the train.
   */
  public String getIdentifier() {
    return id;
  }

  /**
   * Reserves a seat in a specific wagon of the train.
   *
   * @param pWaggonID The identifier of the wagon.
   * @param pPlatzNr The number of the seat.
   * @param pKundenname The name of the customer.
   */
  public void reserve(int pWaggonID, int pPlatzNr, String pKundenname) {
    searchForWagon(pWaggonID);
    wagonList.getContent().reserve(pPlatzNr, pKundenname);
  }

  /**
   * Deletes a reservation in a specific wagon of the train.
   *
   * @param pWaggonID The identifier of the wagon.
   * @param pPlatzNr The number of the seat.
   */
  public void deleteReservation(int pWaggonID, int pPlatzNr) {
    searchForWagon(pWaggonID);
    wagonList.getContent().deleteReservation(pPlatzNr);
  }

  /**
   * Determines the first free seat in a specific wagon of the train.
   *
   * @param pWaggon The wagon to search in.
   * @return The number of the first free seat, or -1 if there are no free seats.
   */
  public int determineFirstFreeSeat(Wagon pWaggon) {
    return -1;
  }

  /**
   * Determines the first group of four free seats in the train.
   *
   * @return An array containing the identifiers of the first group of four free seats, or {-1, -1} if there are no such groups.
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
   * Searches for a specific wagon in the train.
   *
   * @param pWagonID The identifier of the wagon to search for.
   */
  public void searchForWagon(int pWagonID){
    for (wagonList.toFirst(); wagonList.getContent().getNumber() != pWagonID && wagonList.hasAccess(); wagonList.next()) {
    }
  }
}

