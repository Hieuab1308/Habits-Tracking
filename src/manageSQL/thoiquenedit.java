/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manageSQL;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class thoiquenedit {

    private static DatabaseConfig dbconfig = new DatabaseConfig();

    public void updateThoiQuen(String habit_id, String tenthoiquen, java.sql.Date ngayBatDau, java.sql.Date ngayKetThuc) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Kết nối đến cơ sở dữ liệu
            conn = DriverManager.getConnection(dbconfig.getUrl(), dbconfig.getUsername(), dbconfig.getPassword());

            // 2. Tạo câu lệnh SQL UPDATE
            String sql = "UPDATE ThoiQuen SET tenthoiquen = ?, ngayBatDau = ?, ngayKetThuc = ? WHERE habit_id = ?";

            // 3. Chuẩn bị câu lệnh
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tenthoiquen);
            pstmt.setDate(2, ngayBatDau);
            pstmt.setDate(3, ngayKetThuc);
            pstmt.setString(4, habit_id);

            // 4. Thực thi câu lệnh
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật thành công.");
            } else {
                System.out.println("Không tìm thấy thói quen với ID: " + habit_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Đóng kết nối
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
        thoiquenedit dao = new thoiquenedit();
        dao.updateThoiQuen("H001", "Tập thể dục", java.sql.Date.valueOf("2024-09-15"), java.sql.Date.valueOf("2024-09-30"));
    }
}

