package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Transaction;
import database.JDBCUtil;

public class TransactionDAO implements DAOinterface<Transaction> {
	
	public TransactionDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static TransactionDAO getInstance() {
		return new TransactionDAO();
	}
	

	@Override
	public int insert(String user, Transaction t) {
	    try {
	        Connection conn = JDBCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
	     // Tạo lệnh SQL INSERT
	        
	        String sql = "INSERT INTO transaction (username, danhMuc, ngayGiaoDich, soTien, ghiChu, loai) VALUES (?, ?, ?, ?, ? ,?)";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, user);
	        pstmt.setString(2, t.getCategory());
	        pstmt.setDate(3, t.getDate());
	        pstmt.setInt(4, t.getMoney());
	        pstmt.setString(5, t.getNote());
	        pstmt.setInt(6, t.getLoai());
	        

	        // Thực thi lệnh SQL INSERT
	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected > 0) {
	          System.out.println("Giao dịch đã được thêm thành công");
	          JOptionPane.showMessageDialog(null,"Thêm giao dịch thành công");
	        } else {
	          System.out.println("Không thể thêm giao dịch");
	        }
	        
	        // Ngắt kết nối
	    	JDBCUtil.closeConnection(conn);
	      } catch (SQLException ex) {
	        System.out.println("Lỗi: " + ex.getMessage());
	      } 
		return 0;
	}

	@Override
	public int update(String user , Transaction t) {
		try {
	        Connection conn = JDBCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
	     // Tạo lệnh SQL INSERT
	        String sql = "UPDATE transaction "+
					" SET " +
					" danhMuc = ?" +
					", ngayGiaoDich = ?"+
					", soTien = ?"+
					", ghiChu = ?"+
					" WHERE username= ? AND ID = ?";
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, t.getCategory());
		    pstmt.setDate(2, t.getDate());
		    pstmt.setInt(3, t.getMoney());
		    pstmt.setString(4, t.getNote());
		    pstmt.setString(5, user);
		    pstmt.setString(6, t.getiD());

	        // Thực thi lệnh SQL INSERT
	        int rowsAffected = pstmt.executeUpdate();
	        if (rowsAffected > 0) {
	          System.out.println("Cập nhật giao dịch thành công");
	          JOptionPane.showMessageDialog(null,"Cập nhật giao dịch thành công");
	        } else {
	          System.out.println("Không thể cập nhật giao dịch");
	        }
	        
	        //Ngắt kết nối
	        JDBCUtil.closeConnection(conn);
	      } catch (SQLException ex) {
	        System.out.println("Lỗi: " + ex.getMessage());
	      } 
		return 0;
	}
	
	
	public int delete(String user , String iD) {
		try {
		    Connection conn = JDBCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
		 // Tạo lệnh SQL INSERT
		    String sql = "DELETE FROM transaction"+										
					" WHERE username= ? AND ID = ?";
		    PreparedStatement pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, user);
		    pstmt.setString(2, iD);
		
		    // Thực thi lệnh SQL INSERT
		    int rowsAffected = pstmt.executeUpdate();
		    if (rowsAffected > 0) {
		      System.out.println("Xóa giao dịch thành công");
		      JOptionPane.showMessageDialog(null,"Xóa giao dịch thành công");
		    } else {
		      System.out.println("Không thể xóa giao dịch");
		    }
		    
		   
		  //Ngắt kết nối
	        JDBCUtil.closeConnection(conn);
		  } catch (SQLException ex) {
		    System.out.println("Lỗi: " + ex.getMessage());
		  }
		return 0;
	}
}
