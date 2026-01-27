package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseUtils {

    private static final String URL = "jdbc:postgresql://localhost:5432/mydbase";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public static void insertUser(String email, String username, String password) throws Exception {
        String sql = "INSERT INTO users (email, username, password) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();
        }
    }

    public static void deleteUser(String email) throws Exception {
        String sql = "DELETE FROM users WHERE email = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.executeUpdate();
        }
    }
}
