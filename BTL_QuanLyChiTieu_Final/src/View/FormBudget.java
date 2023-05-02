package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import Controller.BudgetController;
import Model.Budget;
import Model.User;
import database.JDBCUtil;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.toedter.calendar.JDateChooser;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FormBudget extends JFrame {

	private JPanel contentPane;
	private Map<String, String> listDanhMuc;
	private Map<JButton, Integer> click;
	private Budget budget;
	private User user = new User();
	private String stringBtn;
	private JDateChooser txtNgay1;
	private JDateChooser txtNgay2;
	private JTextField txtTien2;
	private int loai;

	
	public FormBudget(User user) {
		this.budget = new Budget();
		this.listDanhMuc = new LinkedHashMap<>();
		this.user = user;
		this.loai = 0;
		this.init();
	}

	
	public void init() {
		this.setSize(1020, 600);
		this.setTitle("Quản Lý Chi Tiêu");
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(255,255,255));
		
		Color color_BackChon = new Color(7, 164, 121);
		Color color_ForeChon = new Color(255,255,255);
		Color color_BackKhong = new Color(218, 235, 231);
		Color color_ForeKhong = new Color(7, 164, 121);
		
		BudgetController ac = new BudgetController(this);
		this.addWindowListener(ac);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
		
		Dimension size = new Dimension(200, 40);
		Dimension size2= new Dimension(100, 40);
		Dimension size3= new Dimension(240, 60);
		Dimension sizeMini= new Dimension(50, 30);
		Dimension size_DanhMuc = new Dimension(150, 80);
		Dimension size_BtnFooter = new Dimension(175, 40);
		
		Dimension size_NSHienco = new Dimension(250,80);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		contentPane.setLayout(new BorderLayout());
		
		//header
		JPanel header = new JPanel();
		header.setBackground(new Color(242,246,245));
		
		JLabel txtNhapTT = new JLabel("Nhập Thông Tin");
		txtNhapTT.setFont(new Font("sansserif", 1, 30));
		
		
		
		contentPane.add(header, BorderLayout.NORTH);
		
		JButton jButton_NS = new JButton("Ngân sách hiện có");
		jButton_NS.setFont(new Font("sansserif", 1, 22));
		jButton_NS.setPreferredSize(size_NSHienco);
		jButton_NS.setMinimumSize(sizeMini);
		jButton_NS.setBackground(color_BackChon);
		jButton_NS.setForeground(color_ForeChon);
		jButton_NS.addActionListener(ac);
		
		JPanel cover3_1 = new JPanel();
		cover3_1.setBackground(new Color(242, 246, 245));
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_header.createSequentialGroup()
							.addGap(159)
							.addComponent(txtNhapTT)
							.addPreferredGap(ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
							.addComponent(jButton_NS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_header.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cover3_1, GroupLayout.PREFERRED_SIZE, 941, GroupLayout.PREFERRED_SIZE)))
					.addGap(49))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_header.createSequentialGroup()
							.addGap(21)
							.addComponent(txtNhapTT))
						.addGroup(gl_header.createSequentialGroup()
							.addContainerGap()
							.addComponent(jButton_NS, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(cover3_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		header.setLayout(gl_header);
	
		
		//footer
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
		jButton_NganSach.setBackground(color_BackChon);
		jButton_NganSach.setForeground(color_ForeChon);
		
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
		jButton_Khac.setName("size_BtnFooter");
		jButton_Khac.setFont(new Font("sansserif", 1, 22));
		jButton_Khac.setPreferredSize(size);
		jButton_Khac.setMinimumSize(sizeMini);
		jButton_Khac.setBackground(color_BackKhong);
		jButton_Khac.setForeground(color_ForeKhong);
		jButton_Khac.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		jButton_Khac.addActionListener(ac);
		
		JPanel cover3 = new JPanel();
		cover3.setBackground(new Color(242,246,245));
		JPanel cover4 = new JPanel();
		cover4.setBackground(new Color(242,246,245));
		contentPane.add(footer, BorderLayout.SOUTH);
		GroupLayout gl_footer = new GroupLayout(footer);
		gl_footer.setHorizontalGroup(
			gl_footer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_footer.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_footer.createParallelGroup(Alignment.LEADING)
						.addComponent(cover3, GroupLayout.PREFERRED_SIZE, 941, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(cover4, GroupLayout.PREFERRED_SIZE, 941, GroupLayout.PREFERRED_SIZE)))
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton jButton_them = new JButton("Thêm ngân sách");
		jButton_them.setPreferredSize(new Dimension(240, 60));
		jButton_them.setName("Nhập khoản");
		jButton_them.setMinimumSize(new Dimension(50, 30));
		jButton_them.setForeground(Color.WHITE);
		jButton_them.setFont(new Font("SansSerif", Font.BOLD, 25));
		jButton_them.setBackground(new Color(7, 164, 121));
		jButton_them.addActionListener(ac);
		
		JLabel txtTien = new JLabel("Số tiền");
		txtTien.setName("Tiền chi");
		txtTien.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		txtTien2 = new JTextField();
		txtTien2.setPreferredSize(new Dimension(100, 40));
		txtTien2.setMinimumSize(new Dimension(50, 30));
		txtTien2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtTien2.setColumns(20);
		
		JLabel txtNgayKetThuc = new JLabel("Ngày kết thúc");
		txtNgayKetThuc.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		txtNgay2 = new JDateChooser();
		txtNgay2.setDateFormatString("dd/MM/yyyy");
		txtNgay2.setPreferredSize(new Dimension(100, 40));
		txtNgay2.setMinimumSize(new Dimension(50, 30));
		txtNgay2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
	//	txtNgay2.setColumns(20);
		
		txtNgay1 = new JDateChooser();
		txtNgay1.setDateFormatString("dd/MM/yyyy");
		txtNgay1.setPreferredSize(new Dimension(100, 40));
		txtNgay1.setMinimumSize(new Dimension(50, 30));
		txtNgay1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		//txtNgay1.setColumns(20);
		
		JLabel txtNgayBatDau = new JLabel("Ngày bắt đầu");
		txtNgayBatDau.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		
		//danh muc
		
		JLabel txtDanhMuc = new JLabel("Danh Mục");
		txtDanhMuc.setFont(new Font("sansserif", 1, 20));
	
		JButton jButton_Chinh = new JButton("Chỉnh sửa >");
		jButton_Chinh.setName("Chỉnh sửa");
		jButton_Chinh.setFont(new Font("sansserif", 1, 15));
		jButton_Chinh.setBackground(Color.white);
		jButton_Chinh.setPreferredSize(size_DanhMuc);
		jButton_Chinh.setMinimumSize(sizeMini);
		jButton_Chinh.setVerticalTextPosition(AbstractButton.BOTTOM);
		jButton_Chinh.setHorizontalTextPosition(AbstractButton.CENTER);
		jButton_Chinh.addActionListener(ac);
		
        try {
			//bước 1: tạo kết nối
			Connection con = JDBCUtil.getConnection();
			//bước 2: tạo đối tượng statement
		
				String sql = "SELECT * FROM category WHERE username = ? AND loai = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, user.getUsername());
				pst.setInt(2, loai);
				
				//Bước 3: tạo câu lệnh
							
				ResultSet rs = pst.executeQuery();
				//bước 4 xử lí kết quả
				while(rs.next()) {
					listDanhMuc.put(rs.getString("danhMuc"), rs.getString("icon"));
				}
			//bước 5 ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                   
        
        JButton[] button = new JButton[listDanhMuc.size()];
        int i = 0;
        click = new LinkedHashMap<>();
        for(String key :  listDanhMuc.keySet()) {
        	button[i] = new JButton(key);
        	button[i].setName(key);
        	button[i].setFont(new Font("sansserif", 1, 15));
        	button[i].setBackground(Color.white);
        	button[i].setPreferredSize(size_DanhMuc);
        	button[i].setMinimumSize(sizeMini);
        	button[i].setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/"+ listDanhMuc.get(key))));
        	button[i].setVerticalTextPosition(AbstractButton.BOTTOM);
        	button[i].setHorizontalTextPosition(AbstractButton.CENTER);
        	button[i].addActionListener(ac);
        	click.put(button[i], 0);
        	i++;
        }
			
		JPanel panel_CacDanhMuc = new JPanel();
		panel_CacDanhMuc.setLayout(new GridBagLayout());
		panel_CacDanhMuc.setBackground(Color.white);
		GridBagConstraints contaiDanhMuc = new GridBagConstraints();
		contaiDanhMuc.insets = new Insets(5, 5, 5, 5);
		
		
		int x =0, y = 1;
		for(JButton key : click.keySet()) {
			contaiDanhMuc.gridx = x++;
			contaiDanhMuc.gridy = y;
			panel_CacDanhMuc.add(key, contaiDanhMuc);
			if(x == 3) {
				x = 0;
				y++;
			}
		}
		contaiDanhMuc.gridx = x;
		contaiDanhMuc.gridy = y;
		panel_CacDanhMuc.add(jButton_Chinh, contaiDanhMuc);
			
		JScrollPane crollDanhMuc = new JScrollPane(panel_CacDanhMuc);
		crollDanhMuc.setBorder(BorderFactory.createEmptyBorder());
		
		
		txtDanhMuc.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(txtNgayBatDau, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(txtNgay1, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtNgayKetThuc, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTien, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
									.addGap(31)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtTien2, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
										.addComponent(txtNgay2, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))))
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(92)
							.addComponent(jButton_them, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))
					.addGap(59)
					.addComponent(crollDanhMuc, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(523, Short.MAX_VALUE)
					.addComponent(txtDanhMuc, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(359))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(9)
					.addComponent(txtDanhMuc, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtNgayBatDau, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addGap(2))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtNgay1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(30)
									.addComponent(txtNgayKetThuc, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(txtNgay2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(37)
									.addComponent(txtTien, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(25)
									.addComponent(txtTien2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
							.addComponent(jButton_them, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(54))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(crollDanhMuc, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
							.addContainerGap())))
		);
		panel.setLayout(gl_panel);
		this.setVisible(true);
					
	}
	
	public void setBorderClick(JButton button) {
		if(click.get(button) == 0) {
			for(JButton btn : click.keySet()) {
				if(click.get(btn) == 1) {
					btn.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1));
					click.put(btn,click.get(btn)-1);
				}
			}
			button.setBorder(BorderFactory.createLineBorder(new Color(7, 164, 121), 3));
			click.put(button,click.get(button)+1);
			stringBtn = button.getName();
		}
	}
	
	public User getUser() {
		return user;
	}
	
	public void  getNameUser() {
		System.out.println(user.getUsername());
	}
	
	public void addBudget() {
		int soTien = 0;	
		try {
			soTien = Integer.parseInt(txtTien2.getText());
		}catch(NumberFormatException e) {
			soTien =0;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date1;
		String date2;
		try {
			date1 = dateFormat.format(txtNgay1.getDate());
			date2 = dateFormat.format(txtNgay1.getDate());
		}catch(NullPointerException e) {
			date1 = "";
			date2 = "";
		}
		budget.addBudget(user.getUsername(),soTien,dateTimeSQL(date1),dateTimeSQL(date2), stringBtn);
	}
	
	public Date dateTimeSQL(String dateString) {
		if(dateString.equals(""))
			return null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(dateString, formatter);
        Date date = java.sql.Date.valueOf(localDate);
        return date;
		}	
	
	public String dateTime (String date) {
		if(date.trim().equals(""))
			return "";
		String[] tokens = date.split("/");
		
		if(tokens.length != 3)
			return "";
		
		if(Integer.parseInt(tokens[0]) <10 && Integer.parseInt(tokens[1]) < 10) {
			return "0"+tokens[0] +"/0"+ tokens[1]+ "/" + tokens[2];
		}
		else if(Integer.parseInt(tokens[1]) < 10) {
			return tokens[0] +"/0"+ tokens[1]+ "/" + tokens[2];
		}else if(Integer.parseInt(tokens[0]) < 10) {
			return "0"+tokens[0] +"/"+ tokens[1]+ "/" + tokens[2];
		}
		else if(date.length() == 10)
			return tokens[0] +"/"+ tokens[1]+ "/" + tokens[2];
		else
			return "";
	}
	
	public String formName() {
		return "Ngân sách";
	}
}
