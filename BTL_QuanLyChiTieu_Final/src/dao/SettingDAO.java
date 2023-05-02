package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.Setting;
import database.JDBCUtil;

public class SettingDAO implements DAOinterface<Setting> {
	
	public SettingDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static SettingDAO getInstance() {
		return new SettingDAO();
	}

	@Override
	public int update(String username , Setting t) {
		try {
			 Connection conn = JDBCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
			 
    		String sql = "UPDATE setting"
    			+ " SET hoVaten = ?, email = ?, soDienThoai = ?"
    			+ " WHERE username = ?";
    		PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, t.getFullname());
	        pstmt.setString(2, t.getEmail());
	        pstmt.setString(3, t.getNumberPhone());
	        pstmt.setString(4, username);
	        
	        //thực thi câu lệch sql
	        pstmt.executeUpdate();
	        
	      //ngắt kết nối
	        JDBCUtil.closeConnection(conn);
	        
    	}catch (SQLException ex) {
	        System.out.println("Lỗi: " + ex.getMessage());
	      }
		return 0;
	}

	@Override
	public int insert(String username, Setting t) {
		try {
			 Connection conn = JDBCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
			 
    		String sql = "INSERT INTO setting (username, hoVaTen, email, soDienThoai) VALUES (?, ?, ?, ?)";
    		PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, username);
	        pstmt.setString(2, t.getFullname());
	        pstmt.setString(3, t.getEmail());
	        pstmt.setString(4, t.getNumberPhone());

	       
	        // Thực thi lệnh SQL INSERT
	       pstmt.executeUpdate();
	       
	       
	       //ngat ket noi
	       JDBCUtil.closeConnection(conn);
	       
    	}catch (SQLException ex) {
	        System.out.println("Lỗi: " + ex.getMessage());
	      }
		return 0;
	}

}
