package manageSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class taikhoanedit {

    // Phương thức để cập nhật thông tin tài khoản
    public boolean updateAccount(String newEmail, String newPassword, String newId) {
        // Gọi phương thức để cập nhật cơ sở dữ liệu với các thông tin mới
        return updateAccountInDatabase(newEmail, newPassword, newId);
    }

    // Phương thức cập nhật cơ sở dữ liệu
    private boolean updateAccountInDatabase(String newEmail, String newPassword, String newId) {
    // Câu lệnh SQL để cập nhật các trường với điều kiện WHERE
    String updateQuery = "UPDATE User SET email = ?, matkhau = ? WHERE id = ?";

    try (Connection conn = ConnectDB.getConnection(); 
         PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {

        // Gán giá trị vào các tham số PreparedStatement
        pstmt.setString(1, newEmail);
        pstmt.setString(2, newPassword);
        pstmt.setString(3, newId);

        // Thực thi câu truy vấn cập nhật
        int rowsAffected = pstmt.executeUpdate();

        // Kiểm tra xem có bản ghi nào bị thay đổi không
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Cập nhật tài khoản thành công.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Không có thay đổi nào được thực hiện.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Lỗi xảy ra khi cập nhật tài khoản.");
    }
    return false;
}
}