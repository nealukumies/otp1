package main;

import java.sql.*;
import javafx.scene.control.Label;

public class Database {

    private static final String HOST = System.getenv("DB_HOST");
    private static final String URL = "jdbc:mariadb://" + HOST + ":3306/javafx_mariadb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void saveTemperature(double celsius, double fahrenheit, double kelvin, Label statusLabel) {
        String sql = "INSERT INTO temperature_log (celsius, fahrenheit, kelvin) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, celsius);
            stmt.setDouble(2, fahrenheit);
            stmt.setDouble(3, kelvin);
            stmt.executeUpdate();
            statusLabel.setText("Saved to database!");

        } catch (SQLException e) {
            statusLabel.setText("DB Error: " + e.getMessage());
        }
    }
}