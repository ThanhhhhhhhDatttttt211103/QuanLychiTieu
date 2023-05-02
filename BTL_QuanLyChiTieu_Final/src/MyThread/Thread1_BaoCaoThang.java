package MyThread;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import Model.User;
import database.JDBCUtil;

public class Thread1_BaoCaoThang extends Thread {
	public Map<String, Integer> baoCaoThangChiTieu;
	public Map<String, Integer> baoCaoThangThuNhap;
	private String txtDate;
	private User user;
	
	public Thread1_BaoCaoThang(String date, User user) {
		this.txtDate = date;
		this.user = user;
	}
	
	@Override
	public void run() {
		baoCaoThangChiTieu = new HashMap<>();
		baoCaoThangThuNhap = new HashMap<>();
        try {
			//bước 1: tạo kết nối
			Connection con = JDBCUtil.getConnection();
			//bước 2: tạo đối tượng statement
			String[] tokens = txtDate.split(" / ");
			String sql = "SELECT * FROM transaction WHERE username = ? AND MONTH(ngayGiaoDich) = ? AND  YEAR(ngayGiaoDich) = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2,tokens[0]);
			pst.setString(3,tokens[1]);
			
			//Bước 3: tạo câu lệnh
			
		
			ResultSet rs = pst.executeQuery();
			//bước 4 xử lí kết quả
			while(rs.next()) {
				if(rs.getString("loai").equals("0")) {
					if(baoCaoThangChiTieu.containsKey(rs.getString("danhMuc")))
						baoCaoThangChiTieu.put(rs.getString("danhMuc"),baoCaoThangChiTieu.get(rs.getString("danhMuc"))+Integer.parseInt(rs.getString("soTien")));
					else
						baoCaoThangChiTieu.put(rs.getString("danhMuc"),Integer.parseInt(rs.getString("soTien")));
				}
				else if(rs.getString("loai").equals("1")) {
					if(baoCaoThangThuNhap.containsKey(rs.getString("danhMuc")))
						baoCaoThangThuNhap.put(rs.getString("danhMuc"),baoCaoThangThuNhap.get(rs.getString("danhMuc"))+Integer.parseInt(rs.getString("soTien")));
					else
						baoCaoThangThuNhap.put(rs.getString("danhMuc"),Integer.parseInt(rs.getString("soTien")));
				}
			}				
			//bước 5 ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                   
	}
}
