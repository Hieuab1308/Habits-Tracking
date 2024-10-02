package manageSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class taikhoandelete {

    private String getUserRole(String email) {
        String query = "SELECT role FROM User WHERE email = ?";
        try (Connection conn = ConnectDB.getConnection();  // Use ConnectDB class to connect to DB
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no role is found or an exception occurs
    }

    // public boolean deleteAccount(String currentEmail, String targetEmail) {
    //     String currentUserRole = getUserRole(currentEmail);
    //     if (currentUserRole == null) {
    //         System.err.println("Cannot find role of current user");
    //         return false;
    //     }
    //     if (currentUserRole.equals("TRUE")) {
    //         return deleteAccountFromDatabase(targetEmail);
    //     }
    //     else if (currentUserRole.equals("FALSE")) {
    //         if (currentEmail.equals(targetEmail)) {
    //             return deleteAccountFromDatabase(currentEmail);
    //         }
    //         else {
    //             System.out.println("You do not have permission to delete other users");
    //             return false;
    //         }
    //     }
    //     System.out.println("Error: Unknown role");
    //     return false;
    // }

    private boolean deleteAccountFromDatabase(String targetEmail) {
        String deleteQuery = "DELETE FROM users WHERE email = ?";
        try (Connection conn = ConnectDB.getConnection();  // Sử dụng lớp ConnectDB để kết nối DB
             PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
            pstmt.setString(1, targetEmail);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Account deleted successfully.");
                return true;
            } else {
                System.out.println("No account found with the given email.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
