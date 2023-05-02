package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Category;
import Model.Transaction;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Controller.ListCateController;
import Model.User;
import database.JDBCUtil;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;


public class FormListCate extends JFrame {

	private JPanel contentPane;
	private User user = new User();
	private Category cate = new Category();
	private JTable table;
	private int loai;
	private JButton jButton_thu;
	private JButton jButton_chi;
	private String formBack;
	private Transaction transaction;
	private String nameBack;
	
	public FormListCate(User user, String formBack) {
		this.user = user;
		this.loai = 0;
		this.formBack = formBack;
		this.init();
		insertData(table, loai);
	}
	
	public FormListCate(User user, String formBack, Transaction transaction) {
		this.user = user;
		this.loai = 0;
		this.formBack = formBack;
		this.transaction = transaction;
		this.init();
		insertData(table, loai);
	}
	
	public FormListCate(User user, String formBack, Transaction transaction, String nameBack) {
		this.user = user;
		this.loai = 0;
		this.formBack = formBack;
		this.nameBack = nameBack;
		this.transaction = transaction;
		this.init();
		insertData(table, loai);
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
		
		ListCateController ac = new ListCateController(this);
		this.addWindowListener(ac);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
		
		Dimension size = new Dimension(200, 40);
		Dimension sizeMini= new Dimension(50, 30);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		contentPane.setLayout(new BorderLayout());
		
		//header
		JPanel header = new JPanel();
		header.setBackground(new Color(242,246,245));
		
		jButton_thu = new JButton("Thu Nhập");
		jButton_thu.setName("Tiền thu");
		jButton_thu.setFont(new Font("sansserif", 1, 22));
		jButton_thu.setPreferredSize(size);
		jButton_thu.setMinimumSize(sizeMini);
		jButton_thu.setBackground(color_BackKhong);
		jButton_thu.setForeground(color_ForeKhong);
		jButton_thu.setBorder(BorderFactory.createLineBorder(color_BackKhong, 2));
		jButton_thu.addActionListener(ac);
		
		jButton_chi = new JButton("Chi Tiêu");
		jButton_chi.setFont(new Font("sansserif", 1, 22));
		jButton_chi.setPreferredSize(size);
		jButton_chi.setMinimumSize(sizeMini);
		jButton_chi.setBackground(color_BackChon);
		jButton_chi.setForeground(color_ForeChon);
		jButton_chi.addActionListener(ac);
		
		
		JPanel cover1 = new JPanel();
		cover1.setBackground(new Color(242,246,245));
		JPanel cover2 = new JPanel();
		cover2.setBackground(new Color(242,246,245));
		contentPane.add(header, BorderLayout.NORTH);
		
		JButton jButton_back = new JButton();
		jButton_back.setIcon(new ImageIcon(FormListCate.class.getResource("/Icon/back32.png")));
		jButton_back.setName("back");
		jButton_back.setBorder(BorderFactory.createLineBorder(new Color(242,246,245), 2));
		jButton_back.setBackground(new Color(242, 246, 245));
		jButton_back.addActionListener(ac);
		
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(22)
					.addComponent(jButton_back, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(212)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(cover1, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_header.createSequentialGroup()
							.addComponent(jButton_chi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(jButton_thu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(cover2, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_header.createSequentialGroup()
							.addComponent(cover1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
								.addComponent(jButton_chi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton_thu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(4)
							.addComponent(cover2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_header.createSequentialGroup()
							.addContainerGap()
							.addComponent(jButton_back, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		header.setLayout(gl_header);

		this.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton jButton_ThemDanhMuc = new JButton("Thêm danh mục");
		jButton_ThemDanhMuc.setPreferredSize(new Dimension(200, 40));
		jButton_ThemDanhMuc.setMinimumSize(new Dimension(50, 30));
		jButton_ThemDanhMuc.setForeground(Color.WHITE);
		jButton_ThemDanhMuc.setFont(new Font("SansSerif", Font.BOLD, 22));
		jButton_ThemDanhMuc.setBackground(new Color(7, 164, 121));
		jButton_ThemDanhMuc.addActionListener(ac);
		
		JButton jButton_Xoa = new JButton("Xóa danh mục");
		jButton_Xoa.setPreferredSize(new Dimension(200, 40));
		jButton_Xoa.setMinimumSize(new Dimension(50, 30));
		jButton_Xoa.setForeground(Color.WHITE);
		jButton_Xoa.setFont(new Font("SansSerif", Font.BOLD, 22));
		jButton_Xoa.setBackground(new Color(7, 164, 121));
		jButton_Xoa.addActionListener(ac);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(67)
					.addComponent(jButton_ThemDanhMuc, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
					.addGap(417)
					.addComponent(jButton_Xoa, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addGap(86))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(jButton_Xoa, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(jButton_ThemDanhMuc, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
							.addGap(32))))
		);
		panel.setLayout(gl_panel);
		
		JPanel panelListCate = new JPanel();
		panelListCate.setBackground(new Color(255, 255, 255));
		contentPane.add(panelListCate, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Danh mục"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
	    table.setRowHeight(50); // tăng chiều cao của các hàng thành 30 pixel
	    table.setFont(new Font("sansserif", Font.PLAIN, 16)); // tăng kích thước của chữ trong bảng thành 16 pixel
		
		JScrollPane scrollpane = new JScrollPane(table);
		
		GroupLayout gl_panelListCate = new GroupLayout(panelListCate);
		gl_panelListCate.setHorizontalGroup(
			gl_panelListCate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelListCate.createSequentialGroup()
					.addGap(47)
					.addComponent(scrollpane, GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
					.addGap(58))
		);
		gl_panelListCate.setVerticalGroup(
			gl_panelListCate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelListCate.createSequentialGroup()
					.addGap(37)
					.addComponent(scrollpane, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
					.addGap(18))
		);
		panelListCate.setLayout(gl_panelListCate);
		this.setVisible(true);
		
		
		
		
	}
	
	
	private void insertData(JTable table, int loai) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        table.setModel(model);
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
				model.addRow(new Object[]{rs.getString("danhMuc")});
			}
			
			//bước 5 ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }	
	
	
	
	
	
	public void tableChiTieu() {
		jButton_chi.setBackground(new Color(7, 164, 121));
		jButton_chi.setForeground(new Color(255,255,255));
		
		jButton_thu.setBackground(new Color(218, 235, 231));
		jButton_thu.setForeground(new Color(7, 164, 121));
		jButton_thu.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		
		loai = 0;
		insertData(table, loai);
	}
	public void tableThuNhap() {
		jButton_chi.setBackground(new Color(218, 235, 231));
		jButton_chi.setForeground(new Color(7, 164, 121));
		jButton_chi.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		
		jButton_thu.setBackground(new Color(7, 164, 121));
		jButton_thu.setForeground(new Color(255,255,255));
		
		loai = 1;
		insertData(table, loai);
	}
	
	public void deleteCate() {
		String name = getNameCate();
		cate.deleteCate(user.getUsername(), name);
	}
	
	private String getNameCate() {
		int row = table.getSelectedRow();
		return table.getValueAt(row, 0).toString();
		
	}
	
	public void reloadTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		table.setModel(model);
		insertData(table, loai);
	}
	
	public User getUser() {
		return user;
	}
	
	public String formBack() {
		return formBack;
	}
	
	public String nameBack() {
		return nameBack;
	}
	
	public Transaction getTranBack() {
		return transaction;
	}
}
