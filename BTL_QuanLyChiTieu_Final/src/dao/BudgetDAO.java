package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Budget;
import database.JDBCUtil;

public class BudgetDAO implements DAOinterface<Budget> {
	
	public BudgetDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static BudgetDAO getInstance() {
		return new BudgetDAO();
	}


	@Override
	public int update(String username, Budget t) {
		try {
			//bước 1: tạo kết nối
			Connection con = JDBCUtil.getConnection();
			//bước 2: tạo đối tượng statement
			String sql = "UPDATE budget "+
					" SET " +
					" soTien = ?" +
					", ngayBatDau = ?"+
					", ngayketThuc = ?"+
					", danhMuc = ?"+
					" WHERE username= ? AND ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getMoney());
			pstmt.setDate(2, t.getStartDate());
			pstmt.setDate(3, t.getEndDate());
			pstmt.setString(4, t.getCategory());
			pstmt.setString(5, username);
			pstmt.setString(6, t.getiD());
			
			//Bước 3: tạo câu lệnh
	
			 int rowsAffected = pstmt.executeUpdate();
		        if (rowsAffected > 0) {
		          System.out.println("Cập nhật thông tin thành công");
		          JOptionPane.showMessageDialog(null,"Cập nhật thông tin thành công");	
		        } else {
		          System.out.println("Không cập nhật được thông tin");
		          JOptionPane.showMessageDialog(null,"Không cập nhật được thông tin");
		        }
			
			//bước 5 ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public int insert(String username, Budget t) {
		try {
	        Connection conn = JDBCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
	     // Tạo lệnh SQL INSERT
	        
	        String sql = "INSERT INTO budget (username, soTien, ngayBatDau, ngayKetThuc, danhMuc) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, username);
	        pstmt.setInt(2, t.getMoney());
	        pstmt.setDate(3, t.getStartDate());
	        pstmt.setDate(4, t.getEndDate());
	        pstmt.setString(5, t.getCategory());
	        

	        // Thực thi lệnh SQL INSERT
	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected > 0) {
	          System.out.println("Ngân sách đã được thêm thành công");
	          JOptionPane.showMessageDialog(null,"Thêm ngân sách thành công");	
	        } else {
	          System.out.println("Không thể thêm ngân sách");
	          JOptionPane.showMessageDialog(null,"Không thể thêm ngân sách");
	        }
	        
	        //ngắt kêt nối
	        JDBCUtil.closeConnection(conn);
	      } catch (SQLException ex) {
	        System.out.println("Lỗi: " + ex.getMessage());
	      } 
		return 0;
	}
	
	public int delete(String username , String iD) {
		try {
		    Connection conn = JDBCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
		 // Tạo lệnh SQL INSERT
		    String sql = "DELETE FROM budget"+										
					" WHERE username= ? AND ID = ?";
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, username);
		    pstmt.setString(2, iD);
		
		    // Thực thi lệnh SQL INSERT
		    int rowsAffected = pstmt.executeUpdate();
		    if (rowsAffected > 0) {
		      System.out.println("Xóa ngân sách thành công");
		      JOptionPane.showMessageDialog(null,"Xóa ngân sách thành công");
		    } else {
		      System.out.println("Không thể xóa ngân sách");
		    }
		    
		    //ngắt kết nối
		    JDBCUtil.closeConnection(conn);
		  } catch (SQLException ex) {
		    System.out.println("Lỗi: " + ex.getMessage());
		  }
		return 0;
	}
	
}
