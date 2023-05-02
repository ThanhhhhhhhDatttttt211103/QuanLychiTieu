package MyThread;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import database.JDBCUtil;

public class Thread3_DanhMucMacDinh extends Thread {
	private String user;
	
	public Thread3_DanhMucMacDinh(String user) {
		this.user = user;
	}
	
	@Override
	public void run() {
		   try {
		        Connection conn = JDBCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
		     // Tạo lệnh SQL INSERT
		        Statement st = conn.createStatement();
		        
		        String sql = "INSERT INTO category (username, danhMuc, icon, loai) "+
						" VALUES ('"+user +"', 'Ăn uống', 'cutlery.png', 0)," +
						" ('"+user +"', 'Quần áo', 'tshirt.png', 0)," +
						" ('"+user +"', 'Phí giao lưu', 'partyIcon.png', 0)," +
						" ('"+user +"', 'Giáo dục', 'book.png', 0)," +
						" ('"+user +"', 'Y tế', 'syringe.png', 0)," +
						" ('"+user +"', 'Phí liên lạc', 'phone.png', 0)," +
						" ('"+user +"', 'Tiền nhà', 'home.png', 0)," +
						" ('"+user +"', 'Tiền điện nước', 'electric.png', 0)," +
						" ('"+user +"', 'Tiền lương', 'luong.png', 1)," +
						" ('"+user +"', 'Tiền phụ cấp', 'phucap.png', 1)," +
						" ('"+user +"', 'Tiền thưởng', 'thuong.png', 1)," +
						" ('"+user +"', 'Thu nhập phụ', 'phu.png', 1)," +
						" ('"+user +"', 'Đầu tư', 'dautu.png', 1)," +
						" ('"+user +"', 'Thu nhập tạm thời', 'tam.png', 1)";
		        

		        // Thực thi lệnh SQL INSERT
		        int ketQua = st.executeUpdate(sql);
		        
		        if (ketQua > 0) {
		          System.out.println("Danh mục đã thêm thành công");
		        } else {
		          System.out.println("Không thể thêm danh mục");
		        }
		        st.close();
		        conn.close();
		      } catch (SQLException ex) {
		        System.out.println("Lỗi: " + ex.getMessage());
		      } 
	}
}
