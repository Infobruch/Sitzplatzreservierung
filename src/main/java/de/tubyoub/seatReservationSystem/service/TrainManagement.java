package de.tubyoub.seatReservationSystem.service;

import de.tubyoub.seatReservationSystem.database.DatabaseConnection;
import de.tubyoub.seatReservationSystem.model.Train;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainManagement {
    private DatabaseConnection dbConnection;
    private String trainTable = "trains";
    private String reservationTable = "reservations";
    private String wagonTable = "wagons";

    public TrainManagement() {
        this.dbConnection = new DatabaseConnection();
    }

    public void addTrain(Train train) {
        String checkQuery = "SELECT * FROM " + trainTable + " WHERE id = " + train.getId();
        ResultSet rs = dbConnection.executeQuery(checkQuery);
        try {
            if (!rs.next()) {
                String insertQuery = "INSERT INTO " + trainTable + " (id, name) VALUES (" + train.getId() + ", '" + train.getName() + "')";
                dbConnection.executeUpdate(insertQuery);
            } else {
                // Find the next available ID
                String findNextIdQuery = "SELECT id FROM " + trainTable + " ORDER BY id DESC LIMIT 1";
                ResultSet rsNextId = dbConnection.executeQuery(findNextIdQuery);
                int nextId = 1; // Default ID if no train exists
                if (rsNextId.next()) {
                    nextId = rsNextId.getInt("id") + 1; // Next ID is the current maximum ID plus one
                }
                // Create a new train with the next available ID
                String insertQuery = "INSERT INTO " + trainTable + " (id, name) VALUES (" + nextId + ", '" + train.getName() + "')";
                dbConnection.executeUpdate(insertQuery);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add train: " + e.getMessage());
        }
    }

    public Train getTrain(int id) {
        String query = "SELECT * FROM " + trainTable + " WHERE id = " + id;
        ResultSet rs = dbConnection.executeQuery(query);
        try {
            if (rs.next()) {
                return new Train(rs.getInt("id"), rs.getString("name"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Failed to get train: " + e.getMessage());
            return null;
        }
    }

    public void reserve(int trainId, int wagonId, int seatId, String customer) {
        String checkQuery = "SELECT * FROM reservations WHERE train_id = " + trainId + " AND wagon_id = " + wagonId + " AND seat_id = " + seatId;
        ResultSet rs = dbConnection.executeQuery(checkQuery);
        try {
            if (!rs.next()) {
                String insertQuery = "INSERT INTO reservations (train_id, wagon_id, seat_id, customer) VALUES (" + trainId + ", " + wagonId + ", " + seatId + ", '" + customer + "')";
                dbConnection.executeUpdate(insertQuery);
            } else {
                System.out.println("Seat with train_id: " + trainId + ", wagon_id: " + wagonId + " and seat_id: " + seatId + " is already reserved.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to reserve seat: " + e.getMessage());
        }
    }

    public void deleteReservation(int pTrainID, int pWagonID, int pSeatID) {
        String query = "DELETE FROM " + reservationTable + " WHERE train_id = " + pTrainID + " AND wagon_id = " + pWagonID + " AND seat_id = " + pSeatID;
        dbConnection.executeUpdate(query);
    }

    public void deleteTrain(int id){
        String query = "DELETE FROM " + trainTable + " WHERE id = " + id;
        dbConnection.executeUpdate(query);
    }

    public void appendWagon(int trainId, int wagonId, int seatQuantity) {
        String checkQuery = "SELECT * FROM wagons WHERE train_id = " + trainId + " AND wagon_id = " + wagonId;
        ResultSet rs = dbConnection.executeQuery(checkQuery);
        try {
            if (!rs.next()) {
                String insertQuery = "INSERT INTO wagons (train_id, wagon_id, max_seat_quantity) VALUES (" + trainId + ", " + wagonId + ", " + seatQuantity + ")";
                dbConnection.executeUpdate(insertQuery);
            } else {
                System.out.println("Wagon with train_id: " + trainId + " and wagon_id: " + wagonId + " already exists.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to append wagon: " + e.getMessage());
        }
    }

    public void wipeTrainTable() {
        String queryTrains = "TRUNCATE TABLE " + trainTable + " CASCADE";
        dbConnection.executeUpdate(queryTrains);
        String queryWagons = "TRUNCATE TABLE " + wagonTable;
        dbConnection.executeUpdate(queryWagons);
    }
}