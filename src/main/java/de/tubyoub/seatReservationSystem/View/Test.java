package de.tubyoub.seatReservationSystem.View;
import de.tubyoub.seatReservationSystem.service.TrainManagement;
import de.tubyoub.seatReservationSystem.model.*;
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        TrainManagement trainMngr = new TrainManagement();
        test.CreateTrains(trainMngr);
    }
    public void CreateTrains(TrainManagement pTrainmngr){
        Train train = new Train("Thomas");

        pTrainmngr.addTrain(train);
        pTrainmngr.appendWagon("Thomas", 0, 4);
        pTrainmngr.appendWagon("Thomas", 1, 56);
        pTrainmngr.appendWagon("Thomas", 2, 16);

        }
    }
}
