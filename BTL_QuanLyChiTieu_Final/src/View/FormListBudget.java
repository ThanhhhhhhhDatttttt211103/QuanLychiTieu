package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controller.ListBudgetController;
import Model.Budget;
import Model.User;
import database.JDBCUtil;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class FormListBudget extends JFrame {
	  
	private JPanel contentPanel;
	private JTable tableListBud;
	private JTable table_NganSachHT;
	private JPanel panel_NSHT;
	private User user = new User();
	private JPanel panel_CapNhat;
	private JTextField fieldBatDau;
	private JTextField fieldDanhMuc;
	private JTextField fieldSoTien;
	private JTextField fieldKetThuc;
	private Budget budget;
	private JLabel iD;
	
	
	public FormListBudget(User user) {
		this.user = user;
		this.budget = new Budget();
		init();
		insertDataBudGet(tableListBud);
		insertDataHT(table_NganSachHT);
		
	}
	public void init() {
		this.setTitle("Quản lý chi tiêu");
		this.setSize(1020, 600);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
		this.setLocationRelativeTo(null);
		
		ListBudgetController ac = new ListBudgetController(this);
		this.addWindowListener(ac);
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBackground(Color.white);
		
		Color color_BackChon = new Color(7, 164, 121);
		Color color_ForeChon = new Color(255,255,255);
		Color color_BackKhong = new Color(218, 235, 231);
		Color color_ForeKhong = new Color(7, 164, 121);
		
		Dimension size = new Dimension(200, 40);
		Dimension sizeMini= new Dimension(50, 30);
		Dimension size_BtnFooter = new Dimension(175, 40);
				
		JPanel header = new JPanel();
		header.setBackground(new Color(242,246,245));
				
		contentPanel.add(header, BorderLayout.NORTH);
				
		JLabel txtDanhSachNS = new JLabel("Danh sách ngân sách");
		txtDanhSachNS.setFont(new Font("SansSerif", Font.BOLD, 30));
		
		JButton jButton_back = new JButton("");
		jButton_back.setName(("back"));
		jButton_back.setBackground(new Color(242,246,245));
		jButton_back.setBorder(BorderFactory.createLineBorder(new Color(242,246,245), 2));
		jButton_back.setIcon(new ImageIcon(FormListBudget.class.getResource("/Icon/back32.png")));
		jButton_back.addActionListener(ac);
		

		
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(30)
					.addComponent(jButton_back, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addGap(251)
					.addComponent(txtDanhSachNS, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
					.addGap(352))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_header.createSequentialGroup()
							.addGap(20)
							.addComponent(jButton_back, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_header.createSequentialGroup()
							.addGap(29)
							.addComponent(txtDanhSachNS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(11)))
					.addGap(22))
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
		jButton_Danhsach.setName("Danh sách");
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
		contentPanel.add(footer, BorderLayout.SOUTH);
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
		
		
		
		getContentPane().add(contentPanel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPanel.add(panel, BorderLayout.CENTER);
		
		JPanel panelList = new JPanel();
		panelList.setBackground(Color.WHITE);
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelList, GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addComponent(panelList, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableListBud = new JTable();
		tableListBud.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableListBud.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Danh mục", "Số tiền", "Ngày bắt đầu", "Ngày kết thúc"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableListBud.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableListBud.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableListBud.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableListBud.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableListBud.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableListBud.setBounds(0, 0, 948, 593);

	    JScrollPane scrollPaneListTran = new JScrollPane(tableListBud);
	    
	    tableListBud.setRowHeight(30); // tăng chiều cao của các hàng thành 30 pixel
	    tableListBud.setFont(new Font("Tahoma", Font.PLAIN, 16)); // tăng kích thước của chữ trong bảng thành 16 pixel
		
		JButton jButton_Sua = new JButton("Sửa ngân sách");
		jButton_Sua.setName("Sửa ngân sách");
		jButton_Sua.setFont(new Font("sansserif", 1, 16));
		jButton_Sua.setBackground(color_BackChon);
		jButton_Sua.setForeground(color_ForeChon);
		jButton_Sua.addActionListener(ac);
		
		JLayeredPane layeredPane = new JLayeredPane();
		
		
		GroupLayout gl_panelList = new GroupLayout(panelList);
		gl_panelList.setHorizontalGroup(
			gl_panelList.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelList.createSequentialGroup()
					.addGroup(gl_panelList.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panelList.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPaneListTran, GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE))
						.addGroup(gl_panelList.createSequentialGroup()
							.addGap(72)
							.addComponent(jButton_Sua, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(80)
							.addComponent(layeredPane, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelList.setVerticalGroup(
			gl_panelList.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelList.createSequentialGroup()
					.addComponent(scrollPaneListTran, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelList.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelList.createSequentialGroup()
							.addGap(88)
							.addComponent(jButton_Sua, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelList.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(392, Short.MAX_VALUE))
		);
		
		
		panel_NSHT = new JPanel();
		panel_NSHT.setBounds(0, 0, 676, 208);
		
		panel_CapNhat = new JPanel();
		panel_CapNhat.setBounds(0, 0, 676, 208);
		
		layeredPane.add(panel_CapNhat, Integer.valueOf(1));
		
		JLabel txtDanhMuc = new JLabel("Danh mục: ");
		txtDanhMuc.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		JLabel txtNgayBatDau = new JLabel("Ngày bắt đầu : ");
		txtNgayBatDau.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		JButton jButtonXoa = new JButton("Xóa");
		jButtonXoa.setName("Xóa");
		jButtonXoa.setForeground(Color.WHITE);
		jButtonXoa.setFont(new Font("SansSerif", Font.BOLD, 16));
		jButtonXoa.setBackground(new Color(7, 164, 121));
		jButtonXoa.addActionListener(ac);
		
		fieldBatDau = new JTextField();
		fieldBatDau.setColumns(10);
		fieldBatDau.setFont(new Font("SansSerif", 0, 16));
		
		fieldDanhMuc = new JTextField();
		fieldDanhMuc.setColumns(10);
		fieldDanhMuc.setFont(new Font("SansSerif", 0, 16));
		
		JLabel txtNgayKetThuc = new JLabel("Ngày kết thúc : ");
		txtNgayKetThuc.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		JLabel txtSoTien = new JLabel("Số tiền:");
		txtSoTien.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		fieldSoTien = new JTextField();
		fieldSoTien.setColumns(10);
		fieldSoTien.setFont(new Font("SansSerif", 0, 16));
		
		fieldKetThuc = new JTextField();
		fieldKetThuc.setColumns(10);
		fieldKetThuc.setFont(new Font("SansSerif", 0, 16));
		
		JButton jButtonCapNhat = new JButton("Cập nhật");
		jButtonCapNhat.setName("Cập nhật");
		jButtonCapNhat.setForeground(Color.WHITE);
		jButtonCapNhat.setFont(new Font("SansSerif", Font.BOLD, 16));
		jButtonCapNhat.setBackground(new Color(7, 164, 121));
		jButtonCapNhat.addActionListener(ac);
		
		GroupLayout gl_panel_CapNhat = new GroupLayout(panel_CapNhat);
		gl_panel_CapNhat.setHorizontalGroup(
			gl_panel_CapNhat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_CapNhat.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel_CapNhat.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_CapNhat.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNgayBatDau))
						.addComponent(txtDanhMuc))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_CapNhat.createParallelGroup(Alignment.LEADING)
						.addComponent(fieldDanhMuc, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldBatDau, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
					.addGroup(gl_panel_CapNhat.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_CapNhat.createSequentialGroup()
							.addComponent(txtSoTien, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(fieldSoTien, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_CapNhat.createSequentialGroup()
							.addComponent(txtNgayKetThuc)
							.addGap(11)
							.addComponent(fieldKetThuc, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
					.addGap(32))
				.addGroup(gl_panel_CapNhat.createSequentialGroup()
					.addGap(105)
					.addComponent(jButtonXoa, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
					.addComponent(jButtonCapNhat, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(130))
		);
		gl_panel_CapNhat.setVerticalGroup(
			gl_panel_CapNhat.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_CapNhat.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_CapNhat.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_CapNhat.createSequentialGroup()
							.addGroup(gl_panel_CapNhat.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDanhMuc, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(fieldDanhMuc, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addGroup(gl_panel_CapNhat.createParallelGroup(Alignment.TRAILING)
								.addComponent(fieldBatDau, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNgayBatDau, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(fieldKetThuc, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_CapNhat.createSequentialGroup()
									.addGap(8)
									.addComponent(txtNgayKetThuc, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
							.addGap(18))
						.addGroup(gl_panel_CapNhat.createSequentialGroup()
							.addGroup(gl_panel_CapNhat.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_CapNhat.createSequentialGroup()
									.addComponent(fieldSoTien, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(54))
								.addGroup(gl_panel_CapNhat.createSequentialGroup()
									.addComponent(txtSoTien, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(54)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel_CapNhat.createParallelGroup(Alignment.LEADING)
						.addComponent(jButtonXoa, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButtonCapNhat, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
		);
		panel_CapNhat.setLayout(gl_panel_CapNhat);
		layeredPane.add(panel_NSHT, Integer.valueOf(2));
		
		table_NganSachHT = new JTable();
		table_NganSachHT.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Danh mục", "Số tiền", "Ngày bắt đầu", "Ngày kết thúc"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_NganSachHT.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_NganSachHT.getColumnModel().getColumn(1).setPreferredWidth(120);
		table_NganSachHT.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_NganSachHT.getColumnModel().getColumn(3).setPreferredWidth(100);
		table_NganSachHT.getColumnModel().getColumn(4).setPreferredWidth(100);
		
		 JScrollPane scrollPaneListBub = new JScrollPane(table_NganSachHT);
		 table_NganSachHT.setRowHeight(30); // tăng chiều cao của các hàng thành 30 pixel
		 table_NganSachHT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 
		 JPanel panel_1 = new JPanel();
		 GroupLayout gl_panel_NSHT = new GroupLayout(panel_NSHT);
		 gl_panel_NSHT.setHorizontalGroup(
		 	gl_panel_NSHT.createParallelGroup(Alignment.TRAILING)
		 		.addGroup(gl_panel_NSHT.createSequentialGroup()
		 			.addGap(204)
		 			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 277, Short.MAX_VALUE)
		 			.addGap(195))
		 		.addComponent(scrollPaneListBub, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
		 );
		 gl_panel_NSHT.setVerticalGroup(
		 	gl_panel_NSHT.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_panel_NSHT.createSequentialGroup()
		 			.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
		 			.addGap(10)
		 			.addComponent(scrollPaneListBub, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
		 );
		 
		 JLabel lblNewLabel = new JLabel("Ngân sách đã hoàn thành");
		 panel_1.add(lblNewLabel);
		 
		 
		 lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		 panel_NSHT.setLayout(gl_panel_NSHT);
		panelList.setLayout(gl_panelList);
		
		
		
		
//		panel_NSHT.setVisible(false);
		
		panel.setLayout(gl_panel);
		this.setVisible(true);
		
		
	}
	
	
	private void insertDataBudGet(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        table.setModel(model);
        try {
			//bước 1: tạo kết nối
			Connection con = JDBCUtil.getConnection();
			//bước 2: tạo đối tượng statement
			
			String sql = "SELECT * FROM budget WHERE username = ? AND CURDATE() < ngayKetThuc";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			
			//Bước 3: tạo câu lệnh
			
		
			ResultSet rs = pst.executeQuery();
			//bước 4 xử lí kết quả
			while(rs.next()) {
				model.addRow(new Object[]{rs.getString("ID"), rs.getString("danhMuc"),rs.getString("soTien"),rs.getString("ngayBatDau"),rs.getString("ngayKetThuc")});
			}
			
			//bước 5 ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
	private void insertDataHT(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        table.setModel(model);
        try {
			//bước 1: tạo kết nối
			Connection con = JDBCUtil.getConnection();
			//bước 2: tạo đối tượng statement
			
			String sql = "SELECT * FROM budget WHERE username = ? AND CURDATE() > ngayKetThuc";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			
			//Bước 3: tạo câu lệnh
			
		
			ResultSet rs = pst.executeQuery();
			//bước 4 xử lí kết quả
			while(rs.next()) {
				model.addRow(new Object[]{rs.getString("ID"),rs.getString("danhMuc"),rs.getString("soTien"),rs.getString("ngayBatDau"),rs.getString("ngayKetThuc")});
			}
			
			//bước 5 ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
		
	public int layGiaTri() {
		int row =  tableListBud.getSelectedRow();
		if(row == -1) {
			JOptionPane.showMessageDialog(null,"Bạn chọn ngân sách nào ?");
			return  0;	
		}
		System.out.println(tableListBud.getValueAt(row, 0));
		fieldDanhMuc.setText(tableListBud.getValueAt(row, 1).toString());
		fieldSoTien.setText(tableListBud.getValueAt(row, 2).toString());
		String ngaybatDau = dateTimeCN(tableListBud.getValueAt(row, 3).toString());
		fieldBatDau.setText(ngaybatDau);
		String ngayketThuc = dateTimeCN(tableListBud.getValueAt(row, 4).toString());
		fieldKetThuc.setText(ngayketThuc);
		iD = new JLabel();
		iD.setText(tableListBud.getValueAt(row, 0).toString());
		return 1;
	}
	
	public void formCapNhat() {
		panel_NSHT.setVisible(false);
		panel_CapNhat.setVisible(true);
	}
	public void formHT() {
		panel_CapNhat.setVisible(false);
		panel_NSHT.setVisible(true);
	}
	
	public User getUser() {
		return user;
	}
	public void  getNameUser() {
		System.out.println(user.getUsername());
	}
	
	public void reloadTableListBud() {
		DefaultTableModel model = (DefaultTableModel) tableListBud.getModel();
		tableListBud.setModel(model);
		insertDataBudGet(tableListBud);
	}
	
	
	public void updateBudget() {
		String dateBatDau = dateTime(fieldBatDau.getText());
		String dateKetThuc = dateTime(fieldKetThuc.getText());
		int soTien = 0;
		try {
			soTien = Integer.parseInt(fieldSoTien.getText());
		}catch(NumberFormatException e) {
			soTien =0;
		}
		budget.updateBudget(user.getUsername(),iD.getText(), fieldDanhMuc.getText(), soTien,dateTimeSQL(dateBatDau) , dateTimeSQL(dateKetThuc));
	}
	
	public void deleteBudget() {
		budget.deleteBud(user.getUsername(), iD.getText());
	}
	
	
	private Date dateTimeSQL(String dateString) {
		if(dateString.equals("")) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        Date date = java.sql.Date.valueOf(localDate);
        return date;
	}
	
	private String dateTime (String date) {
		if(date.trim().equals(""))
			return "";
		String[] tokens = date.split("/");
		if(tokens.length != 3)
			return "";
		
		int day = Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		int year = Integer.parseInt(tokens[2]);
	
		
		if(day <10 && month < 10) {
			return "0" +day +"/0"+ month+ "/" + year;
		}
		else if(month < 10) {
			return day +"/0"+ month+ "/" + year;
		}else if(day < 10) {
			return "0"+day +"/"+ month+ "/" + year;
		}
		else
			return day +"/"+ month+ "/" + year;

	}
	
	public void reloadTable() {
		DefaultTableModel model = (DefaultTableModel) tableListBud.getModel();
		tableListBud.setModel(model);
		insertDataBudGet(tableListBud);
	}
	
	private String dateTimeCN (String date) {
		String[] tokens = date.split("-");	
		int day = Integer.parseInt(tokens[2]);
		int month = Integer.parseInt(tokens[1]);
		int year = Integer.parseInt(tokens[0]);
			
		if(day <10 && month < 10) {
			return "0"+day +"/0"+ month+ "/" + year;
		}
		else if(month < 10) {
			return day +"/0"+ month+ "/" + year;
		}else if(day < 10) {
			return "0"+day +"/"+ month+ "/" + year;
		}
		else if(date.length() == 10)
			return day +"/"+ month+ "/" + year;
		else
			return "";
	}
}
