/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manageSQL;

/**
 *
 * @author HIEU
 */


import Class.thoi_quen;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class ListThoiQuen {
    private static DatabaseConfig config = new DatabaseConfig();
    
    // Phương thức lấy danh sách thói quen từ CSDL
    public static List<thoi_quen> getAllThoiQuen() {
        List<thoi_quen> thoiQuenList = new ArrayList<>();

        // Câu lệnh SQL để lấy dữ liệu từ bảng ThoiQuen
        String sql = "SELECT habit_id, tenthoiquen, ngayBatDau, ngayKetThuc FROM ThoiQuen";

        try (Connection conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // Lặp qua các hàng dữ liệu trong ResultSet
            while (rs.next()) {
                String habitId = rs.getString("habit_id");
                String tenThoiQuen = rs.getString("tenthoiquen");
                Date ngayBatDau = rs.getDate("ngayBatDau");
                Date ngayKetThuc = rs.getDate("ngayKetThuc");

                // Tạo một đối tượng ThoiQuen và thêm vào danh sách
                thoi_quen thoiQuen = new thoi_quen(habitId, tenThoiQuen, ngayBatDau, ngayKetThuc);
                thoiQuenList.add(thoiQuen);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Bắt lỗi SQL
        }
        return thoiQuenList;
    }
}
