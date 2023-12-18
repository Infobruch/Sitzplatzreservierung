package de.tubyoub.seatReservationSystem.database;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;

    public DatabaseConnection() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                return;
            }

            //load a properties file from class path
            prop.load(input);

            // get the property value and print it out
            String url = prop.getProperty("db.url");
            String username = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");

            this.connection = DriverManager.getConnection(url, username, password);
        } catch (IOException | SQLException ex) {
            System.out.println("Failed to load database credentials: " + ex.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to execute update: " + e.getMessage());
            return 0;
        }
    }

    public Connection getConnection() {
        return this.connection;
    }


    public void closeConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection: " + e.getMessage());
        }
    }
}