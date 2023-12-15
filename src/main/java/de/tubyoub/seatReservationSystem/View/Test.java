package de.tubyoub.seatReservationSystem.View;
import de.tubyoub.seatReservationSystem.service.TrainManagement;
import de.tubyoub.seatReservationSystem.model.*;
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        TrainManagement trainMngr = new TrainManagement();
        test.CreateTrain(trainMngr, "Thomas");
        test.CreateTrain(trainMngr, "Gordan");
        test.CreateTrain(trainMngr, "Percy");
        System.out.println(trainMngr.);
    }
    public void CreateTrain(TrainManagement pTrainmngr, String pTrainID){
        Train train = new Train(pTrainID);

        pTrainmngr.addTrain(train);
        pTrainmngr.appendWagon(pTrainID, 0, (int)(Math.random()*10)*4);
        pTrainmngr.appendWagon(pTrainID, 1, (int)(Math.random()*10)*4);
        pTrainmngr.appendWagon(pTrainID, 2, (int)(Math.random()*10)*4);
    }
}
