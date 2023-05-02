package View;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controller.BaoCaoTheoThangController;
import Model.User;
import MyThread.Thread1_BaoCaoThang;
import database.JDBCUtil;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import javax.swing.JScrollPane;


public class FormBaoCaoTheoThang extends JFrame {

	private JPanel contentPane;
	private int year;
	private int month;
	private Calendar calendar;
	private JLabel txtDate; 
	private User user = new User();
	private Map<String, Integer> baoCaoThangChiTieu;
	private Map<String, Integer> baoCaoThangThuNhap;
	private JLabel txtTienChiTieu;
	private JLabel txtTienThuNhap;
	private JLabel txtTienTong;
	private GridBagConstraints contaiNhap;
	private JPanel panel_ChiTiet;
	private JPanel bieuDo;
	private JPanel panel_BieuDo;
	private int loai;
	private JButton jButton_ThuNhap;
	private JButton jButton_ChiTieu;
	private JPanel panel_TieuDe;
	
	
	public FormBaoCaoTheoThang(User user) throws InterruptedException{
		this.user = user;	
		this.init();
		inChiTietBaoCao(baoCaoThangChiTieu);
		docBaoCao();
		//inBaoCao();
		this.loai = 0;
	}

	
	public void init() throws InterruptedException {
		this.setSize(1020, 600);
		this.setTitle("Quản Lý Chi Tiêu");
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(255,255,255));
		
		Color color_BackChon = new Color(7, 164, 121);
		Color color_ForeChon = new Color(255,255,255);
		Color color_BackKhong = new Color(218, 235, 231);
		Color color_ForeKhong = new Color(7, 164, 121);
		
		BaoCaoTheoThangController ac = new BaoCaoTheoThangController(this);
		this.addWindowListener(ac);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
		
		Dimension size = new Dimension(200, 40);
		Dimension size2= new Dimension(150, 40);
		Dimension sizeMini= new Dimension(50, 30);
		Dimension size_BtnFooter = new Dimension(175, 40);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		contentPane.setLayout(new BorderLayout());
		
		//header 
		JPanel header = new JPanel();
		header.setBackground(new Color(242,246,245));
	
		JButton jButton_HangNam = new JButton("Hàng Năm");
		jButton_HangNam.setBackground(color_BackKhong);
		jButton_HangNam.setForeground(color_ForeKhong);
		jButton_HangNam.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		jButton_HangNam.setName("Hàng năm");
		jButton_HangNam.setFont(new Font("sansserif", 1, 22));
		jButton_HangNam.setPreferredSize(size);
		jButton_HangNam.setMinimumSize(size);
		jButton_HangNam.addActionListener(ac);
		
		JButton jButton_HangThang = new JButton("Hàng Tháng");
		jButton_HangThang.setBackground(color_BackChon);
		jButton_HangThang.setForeground(color_ForeChon);
		jButton_HangThang.setName("Hàng tháng");
		jButton_HangThang.setFont(new Font("sansserif", 1, 22));
		jButton_HangThang.setPreferredSize(size);
		jButton_HangThang.setMinimumSize(size);
		jButton_HangThang.addActionListener(ac);
		
		JPanel cover1 = new JPanel();
		cover1.setBackground(new Color(242,246,245));
		JPanel cover2 = new JPanel();
		cover2.setBackground(new Color(242,246,245));
		
