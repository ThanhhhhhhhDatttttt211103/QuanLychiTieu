package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import dao.UserDAO;
import database.JDBCUtil;

public class User {
	private String username;
	private String password;
	
	public User() {	
		this.username =null;
		this.password = null;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
	
	

	public boolean login(String username, String password){
	    boolean loggedIn = false;
	    try {
	        Connection con = JDBCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
	        String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, username);
	        pstmt.setString(2, password);
	        ResultSet rs = pstmt.executeQuery(); // Truy vấn cơ sở dữ liệu
	        if (rs.next()) {
	            loggedIn = true; // Nếu tìm thấy kết quả, đăng nhập thành công
	        }
	        
	        JDBCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return loggedIn;
	}
	
	
	
	public Object sighUp(String username, String password, String rePassword ){ 
		Connection con = null;
	    PreparedStatement stmt = null;
	    
	    try {
	        // Tạo kết nối đến cơ sở dữ liệu
	        con = JDBCUtil.getConnection(); 
	        
	        // Tạo truy vấn SQL để kiểm tra xem thông tin đăng kí của người dùng có tồn tại trong cơ sở dữ liệu hay không.
	        String sql = "SELECT COUNT(*) FROM user WHERE username = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, username);
	        
	        // Thực thi truy vấn SQL và kiểm tra kết quả
	        ResultSet rs = stmt.executeQuery();
	        rs.next();
	        
	        int count = rs.getInt(1);
	        
	        if(username.equals("") && password.equals("") && rePassword.equals("")) {
	        	JOptionPane.showMessageDialog(null,"Bắt đầu đăng kí để kết nối với chúng tôi :))");
	        }
	        if(username.equals("")){
	        	return "Hãy nhập tài khoản";
	        }
	        if (count > 0) {
	            return "Tài khoản đã có người sử dụng";
	        }
	        if(!password.equals(rePassword)) {  	
	            return "Mật khẩu không trùng khớp";
	        }
	        if(password.length() < 8){
	        	return "Độ dài mật khẩu lớn hơn 8";
	        }
	        if (password.trim().equals("")) {
	        	 return "Mật khẩu không được để trống";
	        }
	        
	        User user = new User(username,password);
	        UserDAO.getInstance().insert(user);
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	JDBCUtil.closeConnection(con);
	    }
	    return true;
	}
	
		
	
	
	public Object changePass(String username, String pass, String passnew, String repassnew) {
		Connection con = null;
	    PreparedStatement stmt = null;
	    
	    try {
	        // Tạo kết nối đến cơ sở dữ liệu
	        con = JDBCUtil.getConnection(); 
	        
	        // Tạo truy vấn SQL để kiểm tra xem thông tin đăng kí của người dùng có tồn tại trong cơ sở dữ liệu hay không.
	        String sql = "SELECT COUNT(*) FROM user WHERE username = ? AND password = ?";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1, username);
	        stmt.setString(2, pass);
	        
	        // Thực thi truy vấn SQL và kiểm tra kết quả
	        ResultSet rs = stmt.executeQuery();
	        rs.next(); 
	        
	        int count = rs.getInt(1);
	        

	        if(pass.equals("") && passnew.equals("") && repassnew.equals("")) {
	        	JOptionPane.showMessageDialog(null,"Bạn muốn đổi mật khẩu ?");
	        	return false;
	        }
	        if (!(count > 0)) {
	            return "Nhập sai mật khẩu";
	        }
	        if(!passnew.equals(repassnew)) {  	
	            return "Mật khẩu không trùng khớp";
	        }
	        
	        if (passnew.trim().equals("")) {
	        	 return "Mật khẩu không được để trống";
	        }
	        
	        if(passnew.length() < 8){
	        	return "Độ dài mật khẩu lớn hơn 8";
	        }
	        
	        // Tạo truy vấn SQL đ thểêm thông tin đăng kí vào cơ sở dữ liệu
	        User user = new User(username,passnew);
	        UserDAO.getInstance().update(user);
	      
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	JDBCUtil.closeConnection(con);
	    }
	    return true;
	}
}	