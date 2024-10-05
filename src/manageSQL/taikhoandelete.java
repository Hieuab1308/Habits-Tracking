package manageSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class taikhoandelete {

    // Phương thức này trả về boolean để kiểm tra
    public boolean deleteAccount(String targetEmail) {
        return deleteAccountFromDatabase(targetEmail);
    }

    // Phương thức này thực hiện xóa tài khoản khỏi database và trả về boolean
    private boolean deleteAccountFromDatabase(String targetEmail) {
    // Bước 1: Xóa các bản ghi liên quan trong bảng theodoithoiquen
    String deleteRelatedQuery = "DELETE FROM theodoithoiquen WHERE user_id = (SELECT id FROM User WHERE email = ?)";
    
    try (Connection conn = ConnectDB.getConnection();  
         PreparedStatement pstmt1 = conn.prepareStatement(deleteRelatedQuery)) {
         
        pstmt1.setString(1, targetEmail);
        pstmt1.executeUpdate();  // Xóa bản ghi liên quan

    } catch (SQLException e) {
        e.printStackTrace();
        return false;  // Lỗi xảy ra khi xóa bản ghi liên quan
    }

    // Bước 2: Xóa tài khoản trong bảng User
    String deleteQuery = "DELETE FROM User WHERE email = ?";
    
    try (Connection conn = ConnectDB.getConnection();  
         PreparedStatement pstmt2 = conn.prepareStatement(deleteQuery)) {
         
        pstmt2.setString(1, targetEmail);
        int rowsAffected = pstmt2.executeUpdate();
        
        if (rowsAffected > 0) {
            return true;  // Xóa thành công
        } else {
            return false;  // Không tìm thấy tài khoản để xóa
        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;  // Lỗi xảy ra
    }
}

}