		contentPane.add(header, BorderLayout.NORTH);
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(296)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(cover1, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_header.createSequentialGroup()
							.addComponent(jButton_HangThang, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
							.addGap(14)
							.addComponent(jButton_HangNam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(cover2, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
					.addGap(296))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addComponent(cover1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(jButton_HangThang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton_HangNam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(4)
					.addComponent(cover2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		header.setLayout(gl_header);
		
		//content
		//content ben phai
		
		jButton_ChiTieu= new JButton("Chi Tiêu");
		jButton_ChiTieu.setBackground(color_BackChon);
		jButton_ChiTieu.setForeground(color_ForeChon);
		jButton_ChiTieu.setName("Chi tiêu");
		jButton_ChiTieu.setFont(new Font("sansserif", 1, 22));
		jButton_ChiTieu.setPreferredSize(size2);
		jButton_ChiTieu.setMinimumSize(size2);
		jButton_ChiTieu.addActionListener(ac);
		
		
		jButton_ThuNhap = new JButton("Thu Nhập");
		jButton_ThuNhap.setBackground(color_BackKhong);
		jButton_ThuNhap.setForeground(color_ForeKhong);
		jButton_ThuNhap.setName("Thu nhập");
		jButton_ThuNhap.setFont(new Font("sansserif", 1, 22));
		jButton_ThuNhap.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		jButton_ThuNhap.setPreferredSize(size2);
		jButton_ThuNhap.setMinimumSize(size2);
		jButton_ThuNhap.addActionListener(ac);
		

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel txtChiTieu = new JLabel("Chi tiêu:");
		txtChiTieu.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		JLabel txtThuNhap = new JLabel("Thu nhập:  ");
		txtThuNhap.setFont(new Font("SansSerif", Font.PLAIN, 15));
		
		JLabel txtTong = new JLabel("Tổng:");
		txtTong.setFont(new Font("SansSerif", Font.PLAIN, 20));
		
		txtTienChiTieu = new JLabel();
		txtTienChiTieu.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtTienChiTieu.setForeground(Color.orange);
		
		txtTienThuNhap = new JLabel();
		txtTienThuNhap.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtTienThuNhap.setForeground(Color.blue);
		
		txtTienTong = new JLabel();
		txtTienTong.setFont(new Font("SansSerif", Font.PLAIN, 20));
		txtTienTong.setForeground(Color.red);
		
		JButton jButton_down = new JButton();
		jButton_down.setIcon(new ImageIcon(FormBaoCaoTheoThang.class.getResource("/Icon/be24.png")));
		jButton_down.setName("down");
		jButton_down.setForeground(Color.WHITE);
		jButton_down.setBorder(BorderFactory.createLineBorder(Color.white,2));
		jButton_down.setBackground(Color.white);
		jButton_down.addActionListener(ac);
		
		calendar = Calendar.getInstance();
		month = calendar.get(Calendar.MONTH) + 1;
		year = calendar.get(Calendar.YEAR);
		
		if(month < 10)
			txtDate = new JLabel( "0"+month + " / " + year);
		else
			txtDate = new JLabel( month + " / " + year);
		txtDate.setBackground(Color.WHITE);
		txtDate.setFont(new Font("sansserif", 1, 30));
		
		JButton jButton_up = new JButton();
		jButton_up.setIcon(new ImageIcon(FormBaoCaoTheoThang.class.getResource("/Icon/lon24.png")));
		jButton_up.setName("up");
		jButton_up.setBorder(BorderFactory.createLineBorder(Color.white,2));
		jButton_up.setBackground(Color.white);
		jButton_up.addActionListener(ac);
		
		
		panel_ChiTiet = new JPanel();
		panel_ChiTiet.setLayout(new GridBagLayout());
		contaiNhap = new GridBagConstraints();
		contaiNhap.insets = new Insets(10, 55, 10, 55);
		JScrollPane crollPanelChiTiet = new JScrollPane(panel_ChiTiet);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(82)
					.addComponent(jButton_down, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(jButton_up, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(93, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(crollPanelChiTiet, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtChiTieu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtTong))
							.addGap(18)
							.addComponent(txtTienChiTieu, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(15)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtThuNhap)
									.addGap(18)
									.addComponent(txtTienThuNhap, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtTienTong, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
									.addGap(77)))
							.addGap(25))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(jButton_down, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton_up, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtChiTieu, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtThuNhap, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTienThuNhap, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTienChiTieu, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTong, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTienTong, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(crollPanelChiTiet, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		panel.setLayout(gl_panel);
		
		//content ben trai
		panel_TieuDe = new JPanel();
		panel_TieuDe.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel_TieuDe.setBackground(Color.white);
		panel_TieuDe.add(jButton_ChiTieu);
		panel_TieuDe.add(jButton_ThuNhap);
		
		Thread1_BaoCaoThang t1 = new Thread1_BaoCaoThang(txtDate.getText(), user);
		t1.start();
		t1.join();
		baoCaoThangChiTieu = t1.baoCaoThangChiTieu;
		baoCaoThangThuNhap = t1.baoCaoThangThuNhap;
		
		panel_BieuDo = new JPanel();
		panel_BieuDo.setLayout(new BorderLayout());
		
		bieuDo = veBieuDo(baoCaoThangChiTieu, "Báo cáo chi tiêu");
		
		panel_BieuDo.add(panel_TieuDe, BorderLayout.NORTH);
		panel_BieuDo.add(bieuDo, BorderLayout.CENTER);
		
		contentPane.add(panel_BieuDo, BorderLayout.WEST);
		
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
		jButton_NganSach.setBackground(color_BackKhong);
		jButton_NganSach.setForeground(color_ForeKhong);
		jButton_NganSach.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		jButton_NganSach.addActionListener(ac);
		
		JButton jButton_Bao = new JButton("Báo cáo");
		jButton_Bao.setName("Báo cáo");
		jButton_Bao.setFont(new Font("sansserif", 1, 22));
		jButton_Bao.setPreferredSize(size_BtnFooter);
		jButton_Bao.setMinimumSize(sizeMini);
		jButton_Bao.setBackground(color_BackChon);
		jButton_Bao.setForeground(color_ForeChon);
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
							.addComponent(jButton_Nhap, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
							.addGap(9)
							.addComponent(jButton_Danhsach, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
							.addGap(9)
							.addComponent(jButton_NganSach, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
							.addGap(9)
							.addComponent(jButton_Bao, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
							.addGap(14)
							.addComponent(jButton_Khac, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(cover4, GroupLayout.PREFERRED_SIZE, 941, GroupLayout.PREFERRED_SIZE))
					.addGap(32))
		);
		gl_footer.setVerticalGroup(
			gl_footer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_footer.createSequentialGroup()
					.addComponent(cover3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_footer.createParallelGroup(Alignment.LEADING)
						.addComponent(jButton_Nhap, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton_Danhsach, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton_NganSach, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton_Bao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton_Khac, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(4)
					.addComponent(cover4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		footer.setLayout(gl_footer);

		this.setContentPane(contentPane);
		this.setVisible(true);	
	}
	
	
	public JPanel veBieuDo(Map<String, Integer> listBaoCao, String Name) {
		// Tạo dữ liệu cho biểu đồ tròn
			int tong = 0;
	      for(String key : listBaoCao.keySet()) {
	    	  tong+= listBaoCao.get(key);
	      }
		
	      DefaultPieDataset dataset = new DefaultPieDataset();
	      for(String key : listBaoCao.keySet()) {
	    	  dataset.setValue(key,  (double)listBaoCao.get(key)*100/tong);
	      }
	      
	      // Tạo biểu đồ tròn
	      JFreeChart chart = ChartFactory.createPieChart(
	         Name,  // Tiêu đề của biểu đồ
	         dataset,                        // Dữ liệu cho biểu đồ 
	         false,                           // In các giá trị trên biểu đồ
	         false,
	         false);
	      
	      // Cấu hình biểu đồ tròn
	      PiePlot plot = (PiePlot) chart.getPlot();
	      plot.setBackgroundPaint(Color.WHITE);
	      plot.setOutlinePaint(Color.WHITE);
	      
	      // Cấu hình phần hiển thị nhãn trên biểu đồ
	      plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
	      plot.setLabelLinkStroke(new BasicStroke(0f)); // duong vien label
	      plot.setLabelOutlineStroke(null); // dg vien 
	      plot.setLabelBackgroundPaint(null); // nen
	      plot.setLabelShadowPaint(null); // bong
	      plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: ({1}%)"));
	      
	      // Hiển thị biểu đồ tròn trong một cửa sổ JFrame
	      JPanel panel = new ChartPanel(chart);
	      panel.setPreferredSize(new Dimension(500, 300));
	      panel.setVisible(true);
	      return panel;
	}
	
	
	private void docBaoCao() {
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
			pst.setString(1, "thanhdat1");
			pst.setString(2,tokens[0]);
			pst.setString(3, tokens[1]);
			
			//Bước 3: tạo câu lệnh
			
		
			ResultSet rs = pst.executeQuery();
			//bước 4 xử lí kết quả
			
			while(rs.next()) {
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
			e.printStackTrace();
		}
	}
		
	public void inBaoCao() {
		for(String danhMuc : baoCaoThangChiTieu.keySet()) {
			System.out.println(danhMuc +" " +  baoCaoThangChiTieu.get(danhMuc));
		}
	}
	private String txtMoney(int tien) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		String output = formatter.format(tien);
		return output;
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
		
	private void inChiTietBaoCao(Map<String, Integer> list) {
		panel_ChiTiet.removeAll();
	    panel_ChiTiet.revalidate(); // 	thực hiện lại layout của panel_ChiTiet
	    panel_ChiTiet.repaint(); // vẽ lại panel_ChiTiet
		int y = 0;
		for(String key : list.keySet()) {
			int x = 0;
			JLabel txt1 = new JLabel();
			txt1.setFont(new Font("sansserif", 0, 20));
			txt1.setText( key);

			JLabel txt2 = new JLabel();
			txt2.setFont(new Font("sansserif", 0, 20));
			txt2.setText(txtMoney(list.get(key)));
			
			contaiNhap.gridx = x++;
			contaiNhap.gridy = y;
			panel_ChiTiet.add(txt1, contaiNhap);
			
			contaiNhap.gridx = x;
			contaiNhap.gridy = y++;
			panel_ChiTiet.add(txt2, contaiNhap);	
		}
	}
	
	public User getUser() {
		return user;
	}
	
	public void reloadChiTietBaoCao() throws InterruptedException {
		Thread1_BaoCaoThang t1 = new Thread1_BaoCaoThang(txtDate.getText(), user);
		t1.start();
		t1.join();
		baoCaoThangChiTieu = t1.baoCaoThangChiTieu;
		baoCaoThangThuNhap = t1.baoCaoThangThuNhap;
		docBaoCao();
		if(loai == 0) {
			inChiTietBaoCao(baoCaoThangChiTieu);
			bieuDo = veBieuDo(baoCaoThangChiTieu, "Báo cáo chi tiêu");
			panel_BieuDo.add(bieuDo, BorderLayout.CENTER);	
		}else if(loai == 1) {
			inChiTietBaoCao(baoCaoThangThuNhap);
			bieuDo = veBieuDo(baoCaoThangThuNhap, "Báo cáo thu nhập");
			panel_BieuDo.add(bieuDo, BorderLayout.CENTER);
		}
	}
	
	public void baoCaoThuNhap() {	
		inChiTietBaoCao(baoCaoThangThuNhap);
		bieuDo = veBieuDo(baoCaoThangThuNhap, "Báo cáo thu nhập");
		panel_BieuDo.removeAll();
		panel_BieuDo.revalidate(); // 	thực hiện lại layout của panel_ChiTiet
		panel_BieuDo.repaint(); // vẽ lại panel_ChiTiet
		

		loai =1;
		jButton_ThuNhap.setBackground(new Color(7, 164, 121));
		jButton_ThuNhap.setForeground(new Color(255,255,255));
		jButton_ThuNhap.setBorder(BorderFactory.createLineBorder(new Color(7, 164, 121), 2));
		
		jButton_ChiTieu.setBackground(new Color(218, 235, 231));
		jButton_ChiTieu.setForeground(new Color(7, 164, 121));
		jButton_ChiTieu.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		System.out.println(loai);
		
		panel_BieuDo.add(panel_TieuDe, BorderLayout.NORTH);
		panel_BieuDo.add(bieuDo, BorderLayout.CENTER);		
	}
	
	public void baoCaoChiTieu() {		
		inChiTietBaoCao(baoCaoThangChiTieu);
		bieuDo = veBieuDo(baoCaoThangChiTieu, "Báo cáo chi tiêu");
		panel_BieuDo.removeAll();
		panel_BieuDo.revalidate(); // 	thực hiện lại layout của panel_ChiTiet
		panel_BieuDo.repaint(); // vẽ lại panel_ChiTiet

		loai = 0;
		jButton_ThuNhap.setBackground(new Color(218, 235, 231));
		jButton_ThuNhap.setForeground(new Color(7, 164, 121));
		jButton_ThuNhap.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231) , 2));
		
		jButton_ChiTieu.setBackground(new Color(7, 164, 121));
		jButton_ChiTieu.setForeground(new Color(255,255,255) );
		jButton_ChiTieu.setBorder(BorderFactory.createLineBorder(new Color(7, 164, 121), 2));
		
		panel_BieuDo.add(panel_TieuDe, BorderLayout.NORTH);
		panel_BieuDo.add(bieuDo, BorderLayout.CENTER);	
	}
}
