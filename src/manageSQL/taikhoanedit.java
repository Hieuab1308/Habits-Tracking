package manageSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class taikhoanedit {

    // Phương thức để cập nhật thông tin tài khoản
    public boolean updateAccount(String newEmail, String newPassword, String newId) {
        // Kiểm tra xem email mới có trùng lặp hay không
        if (isEmailDuplicate(newEmail, newId)) {
            JOptionPane.showMessageDialog(null, "Email đã tồn tại, vui lòng chọn email khác.");
            return false;
        }
        
        // Nếu không trùng, tiến hành cập nhật
        return updateAccountInDatabase(newEmail, newPassword, newId);
    }

    // Phương thức kiểm tra trùng lặp email
    private boolean isEmailDuplicate(String newEmail, String newId) {
        String checkQuery = "SELECT COUNT(*) FROM User WHERE email = ? AND id != ?";

        try (Connection conn = ConnectDB.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(checkQuery)) {

            pstmt.setString(1, newEmail);
            pstmt.setString(2, newId);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true; // Email đã tồn tại trong hệ thống
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Lỗi xảy ra khi kiểm tra email.");
        }

        return false; // Email không trùng lặp
    }

    // Phương thức cập nhật cơ sở dữ liệu
    private boolean updateAccountInDatabase(String newEmail, String newPassword, String newId) {
        String updateQuery = "UPDATE User SET email = ?, matkhau = ? WHERE id = ?";

        try (Connection conn = ConnectDB.getConnection(); 
             PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

            // Gán giá trị vào các tham số PreparedStatement
            pstmt.setString(1, newEmail);
            pstmt.setString(2, newPassword);
            pstmt.setString(3, newId);

            // Thực thi câu truy vấn cập nhật
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
//                JOptionPane.showMessageDialog(null, "Cập nhật tài khoản thành công.");
                return true;
            } else {
//                JOptionPane.showMessageDialog(null, "Không có thay đổi nào được thực hiện.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Lỗi xảy ra khi cập nhật tài khoản.");
        }

        return false;
    }
}
