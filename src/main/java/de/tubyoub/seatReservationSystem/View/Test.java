package de.tubyoub.seatReservationSystem.View;
import de.tubyoub.seatReservationSystem.database.DatabaseConnection;
import de.tubyoub.seatReservationSystem.service.TrainManagement;
import de.tubyoub.seatReservationSystem.model.*;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        TrainManagement trainMngr = new TrainManagement();
        trainMngr.wipeTrainTable();

        // Create a train and add it to the database
        test.createTrain(trainMngr, 1, "Thomas");

        // Add 10 wagons to the train in the database, each with a different seat quantity
        for (int i = 0; i < 10; i++) {
            trainMngr.appendWagon(1, i, (i + 1) * 10);
        }

        // Reserve some seats for customers
        test.reserveSeat(trainMngr, 1, 0, 1, "Customer A");
        test.reserveSeat(trainMngr, 1, 1, 2, "Customer B");
        test.reserveSeat(trainMngr, 1, 2, 3, "Customer C");

        // Retrieve the train from the database and print its name
        Train train = trainMngr.getTrain(1);
        if (train != null) {
            System.out.println(train.getName());
        } else {
            System.out.println("Failed to retrieve train from the database.");
        }
    }

    public void createTrain(TrainManagement pTrainmngr, int id, String name){
        // Add a train to the database
        pTrainmngr.addTrain(new Train(id, name));
    }

    public void reserveSeat(TrainManagement pTrainmngr, int pTrainID, int pWagonID, int pSeatID, String pCustomer) {
        // Reserve a seat for a customer
        pTrainmngr.reserve(pTrainID, pWagonID, pSeatID, pCustomer);
    }
}