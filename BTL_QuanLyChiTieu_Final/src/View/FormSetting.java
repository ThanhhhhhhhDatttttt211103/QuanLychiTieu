package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.SettingController;
import Model.Setting;
import Model.User;
import ViewCover.CircleImagePanel;
import database.JDBCUtil;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FormSetting extends JFrame {
	
	private JPanel contentPane;
	private JTextField txt_nhapHoVaTen;
	private JTextField txt_EmailN;
	private JTextField txt_SoDienThoaiN;
	private JPanel jPanel_CapNhat;
	private User user = new User();
	private Setting set;
	private JLabel jLabel_Email;
	private JLabel jLabel_Phone;
	private JLabel jLabel_name;
	private JLabel jLabel_txt;
	
	
	public FormSetting(User user) {
		this.set = new Setting();
		this.user = user;
		this.init();
	}
	
	private void init() {
		this.setTitle("Quản lý chi tiêu");
		this.setSize(1020, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		contentPane.setLayout(new BorderLayout());
		
		Dimension size = new Dimension(200, 40);
		Dimension sizeMini= new Dimension(50, 30);

		
		Color color_BackChon = new Color(7, 164, 121);
		Color color_ForeChon = new Color(255,255,255);
		Color color_BackKhong = new Color(218, 235, 231);
		Color color_ForeKhong = new Color(7, 164, 121);
		Dimension size_BtnFooter = new Dimension(175, 40);
		
		SettingController ac = new SettingController(this);
		this.addWindowListener(ac);
		
		
		//bên trái
		
		JPanel jPanel_ThongTin = new JPanel();
		jPanel_ThongTin.setBackground(new Color(242,246,245));
		JLabel txt_thongtin = new JLabel("Thông tin");
		txt_thongtin.setFont(new Font("sansserif", 1, 30));
		txt_thongtin.setForeground(new Color(7, 164, 121));
		
		JPanel panel_Image = new CircleImagePanel(75, Color.red);
		panel_Image.setBackground(new Color(242,246,245));
		jLabel_txt = new JLabel();
		jLabel_txt.setFont(new Font("sansserif", 1, 100));
		jLabel_txt.setForeground(Color.white);
		panel_Image.add(jLabel_txt);
		
		JLabel txt_Ten = new JLabel("Họ và tên:");
		txt_Ten.setFont(new Font("sansserif", 1, 15));
		
		jLabel_name = new JLabel();
		jLabel_name.setFont(new Font("sansserif", 1, 15));
		
		JLabel txt_Email = new JLabel("Email:");
		txt_Email.setFont(new Font("sansserif", 1, 15));
		
		jLabel_Email = new JLabel();
		jLabel_Email.setFont(new Font("sansserif", 1, 15));
		
		JLabel txt_SDT = new JLabel("SĐT:");
		txt_SDT.setFont(new Font("sansserif", 1, 15));
				
		jLabel_Phone = new JLabel();
		jLabel_Phone.setFont(new Font("sansserif", 1, 15));
		
		// bên phải
		jPanel_CapNhat = new JPanel();
		jPanel_CapNhat.setBackground(Color.WHITE);
		
		JLabel txt_CapNhat = new JLabel("Cập nhật thông tin");
		txt_CapNhat.setFont(new Font("sansserif", 1, 30));
		txt_CapNhat.setForeground(new Color(7, 164, 121));
		
		JLabel txt_HoVaTen = new JLabel("Họ và Tên: ");
		txt_HoVaTen.setFont(new Font("sansserif", 1, 22));
		txt_HoVaTen.setForeground(new Color(7, 164, 121));
		
		txt_nhapHoVaTen = new JTextField();
		txt_nhapHoVaTen.setColumns(25);
		txt_nhapHoVaTen.setPreferredSize(size);
		txt_nhapHoVaTen.setMinimumSize(size);
		txt_nhapHoVaTen.setFont(new Font("sansserif", 1, 15));
		
		JLabel txt_EmailC = new JLabel("Mail: ");
		txt_EmailC.setFont(new Font("sansserif", 1, 22));
		txt_EmailC.setForeground(new Color(7, 164, 121));
		
		txt_EmailN = new JTextField();
		txt_EmailN.setColumns(25);
		txt_EmailN.setPreferredSize(size);
		txt_EmailN.setMinimumSize(size);
		txt_EmailN.setFont(new Font("sansserif", 1, 15));
		
		JLabel txt_SoDienThoai = new JLabel("Số điện thoại: ");
		txt_SoDienThoai.setFont(new Font("sansserif", 1, 22));
		txt_SoDienThoai.setForeground(new Color(7, 164, 121));
		
		txt_SoDienThoaiN = new JTextField();
		txt_SoDienThoaiN.setColumns(25);
		txt_SoDienThoaiN.setPreferredSize(size);
		txt_SoDienThoaiN.setMinimumSize(size);
		txt_SoDienThoaiN.setFont(new Font("sansserif", 1, 15));
		
		JButton jButton_CapNhat = new JButton("Cập nhật");
		jButton_CapNhat.setFont(new Font("sansserif", 1, 15));
		jButton_CapNhat.addActionListener(ac);
		
		jPanel_CapNhat.setVisible(false);
		
		contentPane.add(jPanel_CapNhat, BorderLayout.CENTER);
		
		JButton jButton_DoiMK = new JButton("Đổi Mật Khẩu");
		jButton_DoiMK.setFont(new Font("SansSerif", Font.BOLD, 15));
		jButton_DoiMK.addActionListener(ac);
		GroupLayout gl_jPanel_CapNhat = new GroupLayout(jPanel_CapNhat);
		gl_jPanel_CapNhat.setHorizontalGroup(
			gl_jPanel_CapNhat.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_jPanel_CapNhat.createSequentialGroup()
					.addGap(92)
					.addGroup(gl_jPanel_CapNhat.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_SoDienThoai)
						.addComponent(txt_EmailN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_EmailC)
						.addComponent(txt_nhapHoVaTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_HoVaTen)
						.addGroup(gl_jPanel_CapNhat.createSequentialGroup()
							.addGap(50)
							.addComponent(txt_CapNhat))
						.addGroup(gl_jPanel_CapNhat.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_jPanel_CapNhat.createSequentialGroup()
								.addComponent(jButton_DoiMK)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton_CapNhat))
							.addComponent(txt_SoDienThoaiN, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		gl_jPanel_CapNhat.setVerticalGroup(
			gl_jPanel_CapNhat.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jPanel_CapNhat.createSequentialGroup()
					.addContainerGap(51, Short.MAX_VALUE)
					.addComponent(txt_CapNhat)
					.addGap(18)
					.addComponent(txt_HoVaTen)
					.addGap(18)
					.addComponent(txt_nhapHoVaTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txt_EmailC)
					.addGap(18)
					.addComponent(txt_EmailN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txt_SoDienThoai)
					.addGap(18)
					.addComponent(txt_SoDienThoaiN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_jPanel_CapNhat.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButton_DoiMK)
						.addComponent(jButton_CapNhat))
					.addGap(43))
		);
		jPanel_CapNhat.setLayout(gl_jPanel_CapNhat);
		contentPane.add(jPanel_ThongTin, BorderLayout.WEST);
		
		JButton jButton_CapNhatTT = new JButton("Cập nhật thông tin");
		jButton_CapNhatTT.setFont(new Font("sansserif", 1, 15));
		jButton_CapNhatTT.addActionListener(ac);
		
		JButton jButton_DangXuat = new JButton("Đăng xuất");
		jButton_DangXuat.setFont(new Font("sansserif", 1, 15));
		jButton_DangXuat.addActionListener(ac);
		GroupLayout gl_jPanel_ThongTin = new GroupLayout(jPanel_ThongTin);
		gl_jPanel_ThongTin.setHorizontalGroup(
			gl_jPanel_ThongTin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel_ThongTin.createSequentialGroup()
					.addGroup(gl_jPanel_ThongTin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel_ThongTin.createSequentialGroup()
							.addGap(54)
							.addComponent(jButton_DangXuat)
							.addGap(29)
							.addComponent(jButton_CapNhatTT))
						.addGroup(gl_jPanel_ThongTin.createSequentialGroup()
							.addGap(62)
							.addComponent(txt_Ten)
							.addGap(45)
							.addComponent(jLabel_name))
						.addGroup(gl_jPanel_ThongTin.createSequentialGroup()
							.addGap(62)
							.addComponent(txt_SDT)
							.addGap(101)
							.addComponent(jLabel_Phone))
						.addGroup(gl_jPanel_ThongTin.createSequentialGroup()
							.addGap(61)
							.addComponent(txt_Email)
							.addGap(35)
							.addComponent(jLabel_Email))
						.addGroup(gl_jPanel_ThongTin.createSequentialGroup()
							.addGap(112)
							.addComponent(panel_Image, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPanel_ThongTin.createSequentialGroup()
							.addGap(120)
							.addComponent(txt_thongtin)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_jPanel_ThongTin.setVerticalGroup(
			gl_jPanel_ThongTin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel_ThongTin.createSequentialGroup()
					.addGap(54)
					.addComponent(txt_thongtin)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_Image, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_jPanel_ThongTin.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_Ten)
						.addComponent(jLabel_name))
					.addGap(22)
					.addGroup(gl_jPanel_ThongTin.createParallelGroup(Alignment.TRAILING)
						.addComponent(txt_Email)
						.addComponent(jLabel_Email))
					.addGroup(gl_jPanel_ThongTin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel_ThongTin.createSequentialGroup()
							.addGap(22)
							.addComponent(txt_SDT))
						.addGroup(gl_jPanel_ThongTin.createSequentialGroup()
							.addGap(18)
							.addComponent(jLabel_Phone)))
					.addGap(41)
					.addGroup(gl_jPanel_ThongTin.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButton_DangXuat)
						.addComponent(jButton_CapNhatTT))
					.addGap(33))
		);
		jPanel_ThongTin.setLayout(gl_jPanel_ThongTin);
		
		
		//foorter
		JPanel footer = new JPanel();
		footer.setBackground(new Color(242,246,245));
		
		JButton jButton_Nhap = new JButton("Nhập vào");
		jButton_Nhap.setName("Nhập vào");
		jButton_Nhap.setFont(new Font("sansserif", 1, 22));
		jButton_Nhap.setPreferredSize(size_BtnFooter);
		jButton_Nhap.setMinimumSize(sizeMini);
		jButton_Nhap.setBackground(color_BackKhong);
		jButton_Nhap.setForeground(color_ForeKhong);
		jButton_Nhap.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		jButton_Nhap.addActionListener(ac);
		
		JButton jButton_Danhsach = new JButton("Danh sách");
		jButton_Danhsach.setName("Tìm kiếm");
		jButton_Danhsach.setFont(new Font("sansserif", 1, 22));
		jButton_Danhsach.setPreferredSize(size_BtnFooter);
		jButton_Danhsach.setMinimumSize(sizeMini);
		jButton_Danhsach.setBackground(color_BackKhong);
		jButton_Danhsach.setForeground(color_ForeKhong);
		jButton_Danhsach.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		jButton_Danhsach.addActionListener(ac);
		
		JButton jButton_NganSach = new JButton("Ngân sách");
		jButton_NganSach.setName("Ngân sách");
		jButton_NganSach.setFont(new Font("sansserif", 1, 22));
		jButton_NganSach.setPreferredSize(size_BtnFooter);
		jButton_NganSach.setMinimumSize(sizeMini);
		jButton_NganSach.setBackground(color_BackKhong);
		jButton_NganSach.setForeground(color_ForeKhong);
		jButton_NganSach.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		jButton_NganSach.addActionListener(ac);
		
		JButton jButton_Bao = new JButton("Báo cáo");
		jButton_Bao.setName("Báo cáo");
		jButton_Bao.setFont(new Font("sansserif", 1, 22));
		jButton_Bao.setPreferredSize(size_BtnFooter);
		jButton_Bao.setMinimumSize(sizeMini);
		jButton_Bao.setBackground(color_BackKhong);
		jButton_Bao.setForeground(color_ForeKhong);
		jButton_Bao.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		jButton_Bao.addActionListener(ac);
		
		
		JButton jButton_Khac = new JButton("Khác");
		jButton_Khac.setName("Khác");
		jButton_Khac.setFont(new Font("sansserif", 1, 22));
		jButton_Khac.setPreferredSize(size_BtnFooter);
		jButton_Khac.setMinimumSize(sizeMini);
		jButton_Khac.setBackground(color_BackChon);
		jButton_Khac.setForeground(color_ForeChon);

		
		JPanel cover3 = new JPanel();
		cover3.setBackground(new Color(242,246,245));
		JPanel cover4 = new JPanel();
		cover4.setBackground(new Color(242,246,245));
		contentPane.add(footer, BorderLayout.SOUTH);
		GroupLayout gl_footer = new GroupLayout(footer);
		gl_footer.setHorizontalGroup(
			gl_footer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_footer.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_footer.createParallelGroup(Alignment.LEADING)
						.addComponent(cover3, GroupLayout.PREFERRED_SIZE, 916, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_footer.createSequentialGroup()
							.addComponent(jButton_Nhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(jButton_Danhsach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(jButton_NganSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(jButton_Bao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(jButton_Khac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(cover4, GroupLayout.PREFERRED_SIZE, 916, GroupLayout.PREFERRED_SIZE)))
		);
		gl_footer.setVerticalGroup(
			gl_footer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_footer.createSequentialGroup()
					.addComponent(cover3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_footer.createParallelGroup(Alignment.LEADING)
						.addComponent(jButton_Nhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton_Danhsach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton_NganSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton_Bao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton_Khac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addComponent(cover4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		footer.setLayout(gl_footer);
		
		
		this.setContentPane(contentPane);
		this.setVisible(true);
		getInfor();
	}
	
	public void setThongTin() {
		jPanel_CapNhat.setVisible(true);
	}
	
	public User getUser() {
		return user;
	}
	public void  getNameUser() {
		System.out.println(user.getUsername());
	}
	
	public void UpdateInfor() {
		set.UpdateInfor(user.getUsername(),txt_nhapHoVaTen.getText() , txt_EmailN.getText(), txt_SoDienThoaiN.getText());
		setInfor(txt_nhapHoVaTen.getText(),txt_EmailN.getText(),txt_SoDienThoaiN.getText());
	}
	
	private void setInfor(String name, String email, String sdt) {
		jLabel_name.setText(name);
		jLabel_Email.setText(email);
		jLabel_Phone.setText(sdt);
		jLabel_txt.setText(getChuCaiDau(jLabel_name.getText())+"");
		
	}
	
	
	private void getInfor() {
	 try {
        Connection conn = JDBCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
     // Tạo lệnh SQL INSERT
        
        String sql = "SELECT * FROM setting WHERE username = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, user.getUsername());
        

        // Thực thi lệnh SQL INSERT
        ResultSet rs = pstmt.executeQuery();	
       while(rs.next()) {
    	   jLabel_name.setText(rs.getString(2));
    	   jLabel_Email.setText(rs.getString(3));
    	   jLabel_Phone.setText(rs.getString(4));
       }
        
        pstmt.close();
        conn.close();
        rs.close();
      } catch (SQLException ex) {
        System.out.println("Lỗi: " + ex.getMessage());
      }
	 if(!jLabel_name.getText().isEmpty())
		 jLabel_txt.setText(getChuCaiDau(jLabel_name.getText())+"");
    }
	
	private char getChuCaiDau(String hoVaten) {
		String hoten = hoVaten.trim();
		int dem = 0;
		for(int i = 0 ; i< hoten.length(); i++) {
			if(hoten.charAt(i) == ' ') {
				dem = i;
			}
		}
		
		return hoten.charAt(dem+1);
		
	}
}
