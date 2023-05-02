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
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controller.ListTranController;
import Model.Transaction;
import Model.User;
import ViewCover.CustomTable;
import database.JDBCUtil;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class FormListTrans extends JFrame {
	
	private Map<String,List<Transaction>> listTrans;  
	private JPanel contentPanel;
	private JTable tableListTran;
	private Calendar calendar;
	private int month;
	private int year;
	private JLabel txtDate;
	private User user = new User();
	private JLabel txtTienTong;
	private JLabel txtTienChiTieu;
	private JLabel txtTienThuNhap;
	
	
	public FormListTrans(User user) {
		this.listTrans = new HashMap<String,List<Transaction>>();
		this.user = user;
		init();
		insertData(tableListTran);
	}
	
	public void init() {
		this.setTitle("Quản lý chi tiêu");
		this.setSize(1020, 600);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
		this.setLocationRelativeTo(null);
		ListTranController ac = new ListTranController(this);
		this.addWindowListener(ac);
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBackground(Color.white);
		
		Color color_BackChon = new Color(7, 164, 121);
		Color color_ForeChon = new Color(255,255,255);
		Color color_BackKhong = new Color(218, 235, 231);
		Color color_ForeKhong = new Color(7, 164, 121);
		
		Dimension size = new Dimension(200, 40);
		Dimension size2= new Dimension(100, 40);
		Dimension size3= new Dimension(240, 60);
		Dimension sizeMini= new Dimension(50, 30);
		Dimension size_DanhMuc = new Dimension(150, 80);
		Dimension size_BtnFooter = new Dimension(175, 40);
		
		Dimension size_NSHienco = new Dimension(250,80);
		
		
		JPanel header = new JPanel();
		header.setBackground(new Color(242,246,245));
		
		
		
		contentPanel.add(header, BorderLayout.NORTH);
		
		JButton jButton_down = new JButton();
		jButton_down.setForeground(Color.WHITE);
		jButton_down.setName("down");
		jButton_down.setIcon(new ImageIcon(FormListTrans.class.getResource("/Icon/be24.png")));
		jButton_down.setBackground(new Color(242,246,245));
		jButton_down.setBorder(BorderFactory.createLineBorder(new Color(242,246,245), 2));
		jButton_down.addActionListener(ac);
		
		
		calendar = Calendar.getInstance();
		month = calendar.get(Calendar.MONTH) + 1;
		year = calendar.get(Calendar.YEAR);
		
		txtDate = new JLabel(month + " / " + year);
		txtDate.setBackground(Color.WHITE);
		txtDate.setFont(new Font("sansserif", 1, 30));
		
		JButton jButton_up = new JButton();
		jButton_up.setName("up");
		jButton_up.setIcon(new ImageIcon(FormListTrans.class.getResource("/Icon/lon24.png")));
		jButton_up.setBackground(new Color(242,246,245));
		jButton_up.setBorder(BorderFactory.createLineBorder(new Color(242,246,245),2));
		jButton_up.addActionListener(ac);
		
		JButton jButton_Timkiem = new JButton();
		jButton_Timkiem.setName("tìm kiếm");
		jButton_Timkiem.setIcon(new ImageIcon(FormListTrans.class.getResource("/Icon/search50.png")));
		jButton_Timkiem.setFont(new Font("sansserif", 1, 22));
		jButton_Timkiem.setMinimumSize(sizeMini);
		jButton_Timkiem.setBackground(new Color(242,246,245));
		jButton_Timkiem.setBorder(BorderFactory.createLineBorder(new Color(242,246,245), 2));
		jButton_Timkiem.setForeground(color_ForeChon);
		jButton_Timkiem.addActionListener(ac);
		

		
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_header.createSequentialGroup()
					.addGap(318)
					.addComponent(jButton_down, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(txtDate)
					.addGap(24)
					.addComponent(jButton_up, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
					.addGap(248)
					.addComponent(jButton_Timkiem, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_header.createSequentialGroup()
					.addComponent(jButton_Timkiem, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(Alignment.LEADING, gl_header.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_header.createParallelGroup(Alignment.TRAILING)
						.addComponent(jButton_down, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
						.addComponent(txtDate, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
						.addComponent(jButton_up, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
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
		jButton_Danhsach.setName("Danh sách");
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
		JPanel panelThuNhap = new JPanel();
		panelThuNhap.setBackground(Color.WHITE);
		panelThuNhap.setLayout(new GridLayout(2, 0, 0, 0));
		JLabel txtThuNhap = new JLabel("Thu nhập");
		txtThuNhap.setFont(new Font("sansserif", 0, 15));
		txtThuNhap.setHorizontalAlignment(JLabel.CENTER); // canh giữa theo chiều ngang
		txtThuNhap.setVerticalAlignment(JLabel.CENTER); // canh giữa theo chiều dọc
		panelThuNhap.add(txtThuNhap);
		txtTienThuNhap = new JLabel();
		txtTienThuNhap.setFont(new Font("sansserif", 1, 20));
		txtTienThuNhap.setForeground(Color.BLUE);
		txtTienThuNhap.setHorizontalAlignment(JLabel.CENTER);
		txtTienThuNhap.setVerticalAlignment(JLabel.CENTER);
		panelThuNhap.add(txtTienThuNhap);
		

		JPanel panelChitieu = new JPanel();
		panelChitieu.setBackground(Color.WHITE);
		panelChitieu.setLayout(new GridLayout(2, 0, 0, 0));		
		JLabel txtChiTieu = new JLabel("Chi tiêu");
		txtChiTieu.setFont(new Font("sansserif", 0, 15));
		txtChiTieu.setHorizontalAlignment(JLabel.CENTER); 
		txtChiTieu.setVerticalAlignment(JLabel.CENTER); 
		panelChitieu.add(txtChiTieu);		
		txtTienChiTieu = new JLabel();
		txtTienChiTieu.setFont(new Font("sansserif", 1, 20));
		txtTienChiTieu.setForeground(Color.ORANGE);
		txtTienChiTieu.setHorizontalAlignment(JLabel.CENTER);
		txtTienChiTieu.setVerticalAlignment(JLabel.CENTER);
		panelChitieu.add(txtTienChiTieu);
		
		
		JPanel panelTong = new JPanel();
		panelTong.setBackground(Color.WHITE);
		panelTong.setLayout(new GridLayout(2, 0, 0, 0));
		JLabel txtTong = new JLabel("Tổng");
		txtTong.setFont(new Font("sansserif", 0, 15));
		txtTong.setHorizontalAlignment(JLabel.CENTER);
		txtTong.setVerticalAlignment(JLabel.CENTER);
		panelTong.add(txtTong);
		txtTienTong = new JLabel();
		txtTienTong.setFont(new Font("sansserif", 1, 20));
		txtTienTong.setForeground(Color.RED);
		txtTienTong.setHorizontalAlignment(JLabel.CENTER);
		txtTienTong.setVerticalAlignment(JLabel.CENTER);
		panelTong.add(txtTienTong);
		
		JPanel panelList = new JPanel();
		panelList.setBackground(Color.WHITE);
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(64)
					.addComponent(panelThuNhap, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
					.addGap(149)
					.addComponent(panelChitieu, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
					.addGap(172)
					.addComponent(panelTong, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
					.addGap(72))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelList, GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelChitieu, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelTong, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelThuNhap, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelList, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableListTran = new JTable();
		tableListTran.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableListTran.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Danh mục", "Ghi chú", "Số Tiền", "Ngày giao dịch", "Loại"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableListTran.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableListTran.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableListTran.getColumnModel().getColumn(2).setPreferredWidth(120);
		tableListTran.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableListTran.getColumnModel().getColumn(4).setPreferredWidth(80);
		//tableListTran.getColumnModel().getColumn(2).setCellRenderer(new CustomTable());
		
		tableListTran.setDefaultRenderer(Object.class, new CustomTable());
		tableListTran.setBounds(0, 0, 948, 593);
		tableListTran.addMouseListener(ac);

	    JScrollPane scrollPane = new JScrollPane(tableListTran);
	    
	    tableListTran.setRowHeight(30); // tăng chiều cao của các hàng thành 30 pixel
	    tableListTran.setFont(new Font("Tahoma", Font.PLAIN, 16)); // tăng kích thước của chữ trong bảng thành 16 pixel
		
		
		
		GroupLayout gl_panelList = new GroupLayout(panelList);
		gl_panelList.setHorizontalGroup(
			gl_panelList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelList.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelList.setVerticalGroup(
			gl_panelList.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelList.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelList.setLayout(gl_panelList);
	
		
		
		panel.setLayout(gl_panel);
		this.setVisible(true);
		
	}
	
	
	private void insertData(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        table.setModel(model);
        int thuNhap = 0;
        int chiTieu = 0;
        int tong  = 0;
        try {
			//bước 1: tạo kết nối
			Connection con = JDBCUtil.getConnection();
			//bước 2: tạo đối tượng statement
			String[] tokens = txtDate.getText().split(" / ");
			String sql = "SELECT * FROM transaction WHERE username = ? AND MONTH(ngayGiaoDich) = ? AND  YEAR(ngayGiaoDich) = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2,tokens[0]);
			pst.setString(3, tokens[1]);
			
			//Bước 3: tạo câu lệnh
			
		
			ResultSet rs = pst.executeQuery();
			//bước 4 xử lí kết quả
			while(rs.next()) {
				model.addRow(new Object[]{rs.getString("ID"), rs.getString("danhMuc"),rs.getString("ghiChu"),rs.getString("soTien"),rs.getString("ngayGiaoDich"),rs.getString("loai")});
				if(rs.getString("loai").equals("1"))
					thuNhap+= Integer.parseInt(rs.getString("soTien"));
				else if(rs.getString("loai").equals("0")) {
					chiTieu += Integer.parseInt(rs.getString("soTien"));
				}
			}
			tong = thuNhap - chiTieu;
			txtTienChiTieu.setText(txtMoney(chiTieu));
			txtTienThuNhap.setText(txtMoney(thuNhap));
			txtTienTong.setText(txtMoney(tong));
			
			//bước 5 ngắt kết nối
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
		
	public void tangMotThang() {
		calendar.add(Calendar.MONTH, 1);
		int month2 = calendar.get(Calendar.MONTH) +1;
		int year2 = calendar.get(Calendar.YEAR);
		setMonth(month2, year2);
	}
	
	private void setMonth(int month, int year) {
		if(month < 10)
			this.txtDate.setText("0"+month + " / " + year);
		else
			this.txtDate.setText(month + " / " + year);
	}
	
	public void giamMotThang() {
		calendar.add(Calendar.MONTH, -1);
		int month2 = calendar.get(Calendar.MONTH) +1;
		int year2 = calendar.get(Calendar.YEAR);
		setMonth(month2, year2);
	}
	
	public String layGiatri() {
		int row =  tableListTran.getSelectedRow();
		System.out.println(tableListTran.getValueAt(row, 5));
		return tableListTran.getValueAt(row, 5).toString();
	}
	public Transaction getTran() {
		int row =  tableListTran.getSelectedRow();
		String token[] = tableListTran.getValueAt(row, 4).toString().split("-");
		String date = dateTime(Integer.parseInt(token[2]),Integer.parseInt(token[1]),Integer.parseInt(token[0]));
		int soTien = Integer.parseInt(tableListTran.getValueAt(row,3).toString());
		Transaction transaction = new Transaction(dateTimeSQL(date),tableListTran.getValueAt(row, 2).toString(),soTien, tableListTran.getValueAt(row, 1).toString(), tableListTran.getValueAt(row, 0).toString());	
		return transaction;
	}
	
	public User getUser() {
		return user;
	}
	public void  getNameUser() {
		System.out.println(user.getUsername());
	}
	
	public void reloadTable() {
		DefaultTableModel model = (DefaultTableModel) tableListTran.getModel();
		tableListTran.setModel(model);
		insertData(tableListTran);
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
		return "listForm";
	}
	
	private String txtMoney(int tien) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		String output = formatter.format(tien);
		return output;
	}
}
