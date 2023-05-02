package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controller.BaoCaoTheoNamController;
import Model.User;
import MyThread.Thread2_BaoCaoNam;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


public class FormBaoCaoTheoNam extends JFrame {

	private JPanel contentPane;
	private int year1;
	private int year2;
	private Calendar calendar;
	private JLabel txtDate; 
	private User user = new User();
	private Map<String, Integer> baoCaoNamChiTieu;
	private Map<String, Integer> baoCaoNamThuNhap;
	private JPanel bieuDo;
	private JPanel panel_BieuDo;
	private int loai;
	private JButton jButton_ThuNhap;
	private JButton jButton_ChiTieu;

	
	
	public FormBaoCaoTheoNam(User user) throws InterruptedException{
		this.loai = 0;
		this.user = user;
		this.init();
	}

	
	public void init() throws InterruptedException{
		this.setSize(1020, 600);
		this.setTitle("Quản Lý Chi Tiêu");
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(255,255,255));
		
		Color color_BackChon = new Color(7, 164, 121);
		Color color_ForeChon = new Color(255,255,255);
		Color color_BackKhong = new Color(218, 235, 231);
		Color color_ForeKhong = new Color(7, 164, 121);
		
		BaoCaoTheoNamController ac = new BaoCaoTheoNamController(this);
		this.addWindowListener(ac);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
		
		Dimension size = new Dimension(200, 40);
		Dimension sizeMini= new Dimension(50, 30);
		Dimension size_BtnFooter = new Dimension(175, 40);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		contentPane.setLayout(new BorderLayout());
		
		//header 
		JPanel header = new JPanel();
		header.setBackground(new Color(242,246,245));
	
		JButton jButton_nam = new JButton("Hàng Năm");
		jButton_nam.setBackground(color_BackChon);
		jButton_nam.setForeground(color_ForeChon);
		jButton_nam.setName("Hàng năm");
		jButton_nam.setFont(new Font("sansserif", 1, 22));
		jButton_nam.setPreferredSize(size);
		jButton_nam.setMinimumSize(size);
		
