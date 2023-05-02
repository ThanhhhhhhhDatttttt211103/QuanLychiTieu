package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import Controller.SearchController;
import Model.Transaction;
import Model.User;
import database.JDBCUtil;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FormSearch extends JFrame {
	private JPanel contentPane;
	private JTextField txtFSearch;
	private JTable table;
	private User user = new User();

	public FormSearch(User user) {
		this.user = user;
		this.init();
	}
	
	public void init() {
		this.setTitle("Quản lý chi tiêu");
		this.setSize(1020, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		
		
		contentPane.setBackground(Color.WHITE);
		
		Color color_BackChon = new Color(7, 164, 121);
		Color color_ForeChon = new Color(255,255,255);
		Color color_BackKhong = new Color(218, 235, 231);
		Color color_ForeKhong = new Color(7, 164, 121);
		
		SearchController ac = new SearchController(this);
		this.addWindowListener(ac);
		
		Dimension size = new Dimension(200, 40);
		Dimension size2= new Dimension(100, 40);
		Dimension size3= new Dimension(240, 60);
		Dimension sizeMini= new Dimension(50, 30);
		Dimension size_DanhMuc = new Dimension(150, 80);
		Dimension size_BtnFooter = new Dimension(175, 40);
		
		
		//header
		JPanel header = new JPanel();
		header.setBackground(new Color(242,246,245));
		contentPane.add(header, BorderLayout.NORTH);
		
		JLabel txtSearch = new JLabel("Tìm kiếm (Toàn thời gian)");
		txtSearch.setFont(new Font("SansSerif", Font.BOLD, 30));
		
		JButton jButton_back = new JButton();
		jButton_back.setIcon(new ImageIcon(FormSearch.class.getResource("/Icon/back32.png")));
		jButton_back.setName("back");
		jButton_back.setBorder(BorderFactory.createLineBorder(new Color(242,246,245), 2));
		jButton_back.setBackground(new Color(242, 246, 245));
		jButton_back.addActionListener(ac);
		
		
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(36)
					.addComponent(jButton_back, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addGap(227)
					.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
					.addGap(306))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_header.createSequentialGroup()
							.addGap(21)
							.addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(9))
						.addGroup(gl_header.createSequentialGroup()
							.addContainerGap()
							.addComponent(jButton_back, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)))
					.addGap(25))
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
				jButton_Danhsach.setBackground(color_BackChon);
				jButton_Danhsach.setForeground(color_ForeChon);
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
		
		
		
		this.setBackground(Color.WHITE);
		this.setContentPane(contentPane);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.WHITE);
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		JPanel panel_Search = new JPanel();
		
		JPanel panel_table = new JPanel();
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		gl_panelCenter.setHorizontalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_Search, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addGap(10)
					.addComponent(panel_table, GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panelCenter.setVerticalGroup(
			gl_panelCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCenter.createSequentialGroup()
					.addComponent(panel_Search, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_table, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Danh m\u1EE5c", "Ghi ch\u00FA", "S\u1ED1 ti\u1EC1n", "Ng\u00E0y giao d\u1ECBch", "Lo\u1EA1i"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		JScrollPane scrollPaneListTran = new JScrollPane(table);
		table.setRowHeight(30); // tăng chiều cao của các hàng thành 30 pixel
		table.setFont(new Font("Tahoma", Font.PLAIN, 16)); // tăng kích thước của chữ trong bảng thành 16 pixel
		table.addMouseListener(ac);
		GroupLayout gl_panel_table = new GroupLayout(panel_table);
		gl_panel_table.setHorizontalGroup(
			gl_panel_table.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneListTran, GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
		);
		gl_panel_table.setVerticalGroup(
			gl_panel_table.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneListTran, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
		);
		panel_table.setLayout(gl_panel_table);
		
		JButton jBtton_search = new JButton();
		jBtton_search.setName("tìm kiếm");
		jBtton_search.setBackground(new Color(240,240,240));
		jBtton_search.setBorder(BorderFactory.createLineBorder(new Color(240,240,240)));
		jBtton_search.addActionListener(ac);

		
		jBtton_search.setIcon(new ImageIcon(FormSearch.class.getResource("/Icon/search32.png")));
		
		
		txtFSearch = new JTextField();	
		txtFSearch.setFont(new Font("sansserif", 0, 22));
		txtFSearch.setColumns(10);
		
		GroupLayout gl_panel_Search = new GroupLayout(panel_Search);
		gl_panel_Search.setHorizontalGroup(
			gl_panel_Search.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Search.createSequentialGroup()
					.addGap(104)
					.addComponent(txtFSearch, GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jBtton_search, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(67))
		);
		gl_panel_Search.setVerticalGroup(
			gl_panel_Search.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Search.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Search.createParallelGroup(Alignment.LEADING)
						.addComponent(jBtton_search, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addGroup(gl_panel_Search.createSequentialGroup()
							.addComponent(txtFSearch, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
							.addGap(1)))
					.addContainerGap())
		);
		panel_Search.setLayout(gl_panel_Search);
		panelCenter.setLayout(gl_panelCenter);
		this.setVisible(true);
	}
	
	private void insertData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        table.setModel(model);
        try {
			//bước 1: tạo kết nối
			Connection con = JDBCUtil.getConnection();
			//bước 2: tạo đối tượng statement
			String sql = "SELECT * FROM transaction WHERE danhMuc = ? AND username = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, txtFSearch.getText());
			pst.setString(2, user.getUsername());
			
			//Bước 3: tạo câu lệnh
			
		
			ResultSet rs = pst.executeQuery();
			//bước 4 xử lí kết quả
			while(rs.next()) {
				model.addRow(new Object[]{rs.getString("ID"),rs.getString("danhMuc"),rs.getString("ghiChu"),rs.getString("soTien"),rs.getString("ngayGiaoDich"),rs.getString("loai")});
			}
			
			//bước 5 ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	public String layGiaTri() {
		int row =  table.getSelectedRow();
		System.out.println(table.getValueAt(row, 5));
		return table.getValueAt(row, 5).toString();
	}
	
	public User getUser() {
		return user;
	}
	public void  getNameUser() {
		System.out.println(user.getUsername());
	}
	
	public void reloadTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		table.setModel(model);
		insertData(table);
	}
	
	public Transaction getTran() {
		int row =  table.getSelectedRow();
		String token[] = table.getValueAt(row, 4).toString().split("-");
		String date = dateTime(Integer.parseInt(token[2]),Integer.parseInt(token[1]),Integer.parseInt(token[0]));
		int soTien = Integer.parseInt(table.getValueAt(row,3).toString());
		Transaction transaction = new Transaction(dateTimeSQL(date),table.getValueAt(row, 2).toString(),soTien, table.getValueAt(row, 1).toString(), table.getValueAt(row, 0).toString());	
		return transaction;
	}
	
	private Date dateTimeSQL(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        Date date = java.sql.Date.valueOf(localDate);
        return date;
	}
	
	private String dateTime (int day, int month, int year) {
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
	
	public String nameForm() {
		return "searchForm";
	}
}
