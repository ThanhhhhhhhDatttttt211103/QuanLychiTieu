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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controller.Copy_ThuController;
import Model.Transaction;
import Model.User;
import database.JDBCUtil;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;


public class FormCopy_Thu extends JFrame {

	private JPanel contentPane;
	private Map<String, String> listDanhMuc;
	private Map<JButton, Integer> click;
	private int day;
	private int year;
	private int month;
	private Calendar calendar;
	private JLabel txtDate; 
	private User user = new User();
	private Transaction transaction;
	private String stringBtn;
	private JTextField txtTien2;
	private JTextField txtGhiChu2;
	private int loai;
	
	public FormCopy_Thu(User user, Transaction transaction) {
		this.user = user;
		this.transaction = transaction;
		this.listDanhMuc = new LinkedHashMap<>();
		this.loai = 1;
		this.init();
		capNhatThongTin();
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
		
		Copy_ThuController ac = new Copy_ThuController(this);
		this.addWindowListener(ac);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
		
		Dimension size = new Dimension(200, 40);
		Dimension size2= new Dimension(100, 40);
		Dimension size3= new Dimension(240, 60);
		Dimension sizeMini= new Dimension(50, 30);
		Dimension size_DanhMuc = new Dimension(150, 80);
		Dimension size_BtnFooter = new Dimension(175, 40);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		contentPane.setLayout(new BorderLayout());
		
		//header 
		JPanel header = new JPanel();
		header.setBackground(new Color(242,246,245));
	
		JButton jButton_thu = new JButton("Tiền thu");
		jButton_thu.setBackground(color_BackChon);
		jButton_thu.setForeground(color_ForeChon);
		jButton_thu.setName("Tiền thu");
		jButton_thu.setFont(new Font("sansserif", 1, 22));
		jButton_thu.setPreferredSize(size);
		jButton_thu.setMinimumSize(size);
		
		jButton_thu.setBackground(new Color(7, 164, 121));
		jButton_thu.setForeground(new Color(255,255,255));
		
		JButton jButton_chi = new JButton("Tiền chi");
		jButton_chi.setBackground(color_BackKhong);
		jButton_chi.setForeground(color_ForeKhong);
		jButton_chi.setName("Tiền chi");
		jButton_chi.setFont(new Font("sansserif", 1, 22));
		jButton_chi.setPreferredSize(size);
		jButton_chi.setMinimumSize(size);
		jButton_chi.addActionListener(ac);
		jButton_chi.setBorder(BorderFactory.createLineBorder(color_BackKhong, 2));
		
		JPanel cover1 = new JPanel();
		cover1.setBackground(new Color(242,246,245));
		JPanel cover2 = new JPanel();
		cover2.setBackground(new Color(242,246,245));
		
		contentPane.add(header, BorderLayout.NORTH);
		
		JButton jButton_back = new JButton();
		jButton_back.setIcon(new ImageIcon(FormCopy_Thu.class.getResource("/Icon/back32.png")));
		jButton_back.setName("back");
		jButton_back.setBorder(BorderFactory.createLineBorder(new Color(242,246,245), 2));
		jButton_back.setBackground(new Color(242, 246, 245));
		jButton_back.addActionListener(ac);
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(296)
					.addComponent(cover1, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_header.createSequentialGroup()
					.addGap(18)
					.addComponent(jButton_back, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(216)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_header.createSequentialGroup()
							.addComponent(jButton_chi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(jButton_thu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(cover2, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addComponent(cover1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(jButton_back, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_header.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
								.addComponent(jButton_chi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_thu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(4)
							.addComponent(cover2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		header.setLayout(gl_header);
		
		
		
		//content
		JPanel contentChi = new JPanel();
		contentChi.setBackground(new Color(255, 255, 255));
		
		JLabel txtNgay = new JLabel("Ngày");
		txtNgay.setFont(new Font("sansserif", 1, 20));
		
		JButton jButton_down = new JButton();
		jButton_down.setName("down");
		jButton_down.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/leftIcon.png")));
		jButton_down.setFont(new Font("sansserif", 1, 15));
		jButton_down.setBackground(new Color(255, 255, 255));
		jButton_down.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		jButton_down.addActionListener(ac);
		
		calendar = Calendar.getInstance();
		day = calendar.get(Calendar.DATE);
		month = calendar.get(Calendar.MONTH) + 1;
		year = calendar.get(Calendar.YEAR);
		
		txtDate = new JLabel(day + " / " +month + " / " + year);
		txtDate.setFont(new Font("SansSerif", Font.BOLD, 22));
		
		JButton jButton_up = new JButton();
		jButton_up.setName("up");
		jButton_up.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/rightIcon.png")));
		jButton_up.setFont(new Font("sansserif", 1, 15));
		jButton_up.setBackground(new Color(255, 255, 255));
		jButton_up.setBorder(BorderFactory.createLineBorder(Color.white));
		jButton_up.addActionListener(ac);
		
		JLabel txtGhiChu = new JLabel("Ghi chú");
		txtGhiChu.setFont(new Font("sansserif", 1, 20));
		txtGhiChu2 = new JTextField();
		txtGhiChu2 = new JTextField();
		txtGhiChu2.setColumns(20);
		
		txtGhiChu2.setPreferredSize(size2);
		txtGhiChu2.setMinimumSize(sizeMini);
		txtGhiChu2.setFont(new Font("Times New Roman", 0, 17));
		
		JLabel txtTien = new JLabel("Tiền chi");
		txtTien.setName("Tiền chi");
		txtTien.setFont(new Font("sansserif", 1, 20));
		txtTien2 = new JTextField();
		txtTien2 = new JTextField();
		txtTien2.setColumns(20);
		
		txtTien2.setPreferredSize(size2);
		txtTien2.setMinimumSize(sizeMini);
		txtTien2.setFont(new Font("Times New Roman", 0, 17));
		
		JButton jButton_them = new JButton("Nhập khoản thu");
		jButton_them.setName("Nhập khoản");
		jButton_them.setFont(new Font("sansserif", 1, 25));
		jButton_them.setPreferredSize(size3);
		jButton_them.setMinimumSize(sizeMini);
		jButton_them.setBackground(color_BackChon);
		jButton_them.setForeground(color_ForeChon);
		jButton_them.addActionListener(ac);
		
		//Danh Muc
		
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
		
		contentPane.add(contentChi, BorderLayout.CENTER);
		
		//footer
		JPanel footer = new JPanel();
		footer.setBackground(new Color(242,246,245));
		
		JButton jButton_Nhap = new JButton();
		jButton_Nhap.setName("Nhập vào");
		jButton_Nhap.setFont(new Font("sansserif", 1, 22));
		jButton_Nhap.setPreferredSize(size_BtnFooter);
		jButton_Nhap.setMinimumSize(sizeMini);
		jButton_Nhap.setBackground(new Color(242,246,245));
		jButton_Nhap.setForeground(new Color(242,246,245));
		jButton_Nhap.setBorder(BorderFactory.createLineBorder(new Color(242,246,245), 2));
		
		
		JPanel cover3 = new JPanel();
		cover3.setBackground(new Color(242,246,245));
		JPanel cover4 = new JPanel();
		cover4.setBackground(new Color(242,246,245));
		contentPane.add(footer, BorderLayout.SOUTH);
		GroupLayout gl_footer = new GroupLayout(footer);
		gl_footer.setHorizontalGroup(
			gl_footer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_footer.createSequentialGroup()
					.addGap(413)
					.addGroup(gl_footer.createParallelGroup(Alignment.LEADING)
						.addComponent(cover3, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton_Nhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cover4, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
		);
		gl_footer.setVerticalGroup(
			gl_footer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_footer.createSequentialGroup()
					.addComponent(cover3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(jButton_Nhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(cover4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		footer.setLayout(gl_footer);


		this.setContentPane(contentPane);
		this.setVisible(true);	
		GroupLayout gl_contentChi = new GroupLayout(contentChi);
		gl_contentChi.setHorizontalGroup(
			gl_contentChi.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentChi.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentChi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentChi.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentChi.createSequentialGroup()
								.addComponent(txtTien)
								.addGap(33)
								.addComponent(txtTien2, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE))
							.addGroup(gl_contentChi.createSequentialGroup()
								.addGroup(gl_contentChi.createParallelGroup(Alignment.LEADING)
									.addComponent(txtGhiChu)
									.addComponent(txtNgay))
								.addGap(33)
								.addGroup(gl_contentChi.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentChi.createSequentialGroup()
										.addComponent(jButton_down)
										.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
										.addComponent(txtDate)
										.addGap(54)
										.addComponent(jButton_up))
									.addComponent(txtGhiChu2, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE))))
						.addGroup(gl_contentChi.createSequentialGroup()
							.addGap(86)
							.addComponent(jButton_them, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(63)))
					.addGap(40)
					.addGroup(gl_contentChi.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDanhMuc)
						.addGroup(gl_contentChi.createSequentialGroup()
							.addGap(10)
							.addComponent(crollDanhMuc, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)))
					.addGap(20))
		);
		gl_contentChi.setVerticalGroup(
			gl_contentChi.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentChi.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addComponent(txtDanhMuc)
					.addGroup(gl_contentChi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentChi.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentChi.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtNgay)
								.addComponent(jButton_down)
								.addComponent(jButton_up)
								.addComponent(txtDate))
							.addGroup(gl_contentChi.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentChi.createSequentialGroup()
									.addGap(47)
									.addComponent(txtGhiChu))
								.addGroup(gl_contentChi.createSequentialGroup()
									.addGap(35)
									.addComponent(txtGhiChu2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentChi.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentChi.createSequentialGroup()
									.addGap(43)
									.addComponent(txtTien))
								.addGroup(gl_contentChi.createSequentialGroup()
									.addGap(41)
									.addComponent(txtTien2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(44)
							.addComponent(jButton_them, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(crollDanhMuc, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		contentChi.setLayout(gl_contentChi);	
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
	
	public void tangMotNgay() {
		tinhNgay();
		calendar.add(Calendar.DATE, 1);
		int day2 = calendar.get(Calendar.DATE);
		int month2 = calendar.get(Calendar.MONTH) +1;
		int year2 = calendar.get(Calendar.YEAR);
		setTextDate(day2, month2, year2);
	}
	
	private void setTextDate(int day, int month, int year) {
		this.txtDate.setText(day + " / " + month + " / " + year);
	}
	
	public void giamMotNgay() {
		tinhNgay();
		calendar.add(Calendar.DATE, -1);
		int day2 = calendar.get(Calendar.DATE);
		int month2 = calendar.get(Calendar.MONTH) +1;
		int year2 = calendar.get(Calendar.YEAR);
		setTextDate(day2, month2, year2);
	}
	
	private void tinhNgay() {
	    String[] tokens = txtDate.getText().split(" / ");
	    int day = Integer.parseInt(tokens[0]);
	    int month = Integer.parseInt(tokens[1]) - 1; // Tháng bắt đầu từ 0
	    int year = Integer.parseInt(tokens[2]);
	    calendar.setTime(new Date(year-1900, month, day)); // Thiết lập ngày tháng năm cho Calendar
	}
	
	public User getUser() {
		return user;
	}
	public void  getNameUser() {
		System.out.println(user.getUsername());
	}
	
	public void nameBtn() {
		System.out.println(stringBtn);
	}
	
	private void capNhatThongTin() {
		txtGhiChu2.setText(transaction.getNote());
		txtTien2.setText(transaction.getMoney()+"");
		for(JButton btn : click.keySet()) {
			if(btn.getName().toString().equals(transaction.getCategory()))
				setBorderClick(btn);
		}
		System.out.println(transaction.getDate());			
		String tokens[] = transaction.getDate().toString().split("-");
		txtDate.setText(Integer.parseInt(tokens[2]) + " / " + Integer.parseInt(tokens[1]) + " / " + Integer.parseInt(tokens[0]));
	}
	
	
	public void addTrans() {
		int soTien = 0;
		String[] tokens = txtDate.getText().split(" / ");
		try {
			soTien = Integer.parseInt(txtTien2.getText());
		}catch(NumberFormatException e) {
			soTien =0;
		}
		String date = dateTime(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
		transaction.addTrans(user.getUsername(),stringBtn,dateTimeSQL(date),soTien, txtGhiChu2.getText() , 1);
	}
	
	
	public Date dateTimeSQL(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        Date date = java.sql.Date.valueOf(localDate);
        return date;
	}
	
	public String dateTime (int day, int month, int year) {
		if(month <10 && day < 10) {
			return "0"+day +"/0"+ month+ "/" + year;
		}
		else if(month < 10) {
			return day +"/0"+ month+ "/" + year;
		}else if(day < 10) {
			return "0"+day +"/"+ month+ "/" + year;
		}
		else
			return day +"/"+ month+ "/" + year;
		}
	
	public Transaction getTran() {
		return transaction;
	}
	public String getNameForm() {
		return "copyThu";
	}
}
