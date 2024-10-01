package manageSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class taikhoandelete {

    private String getUserRole(String username) {
        String query = "SELECT role FROM User WHERE username = ?";
        try (Connection conn = ConnectDB.getConnection();  // Use ConnectDB class to connect to DB
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no role is found or an exception occurs
    }

    public boolean deleteAccount(String currentUsername, String targetUsername) {
        String currentUserRole = getUserRole(currentUsername);
        if (currentUserRole == null) {
            System.err.println("Cannot find role of current user");
            return false;
        }
        if (currentUserRole.equals("Admin")) {
            return deleteAccountFromDatabase(targetUsername);
        }
        else if (currentUserRole.equals("User")) {
            if (currentUsername.equals(targetUsername)) {
                return deleteAccountFromDatabase(currentUsername);
            }
            else {
                System.out.println("You do not have permission to delete other users");
                return false;
            }
        }
        System.out.println("Error: Unknown role");
        return false;
    }

    private boolean deleteAccountFromDatabase(String targetUsername) {
        String deleteQuery = "DELETE FROM users WHERE username = ?";
        try (Connection conn = ConnectDB.getConnection();  // Sử dụng lớp ConnectDB để kết nối DB
             PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
            stmt.setString(1, targetUsername);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Account deleted successfully.");
                return true;
            } else {
                System.out.println("No account found with the given username.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
