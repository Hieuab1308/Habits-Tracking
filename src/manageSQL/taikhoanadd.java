package manageSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;


public class taikhoanadd {
    private String generateRandomID() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder id = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            id.append(chars.charAt(random.nextInt(chars.length())));
        }
        return id.toString();
    }


    public boolean registerUser(String email, String password,String id) {
        String userID = generateRandomID();
        String role = "FALSE";
        String insertQuery = "INSERT INTO User (id, email, matkhau, role) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
            pstmt.setString(1, userID);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, role);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User registered successfully.");
                return true;
            } else {
                System.out.println("Failed to register user.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
