package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import database.JDBCUtil;

public class Notification {
	private List<Budget> budgets;
	private Calendar calendar;
	private User user;
	    
	    public Notification(User user, String danhMuc) {
	    	budgets = new ArrayList<>();
	        this.user = user;
	        layNganSach();
	        for(int i =0 ; i< budgets.size(); i++) {
	        	if(danhMuc == null) {
	        		return;
	        	}
	        	 if(danhMuc.equals(budgets.get(i).getCategory()))
	        		 report(budgets, danhMuc);
	        }
	    }
	      
	    private void layNganSach() {
	        try {
				//bước 1: tạo kết nối
				Connection con = JDBCUtil.getConnection();
				//bước 2: tạo đối tượng statement
				calendar = Calendar.getInstance();
				int year = calendar.get(Calendar.YEAR);
				String sql = "SELECT * FROM budget WHERE username = ? AND Year(ngayKetThuc) >= ? ";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, user.getUsername());
				pst.setString(2,String.valueOf(year));
				
				//Bước 3: tạo câu lệnh
				
			
				ResultSet rs = pst.executeQuery();
				//bước 4 xử lí kết quả
				while(rs.next()) {
					Budget bud = new Budget(Integer.parseInt(rs.getString("soTien")),dateSql(rs.getString("ngayBatDau")),dateSql(rs.getString("ngayKetThuc")) ,rs.getString("danhMuc")) ;
					budgets.add(bud);
				}				
				//bước 5 ngắt kết nối
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}                   
	    }
	    
	    
    private void report(List<Budget> list, String danhMuc) {
    	for(int i = 0; i<list.size() ; i++) {
    		try {
				//bước 1: tạo kết nối
				Connection con = JDBCUtil.getConnection();
				//bước 2: tạo đối tượng statement
				String sql = "SELECT * FROM transaction WHERE username = ? AND ngayGiaoDich >= ? AND ngayGiaoDich <= ?  AND danhMuc = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, user.getUsername());
				pst.setDate(2, list.get(i).getStartDate());
				pst.setDate(3, list.get(i).getEndDate());
				pst.setString(4, danhMuc);
				//Bước 3: tạo câu lệnh
				
			
				ResultSet rs = pst.executeQuery();
				//bước 4 xử lí kết quả
				int tong = 0;;
				while(rs.next()) {
					if(rs.getString("loai").equals("0")) 
						tong += Integer.parseInt(rs.getString("Sotien"));										
				}
				
				if(tong > list.get(i).getMoney()) {
					JOptionPane.showMessageDialog(null,
						    "Bạn đã chi tiêu vượt quá ngân sách " + danhMuc +
						     " \ntừ ngày " + list.get(i).getStartDate() + " đến ngày " + list.get(i).getEndDate(),
						    "Nhắc nhở",
						    JOptionPane.WARNING_MESSAGE);
	        		return;
    			}
				//bước 5 ngắt kết nối
				JDBCUtil.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}                   
    	}
    	
    }
	    
	    
	    
	    private Date dateSql(String dateString) {
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	java.util.Date date = null;
			try {
				date = dateFormat.parse(dateString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    	return sqlDate;
	    }
}
