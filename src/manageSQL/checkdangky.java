package manageSQL;

import Class.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class checkdangky {
    public static boolean check(user user) {
        // URL kết nối MySQL
        String jdbcURL = "jdbc:mysql://localhost:3306/thoiquen";
        String username = "root";
        String password = "12345678";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Kết nối tới MySQL
            connection = DriverManager.getConnection(jdbcURL, username, password);

            // Câu truy vấn SQL với tham số
            String sql = "SELECT * FROM User WHERE id = ? AND matkhau = ? AND email = ?";
            
            // Tạo PreparedStatement để truyền tham số
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getId()); // Thiết lập giá trị cho id
            statement.setString(2, user.getmatkhau()); // Thiết lập giá trị cho mật khẩu
            statement.setString(3, user.getEmail()); // Thiết lập giá trị cho email

            // Thực hiện truy vấn
            resultSet = statement.executeQuery();

            // Nếu có kết quả trả về, tức là người dùng hợp lệ
            if (resultSet.next()) {
                return true; // Người dùng hợp lệ
            }

        } catch (SQLException e) {
            e.printStackTrace(); // In lỗi ra console
        } finally {
            // Đóng ResultSet
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Đóng PreparedStatement
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // Đóng Connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Nếu không có kết quả, trả về false
        return false;
    }
}
