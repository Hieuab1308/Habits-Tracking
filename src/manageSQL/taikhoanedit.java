package manageSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class taikhoanedit {
    private String getUserRole(String username) {
        String query = "SELECT role FROM User WHERE username = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private boolean verifiedCurrentPassword(String username, String currentPassword) {
        String query = "SELECT password FROM User WHERE username = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                return storedPassword.equals(currentPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return false;
    }

    public boolean changePassword(String currentUsername, String targetUsername, String oldPassword, String newPassword) {
        String currentUserRole = getUserRole(currentUsername);
        if (currentUserRole == null) {
            System.err.println("Cannot find role of current user");
            return false;
        }
        if (currentUserRole.equals("Admin")) {
            return updatePasswordInDatabase(targetUsername, newPassword);
        }
        else if (currentUserRole.equals("User")) {
            if (currentUsername.equals(targetUsername)) {
                if (verifiedCurrentPassword(currentUsername, oldPassword)) {
                    return updatePasswordInDatabase(currentUsername, newPassword);
                }
                else {
                    System.out.println("Old password is incorrect");
                    return false;
                }
            }
            else {
                System.out.println("You do not have permission to change other users' passwords");
                return false;
            }
        }
        System.out.println("Error: Unknown role");
        return false;
    }

    private boolean updatePasswordInDatabase(String username, String newPassword) {
        String updateQuery = "UPDATE User SET password = ? WHERE username = ?";
        try (Connection conn = ConnectDB.getConnection(); PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
            pstmt.setString(1, newPassword);
            pstmt.setString(2, username);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Password updated successfully.");
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