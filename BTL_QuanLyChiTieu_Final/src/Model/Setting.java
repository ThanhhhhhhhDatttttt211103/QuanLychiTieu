package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.SettingDAO;
import database.JDBCUtil;

public class Setting {
	private String fullname;
	private String email;
	private String numberPhone;
	
	public Setting() {
		this.fullname = null;
		this.email = null;
		this.numberPhone = null;
	}

	public Setting(String fullname, String email, String numberPhone) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.numberPhone = numberPhone;
	}

	public String getFullname() {
		return fullname;
	}

	public String getEmail() {
		return email;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public void UpdateInfor(String username, String fullname, String email, String numberPhone) {
		try {
			Connection conn = JDBCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
	     // Tạo lệnh SQL INSERT
	        
	        String sql = "SELECT COUNT(*) FROM setting WHERE username = ?";
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, username);
	        
	        ResultSet rs = pstmt.executeQuery();
	        rs.next();
	        
	        int count = rs.getInt(1);
	        if(count > 0) { // nếu count > 0 có nghĩa là trong csdl đã có thông tin của user đó rồi nên chỉ cập nhật lại thông tin thoi
	        	Setting infor = new Setting(fullname,email,numberPhone);
	        	SettingDAO.getInstance().update(username, infor);
	        	return;
	        }else { // chưa có thông tin nên sẽ phải insert vào csdl
	        	Setting infor = new Setting(fullname,email,numberPhone);
	        	SettingDAO.getInstance().insert(username, infor);
	        	return;
	        }
	      } catch (SQLException ex) {
	        System.out.println("Lỗi: " + ex.getMessage());
	      }
	}
}
