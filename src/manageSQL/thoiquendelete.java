
package manageSQL;

/**
 *
 * @author HIEU
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class thoiquendelete {

    private static DatabaseConfig dbconfig = new DatabaseConfig();

    public void deleteThoiQuen(String id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());

            // Câu lệnh SQL DELETE
            String sql = "DELETE FROM ThoiQuen WHERE habit_id = ?";

            // Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            // Thực thi câu lệnh
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Xoá thói quen thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy thói quen với mã: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

