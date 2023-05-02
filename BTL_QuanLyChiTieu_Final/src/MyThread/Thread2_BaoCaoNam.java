package MyThread;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import Model.User;
import database.JDBCUtil;

public class Thread2_BaoCaoNam extends Thread {
	public Map<String, Integer> baoCaoNamChiTieu;
	public Map<String, Integer> baoCaoNamThuNhap;
	private String txtDate;
	private User user;
	
	public Thread2_BaoCaoNam(User user, String date) {
		this.txtDate = date;
		this.user = user;
	}
	
	@Override
	public void run() {
		baoCaoNamChiTieu = new LinkedHashMap<>();
		baoCaoNamThuNhap = new LinkedHashMap<>();
        try {
			//bước 1: tạo kết nối
			Connection con = JDBCUtil.getConnection();
			//bước 2: tạo đối tượng statement
			String[] tokens = txtDate.split(" - ");
		
			int year1 = Integer.parseInt(tokens[0]);
			int year2 = Integer.parseInt(tokens[1]);
			for(int i = year1; i <= year2; i++) {
			
				String sql = "SELECT * FROM transaction WHERE username = ?  AND  YEAR(ngayGiaoDich) = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, user.getUsername());
				pst.setString(2,String.valueOf(i));
				
				//Bước 3: tạo câu lệnh
							
				ResultSet rs = pst.executeQuery();
				//bước 4 xử lí kết quả
				boolean hasResult = false;
				while(rs.next()) {
					 hasResult = true;
					if(rs.getString("loai").equals("0")) {
						if(!baoCaoNamThuNhap.containsKey(String.valueOf(i)))
							baoCaoNamThuNhap.put(String.valueOf(i), 0);
						
						if(baoCaoNamChiTieu.containsKey(String.valueOf(i)))
							baoCaoNamChiTieu.put(String.valueOf(i),baoCaoNamChiTieu.get(String.valueOf(i))+Integer.parseInt(rs.getString("soTien")));
						else
							baoCaoNamChiTieu.put(String.valueOf(i),Integer.parseInt(rs.getString("soTien")));
					}
					else if(rs.getString("loai").equals("1")) {
						if(!baoCaoNamChiTieu.containsKey(String.valueOf(i)))
							baoCaoNamChiTieu.put(String.valueOf(i), 0);
						
						if(baoCaoNamThuNhap.containsKey(String.valueOf(i)))
							baoCaoNamThuNhap.put(String.valueOf(i),baoCaoNamThuNhap.get(String.valueOf(i))+Integer.parseInt(rs.getString("soTien")));
						else
							baoCaoNamThuNhap.put(String.valueOf(i),Integer.parseInt(rs.getString("soTien")));
					}
				}
				
				if(!hasResult) {
				    baoCaoNamChiTieu.put(String.valueOf(i), 0);
				    baoCaoNamThuNhap.put(String.valueOf(i), 0);
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
