package de.tubyoub.seatReservationSystem.model;
import de.tubyoub.seatReservationSystem.util.List;


public class Train {
  List<Wagon> wagonList;
  String id;
  public Train(String pBezeichner) {
    List<Wagon> wagonList = new List<Wagon>();
    id = pBezeichner;
  }
  public void appendNewWagon(int pID, int pSeatQuantity){
    wagonList.append(new Wagon(pID, pSeatQuantity));
  }
  public String getIdentifier() {
    return id;
  }
  public void reserve(int pWaggonID, int pPlatzNr, String pKundenname) {
    searchForWagon(pWaggonID);
    wagonList.getContent().reserve(pPlatzNr, pKundenname);
  }
  public void deleteReservation(int pWaggonID, int pPlatzNr) {
    searchForWagon(pWaggonID);
    wagonList.getContent().deleteReservation(pPlatzNr);
  }
  public int determineFirstFreeSeat(Wagon pWaggon) {
    return -1;
  }
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
  public void searchForWagon(int pWagonID){
    for (wagonList.toFirst(); wagonList.getContent().getNumber() != pWagonID && wagonList.hasAccess(); wagonList.next()) {
    }
  }
}

