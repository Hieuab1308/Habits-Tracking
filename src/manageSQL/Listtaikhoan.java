package manageSQL;

import Class.user; // Đảm bảo đây là đúng class mà bạn đã định nghĩa
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class Listtaikhoan {
    private static DatabaseConfig config = new DatabaseConfig();

    // Phương thức lấy danh sách tài khoản từ CSDL
    public static List<user> getAllTaiKhoan() {
        List<user> taiKhoanList = new ArrayList<>();

        // Câu lệnh SQL để lấy dữ liệu từ bảng User
        String sql = "SELECT id, email, matkhau, role FROM User";

        // Sử dụng try-with-resources để tự động đóng tài nguyên
        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Lặp qua các hàng dữ liệu trong ResultSet
            while (rs.next()) {
                String id = rs.getString("id");
                String email = rs.getString("email");
                String matKhau = rs.getString("matkhau");
                boolean role = rs.getBoolean("role");

                // Tạo đối tượng User và thêm vào danh sách
                user newUser = new user(id, email, matKhau, role);
                taiKhoanList.add(newUser);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Bắt lỗi SQL
        }
        return taiKhoanList;
    }
}