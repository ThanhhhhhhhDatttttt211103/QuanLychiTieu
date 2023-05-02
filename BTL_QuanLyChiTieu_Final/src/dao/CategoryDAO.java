package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Category;
import database.JDBCUtil;

public class CategoryDAO implements DAOinterface<Category> {
	
	public CategoryDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static CategoryDAO getInstance() {
		return new CategoryDAO();
	}

	@Override
	public int insert(String username, Category t) {
		try {
	        Connection conn = JDBCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
	     // Tạo lệnh SQL INSERT
	        
	        String sql = "INSERT INTO category (username, danhMuc, icon, loai) VALUES (?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, username);
	        pstmt.setString(2, t.getName());
	        pstmt.setString(3, t.getIcon());
	        pstmt.setInt(4, t.getLoai());
	        

	        // Thực thi lệnh SQL INSERT
	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected > 0) {
	          System.out.println("Danh mục đã thêm thành công");
	          JOptionPane.showMessageDialog(null,"Thêm danh mục thành công");
	        } else {
	          System.out.println("Không thể thêm danh mục");
	        }
	        
	        
	        // Ngắt kết nối
	    	JDBCUtil.closeConnection(conn);
	      } catch (SQLException ex) {
	        System.out.println("Lỗi: " + ex.getMessage());
	      } 
		return 0;
	}

	@Override
	public int update(String user, Category t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int delete(String username, String name) {
		try {
		    Connection conn = JDBCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
		 // Tạo lệnh SQL INSERT
		    String sql = "DELETE FROM category"+										
					" WHERE username= ? AND danhMuc = ?";
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, username);
		    pstmt.setString(2, name);
		
		    // Thực thi lệnh SQL INSERT
		    int rowsAffected = pstmt.executeUpdate();
		    if (rowsAffected > 0) {
		      System.out.println("Xóa danh mục thành công");
		      JOptionPane.showMessageDialog(null,"Xóa danh mục thành công");
		    } else {
		      System.out.println("Không thể xóa danh mục");
		    }
		    
		    // Ngắt kết nối
	    	JDBCUtil.closeConnection(conn);
		  } catch (SQLException ex) {
		    System.out.println("Lỗi: " + ex.getMessage());
		  }
		return 0;
	}

}
