package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String URL = "jdbc:mysql://localhost:8080/rpg_game";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Ganti dengan password MySQL Anda

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
