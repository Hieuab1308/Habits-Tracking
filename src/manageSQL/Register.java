package manageSQL;

import Class.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

public class Register {

    private static DatabaseConfig config = new DatabaseConfig();

    public static boolean deleteUserById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        Connection conn = null;
        PreparedStatement pstmt = null;
    // Phương thức lưu thông tin tài khoản vào CSDL
    public static boolean registerUser(user user) {
        String sql = "INSERT INTO User (id, email, matkhau, role) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getmatkhau());
            pstmt.setBoolean(4, user.getRole()); 

            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return true; 
            }

        } catch (SQLException e) {
            e.printStackTrace(); 
            JOptionPane.showMessageDialog(null, "Tài khoản hoặc email đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return false; 
    }
    public static boolean updateUser(user user) {
    String sql = "UPDATE User SET email = ?, matkhau = ? WHERE id = ?";

    try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        
        pstmt.setString(1, user.getEmail());
        pstmt.setString(2, user.getmatkhau());
        pstmt.setString(3, user.getId());

        
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0; 

    } catch (SQLException e) {
        e.printStackTrace(); 
        JOptionPane.showMessageDialog(null, "Cập nhật không thành công.", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    return false; 
}
    
   


}
