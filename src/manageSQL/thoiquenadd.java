package manageSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Date;

public class thoiquenadd {

    private static DatabaseConfig dbconfig = new DatabaseConfig();

    // Kiểm tra xem habit_id đã tồn tại hay chưa
    private boolean isHabitIdExist(String habitId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());
            String checkSql = "SELECT habit_id FROM ThoiQuen WHERE habit_id = ?";
            pstmt = conn.prepareStatement(checkSql);
            pstmt.setString(1, habitId);
            rs = pstmt.executeQuery();

            return rs.next();  // Trả về true nếu habit_id đã tồn tại

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return false;
    }

    // Phương thức thêm thói quen mới
    public void addThoiQuen(String id, String name, Date ngaybatdau, Date ngayketthuc) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Kiểm tra nếu habit_id đã tồn tại
            if (isHabitIdExist(id)) {
                JOptionPane.showMessageDialog(null, "Mã thói quen đã tồn tại, vui lòng nhập mã khác.");
                return;  // Dừng lại nếu habit_id đã tồn tại
            }

            // 2. Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());

            // 3. Tạo câu lệnh SQL INSERT
            String sql = "INSERT INTO ThoiQuen (habit_id, tenthoiquen, ngayBatDau, ngayKetThuc) " +
                         "VALUES (?, ?, ?, ?)";

            // 4. Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);  // Sử dụng tenthoiquen thay vì name
            pstmt.setDate(3, ngaybatdau);
            pstmt.setDate(4, ngayketthuc);

            // 5. Thực thi câu lệnh
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Thêm thói quen thành công!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. Đóng kết nối
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Ví dụ sử dụng
        thoiquenadd dao = new thoiquenadd();
        // Giả sử ngày bắt đầu và ngày kết thúc được định dạng dưới dạng java.sql.Date
        dao.addThoiQuen("H001", "Tập thể dục", java.sql.Date.valueOf("2024-01-01"), java.sql.Date.valueOf("2024-12-31"));
    }
}
