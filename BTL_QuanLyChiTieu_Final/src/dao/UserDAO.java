package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.User;
import database.JDBCUtil;

public class UserDAO{
	
	public UserDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static UserDAO getInstance() {
		return new UserDAO();
	}

	public int insert(User t) {
		try {
			//tạo kết nối
			Connection conn = JDBCUtil.getConnection();
			
			//tạo đối tượng statement
	        // Tạo truy vấn SQL đ thểêm thông tin đăng kí vào cơ sở dữ liệu

	        String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, t.getUsername());
	        pstmt.setString(2, t.getPassword());
	        // Thực thi truy vấn SQL để thêm thông tin đăng kí vào cơ sở dữ liệu
	       
		
			pstmt.executeUpdate();
			//ngắt kết nối
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}

	public int update(User t) {
		try {
			//bước 1: tạo kết nối
			Connection con = JDBCUtil.getConnection();
			//bước 2: tạo đối tượng statement
			String sql = "UPDATE user"
        			+ " SET password = ?"
        			+ " WHERE username = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, t.getPassword());
	        stmt.setString(2, t.getUsername());
	        
	        // Thực thi truy vấn SQL để thêm thông tin đăng kí vào cơ sở dữ liệ
	        
	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected > 0) {
	          System.out.println("Cập nhật thành Công");
	        } else {
	          System.out.println("Cập nhật không thành công");
	        }	         
			
			//bước 5 ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