		JButton jButton_thang = new JButton("Hàng Tháng");
		jButton_thang.setBackground(color_BackKhong);
		jButton_thang.setForeground(color_ForeKhong);
		jButton_thang.setName("Hàng tháng");
		jButton_thang.setFont(new Font("sansserif", 1, 22));
		jButton_thang.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		jButton_thang.setPreferredSize(size);
		jButton_thang.setMinimumSize(size);
		jButton_thang.addActionListener(ac);
		
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
							.addComponent(jButton_thang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(14)
							.addComponent(jButton_nam, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
						.addComponent(cover2, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE))
					.addGap(296))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addComponent(cover1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addComponent(jButton_thang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jButton_nam, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(4)
					.addComponent(cover2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		header.setLayout(gl_header);
		
		
		
		JPanel tieuDe = new JPanel();
		tieuDe.setBackground(Color.WHITE);
		contentPane.add(tieuDe, BorderLayout.WEST);
		
		JPanel panel_date = new JPanel();
		panel_date.setBackground(Color.WHITE);
		panel_date.setBorder(BorderFactory.createCompoundBorder(
				new MatteBorder(0, 0, 2, 0, Color.orange),
				new EmptyBorder(0, 0, 0, 0)			
				));
		
		
		jButton_ThuNhap = new JButton("Thu Nhập");
		jButton_ThuNhap.setPreferredSize(new Dimension(200, 40));
		jButton_ThuNhap.setName("Thu Nhập");
		jButton_ThuNhap.setMinimumSize(new Dimension(200, 40));
		jButton_ThuNhap.setForeground(color_ForeKhong);
		jButton_ThuNhap.setBackground(color_BackKhong);
		jButton_ThuNhap.setFont(new Font("SansSerif", Font.BOLD, 22));
		jButton_ThuNhap.addActionListener(ac);
		jButton_ThuNhap.setBorder(BorderFactory.createLineBorder(color_BackKhong, 2));
		
		
		jButton_ChiTieu = new JButton("Chi Tiêu");
		jButton_ChiTieu.setPreferredSize(new Dimension(200, 40));
		jButton_ChiTieu.setName("Chi Tiêu");
		jButton_ChiTieu.setMinimumSize(new Dimension(200, 40));
		jButton_ChiTieu.setForeground(color_ForeChon);
		jButton_ChiTieu.setBackground(color_BackChon);
		jButton_ChiTieu.setFont(new Font("SansSerif", Font.BOLD, 22));
		jButton_ChiTieu.addActionListener(ac);
		
		
		GroupLayout gl_tieuDe = new GroupLayout(tieuDe);
		gl_tieuDe.setHorizontalGroup(
			gl_tieuDe.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_tieuDe.createSequentialGroup()
					.addContainerGap(52, Short.MAX_VALUE)
					.addGroup(gl_tieuDe.createParallelGroup(Alignment.TRAILING)
						.addComponent(jButton_ThuNhap, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton_ChiTieu, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
					.addGap(59))
				.addGroup(Alignment.LEADING, gl_tieuDe.createSequentialGroup()
					.addGap(20)
					.addComponent(panel_date, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
		);
		gl_tieuDe.setVerticalGroup(
			gl_tieuDe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tieuDe.createSequentialGroup()
					.addGap(24)
					.addComponent(panel_date, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(73)
					.addComponent(jButton_ChiTieu, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(jButton_ThuNhap, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		
		JButton jButton_down = new JButton();
		jButton_down.setIcon(new ImageIcon(FormBaoCaoTheoNam.class.getResource("/Icon/be24.png")));
		jButton_down.setName("down");
		jButton_down.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		jButton_down.setBackground(Color.WHITE);
		jButton_down.addActionListener(ac);
		
		calendar = Calendar.getInstance();
		year1 = calendar.get(Calendar.YEAR) - 4;
		year2 = calendar.get(Calendar.YEAR);
		
		txtDate = new JLabel(year1 + " - " + year2);
		txtDate.setFont(new Font("SansSerif", Font.BOLD, 27));
		txtDate.setBackground(Color.WHITE);
		
		JButton jButton_up = new JButton();
		jButton_up.setIcon(new ImageIcon(FormBaoCaoTheoNam.class.getResource("/Icon/lon24.png")));
		jButton_up.setName("up");
		jButton_up.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		jButton_up.setBackground(Color.WHITE);
		jButton_up.addActionListener(ac);
		
		
		GroupLayout gl_panel_date = new GroupLayout(panel_date);
		gl_panel_date.setHorizontalGroup(
			gl_panel_date.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_date.createSequentialGroup()
					.addComponent(jButton_down, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jButton_up, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_date.setVerticalGroup(
			gl_panel_date.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_date.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_date.createParallelGroup(Alignment.TRAILING)
						.addComponent(jButton_up, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton_down, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		
		panel_date.setLayout(gl_panel_date);
		tieuDe.setLayout(gl_tieuDe);
		panel_BieuDo = new JPanel();
		panel_BieuDo.setLayout(new BorderLayout());
		
		Thread2_BaoCaoNam t2 = new Thread2_BaoCaoNam(user, txtDate.getText());
		t2.start();
		t2.join();
		baoCaoNamChiTieu = t2.baoCaoNamChiTieu;
		baoCaoNamThuNhap = t2.baoCaoNamThuNhap;
		
		for(String danhMuc : baoCaoNamThuNhap.keySet()) {
			System.out.println(danhMuc +" " +  baoCaoNamThuNhap.get(danhMuc));
		}
		
		for(String danhMuc : baoCaoNamChiTieu.keySet()) {
			System.out.println(danhMuc +" " +  baoCaoNamChiTieu.get(danhMuc));
		}
		
		
		bieuDo = veBieuDo(baoCaoNamChiTieu,"Chi tiêu", "Chi tiêu hàng năm");
		panel_BieuDo.add(bieuDo, BorderLayout.CENTER);
		
		contentPane.add(panel_BieuDo, BorderLayout.CENTER);
		
		
		
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
	
	
	
	public JPanel veBieuDo(Map<String, Integer> list, String title, String name) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		int i = 0;
		List<String> nam = new ArrayList<String>();
		
		XYSeries series = new XYSeries(title);
		for(String key : list.keySet())	{
			series.add(i++, list.get(key));
			nam.add(key);
		}
		dataset.addSeries(series);

		String chartTitle = name;
		String xAxisLabel = "Năm";
		String yAxisLabel = "Số tiền (triệu đồng)";

		SymbolAxis xAxis = new SymbolAxis(xAxisLabel, new String[]{nam.get(0), nam.get(1), nam.get(2), nam.get(3), nam.get(4)});
		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, null, yAxisLabel, dataset);
		chart.getXYPlot().setDomainAxis(xAxis);

		JPanel chartPanel = new ChartPanel(chart);		
		return chartPanel;
	}
	
		
	public void inBaoCao() {
		for(String danhMuc : baoCaoNamThuNhap.keySet()) {
			System.out.println(danhMuc +" " +  baoCaoNamThuNhap.get(danhMuc));
		}
	}
	
	public void tang1Lan() {
		tinhNgay();
		calendar.add(Calendar.YEAR, +5);
		int year1 = calendar.get(Calendar.YEAR);
		int year2 = calendar.get(Calendar.YEAR) + 4;
		setYear(year1, year2);
	}
	
	private void setYear(int year1, int year2) {
		this.txtDate.setText(year1 + " - " + year2);
	}
	
	public void giam1Lan() {
		tinhNgay();
		calendar.add(Calendar.YEAR, -5);
		int year1 = calendar.get(Calendar.YEAR);
		int year2 = calendar.get(Calendar.YEAR) + 4;
		setYear(year1, year2);
	}
	
	private void tinhNgay() {
	    String[] tokens = txtDate.getText().split(" - ");
	    int year1 = Integer.parseInt(tokens[0]);
	    calendar.setTime(new Date(year1-1900, 1, 1)); // Thiết lập ngày tháng năm cho Calendar
	}
		

	public User getUser() {
		return user;
	}
	
	
	public void reloadChiTietBaoCao() throws InterruptedException {
		Thread2_BaoCaoNam t2 = new Thread2_BaoCaoNam(user, txtDate.getText());
		t2.start();
		t2.join();
		baoCaoNamChiTieu = t2.baoCaoNamChiTieu;
		baoCaoNamThuNhap = t2.baoCaoNamThuNhap;

		if(loai == 0) {
			bieuDo = veBieuDo(baoCaoNamChiTieu, "Chi tiêu", "Chi tiêu hàng năm");
			panel_BieuDo.add(bieuDo, BorderLayout.CENTER);	
		}else if(loai == 1) {
			bieuDo = veBieuDo(baoCaoNamThuNhap, "Thu nhập", "Thu nhập hàng năm");
			panel_BieuDo.add(bieuDo, BorderLayout.CENTER);	
		}
	}
		
	
	
	public void baoCaoThuNhap() {	
		loai = 1;
		jButton_ThuNhap.setBackground(new Color(7, 164, 121));
		jButton_ThuNhap.setForeground(new Color(255,255,255));
		jButton_ThuNhap.setBorder(BorderFactory.createLineBorder(new Color(7, 164, 121), 2));
		
		jButton_ChiTieu.setBackground(new Color(218, 235, 231));
		jButton_ChiTieu.setForeground(new Color(7, 164, 121));
		jButton_ChiTieu.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		System.out.println(loai);
		
		panel_BieuDo.removeAll();
		panel_BieuDo.revalidate(); // 	thực hiện lại layout của panel_ChiTiet
		panel_BieuDo.repaint();
		
		
		bieuDo = veBieuDo(baoCaoNamThuNhap, "Thu nhập", "Thu nhập hàng năm");
		panel_BieuDo.add(bieuDo, BorderLayout.CENTER);		
	}

	
	
	public void baoCaoChiTieu() {		
		loai = 0;
		jButton_ThuNhap.setBackground(new Color(218, 235, 231));
		jButton_ThuNhap.setForeground(new Color(7, 164, 121));
		jButton_ThuNhap.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231) , 2));
		
		jButton_ChiTieu.setBackground(new Color(7, 164, 121));
		jButton_ChiTieu.setForeground(new Color(255,255,255) );
		jButton_ChiTieu.setBorder(BorderFactory.createLineBorder(new Color(7, 164, 121), 2));
		
		panel_BieuDo.removeAll();
		panel_BieuDo.revalidate(); // 	thực hiện lại layout của panel_ChiTiet
		panel_BieuDo.repaint();
		
		bieuDo = veBieuDo(baoCaoNamChiTieu, "Chi tiêu", "Chi tiêu hàng năm");
		panel_BieuDo.add(bieuDo, BorderLayout.CENTER);		
	}
	
}
