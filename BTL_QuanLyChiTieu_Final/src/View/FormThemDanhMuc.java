package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import Model.Category;
import Model.Transaction;

import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Controller.ThemDanhMucController;
import Model.User;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;


public class FormThemDanhMuc extends JFrame {

	private JPanel contentPane;
	private User user = new User();
	private JTextField feildName;
	private Map<JButton, Integer> listDanhMuc;
	private Category cate;
	private String iconBtn;
	private JComboBox<String> comboDanhMuc;
	private String formBack;
	private Transaction transaction;
	private String nameBack;
	
	public FormThemDanhMuc(User user, String formBack) {
		this.user = user;
		this.cate = new Category();
		this.formBack = formBack;
		this.init();
	}
	
	public FormThemDanhMuc(User user, String formBack, Transaction transaction) {
		this.user = user;
		this.cate = new Category();
		this.formBack = formBack;
		this.transaction = transaction;
		this.init();
	}
	
	public FormThemDanhMuc(User user, String formBack, Transaction transaction, String nameBack) {
		this.user = user;
		this.cate = new Category();
		this.formBack = formBack;
		this.transaction = transaction;
		this.nameBack = nameBack;
		this.init();
	}

	
	public void init() {
		this.setSize(1020, 600);
		this.setTitle("Quản Lý Chi Tiêu");
		this.setLocationRelativeTo(null);
		this.setBackground(new Color(255,255,255));

		
		ThemDanhMucController ac = new ThemDanhMucController(this);
		this.addWindowListener(ac);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE );
		
		Dimension sizeMini= new Dimension(50, 30);
		Dimension size_DanhMuc = new Dimension(150, 80);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,255,255));
		contentPane.setLayout(new BorderLayout());
		
		//header
		JPanel header = new JPanel();
		header.setBackground(new Color(242,246,245));
		contentPane.add(header, BorderLayout.NORTH);
		
		JLabel txtTaoMoi = new JLabel("Tạo mới");
		txtTaoMoi.setFont(new Font("SansSerif", Font.PLAIN, 30));
		
		JButton jButton_back = new JButton();
		jButton_back.setIcon(new ImageIcon(FormThemDanhMuc.class.getResource("/Icon/back32.png")));
		jButton_back.setName("back");
		jButton_back.setBorder(BorderFactory.createLineBorder(new Color(242,246,245), 2));
		jButton_back.setBackground(new Color(242, 246, 245));
		jButton_back.addActionListener(ac);
		
		GroupLayout gl_header = new GroupLayout(header);
		gl_header.setHorizontalGroup(
			gl_header.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_header.createSequentialGroup()
					.addGap(44)
					.addComponent(jButton_back, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 345, Short.MAX_VALUE)
					.addComponent(txtTaoMoi, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(437))
		);
		gl_header.setVerticalGroup(
			gl_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_header.createSequentialGroup()
					.addGroup(gl_header.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_header.createSequentialGroup()
							.addGap(24)
							.addComponent(txtTaoMoi))
						.addGroup(gl_header.createSequentialGroup()
							.addContainerGap()
							.addComponent(jButton_back, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		header.setLayout(gl_header);

		this.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton jButton_Luu = new JButton("Lưu");
		jButton_Luu.setName("Luu");
		jButton_Luu.setPreferredSize(new Dimension(200, 40));
		jButton_Luu.setMinimumSize(new Dimension(50, 30));
		jButton_Luu.setForeground(Color.WHITE);
		jButton_Luu.setFont(new Font("SansSerif", Font.BOLD, 22));
		jButton_Luu.setBackground(new Color(7, 164, 121));
		jButton_Luu.addActionListener(ac);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(401)
					.addComponent(jButton_Luu, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
					.addGap(387))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(jButton_Luu, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addGap(32))
		);
		panel.setLayout(gl_panel);
		
		JPanel panelListCate = new JPanel();
		panelListCate.setBackground(new Color(255, 255, 255));
		contentPane.add(panelListCate, BorderLayout.CENTER);
		
		JLabel txtTen = new JLabel("Tên :");
		txtTen.setFont(new Font("SansSerif", Font.PLAIN, 30));
		
		feildName = new JTextField();
		feildName.setColumns(10);
		feildName.setFont(new Font("SansSerif", 0, 20 ));
		
		JLabel txtBieuTuong = new JLabel("Biểu tượng :");
		txtBieuTuong.setFont(new Font("SansSerif", Font.PLAIN, 30));
		
		comboDanhMuc = new JComboBox<>();
		comboDanhMuc.setBackground(new Color(255, 255, 255));
		comboDanhMuc.setFont(new Font("SansSerif", Font.PLAIN, 25));
		comboDanhMuc.addItem("Chi Tiêu");
		comboDanhMuc.addItem("Thu Nhập");
		
		JLabel lblLoi = new JLabel("loại :");
		lblLoi.setFont(new Font("SansSerif", Font.PLAIN, 30));
		
		//JPanel panel_1 = new JPanel();
		listDanhMuc = new LinkedHashMap<>();
		
		JButton jButton_AnUong = new JButton();
		jButton_AnUong.setName("cutlery.png");
		jButton_AnUong.setBackground(Color.white);
		jButton_AnUong.setPreferredSize(size_DanhMuc);
		jButton_AnUong.setMinimumSize(sizeMini);
		jButton_AnUong.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/cutlery.png")));
		jButton_AnUong.addActionListener(ac);
		listDanhMuc.put(jButton_AnUong, 0);
		
		JButton jButton_QuanAo = new JButton();
		jButton_QuanAo.setName("tshirt.png");
		jButton_QuanAo.setBackground(Color.white);
		jButton_QuanAo.setPreferredSize(size_DanhMuc);
		jButton_QuanAo.setMinimumSize(sizeMini);
		jButton_QuanAo.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/tshirt.png")));
		jButton_QuanAo.addActionListener(ac);
		listDanhMuc.put(jButton_QuanAo, 0);

		JButton jButton_GiaoLuu = new JButton();
		jButton_GiaoLuu.setName("partyIcon.png");
		jButton_GiaoLuu.setBackground(Color.white);
		jButton_GiaoLuu.setPreferredSize(size_DanhMuc);
		jButton_GiaoLuu.setMinimumSize(sizeMini);
		jButton_GiaoLuu.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/partyIcon.png")));
		jButton_GiaoLuu.addActionListener(ac);
		listDanhMuc.put(jButton_GiaoLuu, 0);
		
		JButton jButton_GiaoDuc = new JButton();
		jButton_GiaoDuc.setName("book.png");
		jButton_GiaoDuc.setBackground(Color.white);
		jButton_GiaoDuc.setPreferredSize(size_DanhMuc);
		jButton_GiaoDuc.setMinimumSize(sizeMini);
		jButton_GiaoDuc.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/book.png")));
		jButton_GiaoDuc.addActionListener(ac);
		listDanhMuc.put(jButton_GiaoDuc, 0);
		
		JButton jButton_YTe = new JButton();
		jButton_YTe.setName("syringe.png");
		jButton_YTe.setBackground(Color.white);
		jButton_YTe.setPreferredSize(size_DanhMuc);
		jButton_YTe.setMinimumSize(sizeMini);
		jButton_YTe.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/syringe.png")));
		jButton_YTe.addActionListener(ac);
		listDanhMuc.put(jButton_YTe, 0);
		
		JButton jButton_LienLac = new JButton();
		jButton_LienLac.setName("phone.png");
		jButton_LienLac.setBackground(Color.white);
		jButton_LienLac.setPreferredSize(size_DanhMuc);
		jButton_LienLac.setMinimumSize(sizeMini);
		jButton_LienLac.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/phone.png")));
		jButton_LienLac.addActionListener(ac);
		listDanhMuc.put(jButton_LienLac, 0);
		
		JButton jButton_Nha = new JButton();
		jButton_Nha.setName("home.png");
		jButton_Nha.setBackground(Color.white);
		jButton_Nha.setPreferredSize(size_DanhMuc);
		jButton_Nha.setMinimumSize(sizeMini);
		jButton_Nha.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/home.png")));
		jButton_Nha.addActionListener(ac);
		listDanhMuc.put(jButton_Nha, 0);
		
		JButton jButton_DienNuoc = new JButton();
		jButton_DienNuoc.setName("electric.png");
		jButton_DienNuoc.setBackground(Color.white);
		jButton_DienNuoc.setPreferredSize(size_DanhMuc);
		jButton_DienNuoc.setMinimumSize(sizeMini);
		jButton_DienNuoc.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/electric.png")));
		jButton_DienNuoc.addActionListener(ac);
		listDanhMuc.put(jButton_DienNuoc, 0);
		
		JButton jButton_Bia = new JButton();
		jButton_Bia.setName("beer.png");
		jButton_Bia.setBackground(Color.white);
		jButton_Bia.setPreferredSize(size_DanhMuc);
		jButton_Bia.setMinimumSize(sizeMini);
		jButton_Bia.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/beer.png")));
		jButton_Bia.addActionListener(ac);
		listDanhMuc.put(jButton_Bia, 0);
		
		JButton jButton_Coin = new JButton();
		jButton_Coin.setName("dollar.png");
		jButton_Coin.setBackground(Color.white);
		jButton_Coin.setPreferredSize(size_DanhMuc);
		jButton_Coin.setMinimumSize(sizeMini);
		jButton_Coin.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/dollar.png")));
		jButton_Coin.addActionListener(ac);
		listDanhMuc.put(jButton_Coin, 0);
		
		JButton jButton_Moto = new JButton();
		jButton_Moto.setName("motorcycle.png");
		jButton_Moto.setBackground(Color.white);
		jButton_Moto.setPreferredSize(size_DanhMuc);
		jButton_Moto.setMinimumSize(sizeMini);
		jButton_Moto.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/motorcycle.png")));
		jButton_Moto.addActionListener(ac);
		listDanhMuc.put(jButton_Moto, 0);
		
		
		JButton jButton_Beach = new JButton();
		jButton_Beach.setName("vacations.png");
		jButton_Beach.setBackground(Color.white);
		jButton_Beach.setPreferredSize(size_DanhMuc);
		jButton_Beach.setMinimumSize(sizeMini);
		jButton_Beach.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/vacations.png")));
		jButton_Beach.addActionListener(ac);
		listDanhMuc.put(jButton_Beach, 0);
		
		JButton jButton_Camera = new JButton();
		jButton_Camera.setName("camera.png");
		jButton_Camera.setBackground(Color.white);
		jButton_Camera.setPreferredSize(size_DanhMuc);
		jButton_Camera.setMinimumSize(sizeMini);
		jButton_Camera.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/camera.png")));
		jButton_Camera.addActionListener(ac);
		listDanhMuc.put(jButton_Camera, 0);
		
		JButton jButton_Heart = new JButton();
		jButton_Heart.setName("heart.png");
		jButton_Heart.setBackground(Color.white);
		jButton_Heart.setPreferredSize(size_DanhMuc);
		jButton_Heart.setMinimumSize(sizeMini);
		jButton_Heart.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/heart.png")));
		jButton_Heart.addActionListener(ac);
		listDanhMuc.put(jButton_Heart, 0);
		
		JButton jButton_Game = new JButton();
		jButton_Game.setName("joystick.png");
		jButton_Game.setBackground(Color.white);
		jButton_Game.setPreferredSize(size_DanhMuc);
		jButton_Game.setMinimumSize(sizeMini);
		jButton_Game.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/joystick.png")));
		jButton_Game.addActionListener(ac);
		listDanhMuc.put(jButton_Game, 0);
		
		JButton jButton_Guitar = new JButton();
		jButton_Guitar.setName("guitar.png");
		jButton_Guitar.setBackground(Color.white);
		jButton_Guitar.setPreferredSize(size_DanhMuc);
		jButton_Guitar.setMinimumSize(sizeMini);
		jButton_Guitar.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/guitar.png")));
		jButton_Guitar.addActionListener(ac);
		listDanhMuc.put(jButton_Guitar, 0);
		
		JButton jButton_CauLong = new JButton();
		jButton_CauLong.setName("shuttlecock.png");
		jButton_CauLong.setBackground(Color.white);
		jButton_CauLong.setPreferredSize(size_DanhMuc);
		jButton_CauLong.setMinimumSize(sizeMini);
		jButton_CauLong.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/shuttlecock.png")));
		jButton_CauLong.addActionListener(ac);
		listDanhMuc.put(jButton_CauLong, 0);
		
		JButton jButton_BongDa = new JButton();
		jButton_BongDa.setName("football.png");
		jButton_BongDa.setBackground(Color.white);
		jButton_BongDa.setPreferredSize(size_DanhMuc);
		jButton_BongDa.setMinimumSize(sizeMini);
		jButton_BongDa.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/football.png")));
		jButton_BongDa.addActionListener(ac);
		listDanhMuc.put(jButton_BongDa, 0);
		
		JButton jButton_Cafe = new JButton();
		jButton_Cafe.setName("tea.png");
		jButton_Cafe.setBackground(Color.white);
		jButton_Cafe.setPreferredSize(size_DanhMuc);
		jButton_Cafe.setMinimumSize(sizeMini);
		jButton_Cafe.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/tea.png")));
		jButton_Cafe.addActionListener(ac);
		listDanhMuc.put(jButton_Cafe, 0);
		
		JButton jButton_Hambur = new JButton();	
		jButton_Hambur.setName("hamburger.png");
		jButton_Hambur.setBackground(Color.white);
		jButton_Hambur.setPreferredSize(size_DanhMuc);
		jButton_Hambur.setMinimumSize(sizeMini);
		jButton_Hambur.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/hamburger.png")));
		jButton_Hambur.addActionListener(ac);
		listDanhMuc.put(jButton_Hambur, 0);
		
		JButton jButton_Kem = new JButton();
		jButton_Kem.setName("ice-cream.png");
		jButton_Kem.setBackground(Color.white);
		jButton_Kem.setPreferredSize(size_DanhMuc);
		jButton_Kem.setMinimumSize(sizeMini);
		jButton_Kem.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/ice-cream.png")));
		jButton_Kem.addActionListener(ac);
		listDanhMuc.put(jButton_Kem, 0);
		
		JButton jButton_Tau = new JButton();
		jButton_Tau.setName("train.png");
		jButton_Tau.setBackground(Color.white);
		jButton_Tau.setPreferredSize(size_DanhMuc);
		jButton_Tau.setMinimumSize(sizeMini);
		jButton_Tau.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/train.png")));
		jButton_Tau.addActionListener(ac);
		listDanhMuc.put(jButton_Tau, 0);
		
		JButton jButton_BongRo = new JButton();
		jButton_BongRo.setName("basketball.png");
		jButton_BongRo.setBackground(Color.white);
		jButton_BongRo.setPreferredSize(size_DanhMuc);
		jButton_BongRo.setMinimumSize(sizeMini);
		jButton_BongRo.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/basketball.png")));
		jButton_BongRo.addActionListener(ac);
		listDanhMuc.put(jButton_BongRo, 0);
		
		JButton jButton_Truong = new JButton();
		jButton_Truong.setName("school.png");
		jButton_Truong.setBackground(Color.white);
		jButton_Truong.setPreferredSize(size_DanhMuc);
		jButton_Truong.setMinimumSize(sizeMini);
		jButton_Truong.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/school.png")));
		jButton_Truong.addActionListener(ac);
		listDanhMuc.put(jButton_Truong, 0);
		
		
		JButton jButton_Hoa = new JButton();
		jButton_Hoa.setName("flower-pot.png");
		jButton_Hoa.setBackground(Color.white);
		jButton_Hoa.setPreferredSize(size_DanhMuc);
		jButton_Hoa.setMinimumSize(sizeMini);
		jButton_Hoa.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/flower-pot.png")));
		jButton_Hoa.addActionListener(ac);
		listDanhMuc.put(jButton_Hoa, 0);
		
		JButton jButton_Luong = new JButton();
		jButton_Luong.setName("luong.png");
		jButton_Luong.setBackground(Color.white);
		jButton_Luong.setPreferredSize(size_DanhMuc);
		jButton_Luong.setMinimumSize(sizeMini);
		jButton_Luong.setIcon(new ImageIcon(MainPage_Thu.class.getResource("/Icon/luong.png")));
		jButton_Luong.addActionListener(ac);
		listDanhMuc.put(jButton_Luong, 0);
		
		JButton jButton_PhuCap = new JButton();
		jButton_PhuCap.setName("phucap.png");
		jButton_PhuCap.setBackground(Color.white);
		jButton_PhuCap.setPreferredSize(size_DanhMuc);
		jButton_PhuCap.setMinimumSize(sizeMini);
		jButton_PhuCap.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/phucap.png")));
		jButton_PhuCap.addActionListener(ac);
		listDanhMuc.put(jButton_PhuCap, 0);

		JButton jButton_DuLich = new JButton();
		jButton_DuLich.setName("travel.png");
		jButton_DuLich.setBackground(Color.white);
		jButton_DuLich.setPreferredSize(size_DanhMuc);
		jButton_DuLich.setMinimumSize(sizeMini);
		jButton_DuLich.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/travel.png")));
		jButton_DuLich.addActionListener(ac);
		listDanhMuc.put(jButton_DuLich, 0);
		
		JButton jButton_SoThu =  new JButton();
		jButton_SoThu.setName("zoo.png");
		jButton_SoThu.setBackground(Color.white);
		jButton_SoThu.setPreferredSize(size_DanhMuc);
		jButton_SoThu.setMinimumSize(sizeMini);
		jButton_SoThu.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/zoo.png")));
		jButton_SoThu.addActionListener(ac);
		listDanhMuc.put(jButton_SoThu, 0);
		
		JButton jButton_ChungKhoan = new JButton();
		jButton_ChungKhoan.setName("business.png");
		jButton_ChungKhoan.setBackground(Color.white);
		jButton_ChungKhoan.setPreferredSize(size_DanhMuc);
		jButton_ChungKhoan.setMinimumSize(sizeMini);
		jButton_ChungKhoan.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/business.png")));
		jButton_ChungKhoan.addActionListener(ac);
		listDanhMuc.put(jButton_ChungKhoan, 0);
		
		JButton jButton_EmBe = new JButton();
		jButton_EmBe.setName("baby.png");
		jButton_EmBe.setBackground(Color.white);
		jButton_EmBe.setPreferredSize(size_DanhMuc);
		jButton_EmBe.setMinimumSize(sizeMini);
		jButton_EmBe.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/baby.png")));
		jButton_EmBe.addActionListener(ac);
		listDanhMuc.put(jButton_EmBe, 0);

		JButton jButton_Thuong = new JButton();
		jButton_Thuong.setName("thuong.png");
		jButton_Thuong.setBackground(Color.white);
		jButton_Thuong.setPreferredSize(size_DanhMuc);
		jButton_Thuong.setMinimumSize(sizeMini);
		jButton_Thuong.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/thuong.png")));
		jButton_Thuong.addActionListener(ac);
		listDanhMuc.put(jButton_Thuong, 0);
		
		JButton jButton_TNPhu = new JButton();
		jButton_TNPhu.setName("phu.png");
		jButton_TNPhu.setBackground(Color.white);
		jButton_TNPhu.setPreferredSize(size_DanhMuc);
		jButton_TNPhu.setMinimumSize(sizeMini);
		jButton_TNPhu.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/phu.png")));
		jButton_TNPhu.addActionListener(ac);
		listDanhMuc.put(jButton_TNPhu, 0);
		
		JButton jButton_DauTu = new JButton();
		jButton_DauTu.setName("dautu.png");
		jButton_DauTu.setBackground(Color.white);
		jButton_DauTu.setPreferredSize(size_DanhMuc);
		jButton_DauTu.setMinimumSize(sizeMini);
		jButton_DauTu.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/dautu.png")));
		jButton_DauTu.addActionListener(ac);
		listDanhMuc.put(jButton_DauTu, 0);
		
		JButton jButton_TamThoi = new JButton();
		jButton_TamThoi.setName("tam.png");
		jButton_TamThoi.setBackground(Color.white);
		jButton_TamThoi.setPreferredSize(size_DanhMuc);
		jButton_TamThoi.setMinimumSize(sizeMini);
		jButton_TamThoi.setIcon(new ImageIcon(MainPage_Chi.class.getResource("/Icon/tam.png")));
		jButton_TamThoi.addActionListener(ac);
		listDanhMuc.put(jButton_TamThoi, 0);
		
		
		JPanel panel_CacDanhMuc = new JPanel();
		panel_CacDanhMuc.setLayout(new GridBagLayout());
		panel_CacDanhMuc.setBackground(Color.white);
		GridBagConstraints contaiDanhMuc = new GridBagConstraints();
		contaiDanhMuc.insets = new Insets(5, 5, 5, 5);
		int x =0, y = 1;
		
		for(JButton key : listDanhMuc.keySet()) {
			contaiDanhMuc.gridx = x++;
			contaiDanhMuc.gridy = y;
			panel_CacDanhMuc.add(key, contaiDanhMuc);
			if(x == 5) {
				x = 0;
				y++;
			}
		}
							
		JScrollPane crollDanhMuc = new JScrollPane(panel_CacDanhMuc);
		crollDanhMuc.setBorder(BorderFactory.createEmptyBorder());
		
		
		
		GroupLayout gl_panelListCate = new GroupLayout(panelListCate);
		gl_panelListCate.setHorizontalGroup(
			gl_panelListCate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelListCate.createSequentialGroup()
					.addGap(103)
					.addGroup(gl_panelListCate.createParallelGroup(Alignment.LEADING)
						.addComponent(txtBieuTuong)
						.addGroup(gl_panelListCate.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, gl_panelListCate.createSequentialGroup()
								.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(feildName, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
								.addComponent(lblLoi, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(comboDanhMuc, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
							.addComponent(crollDanhMuc, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 819, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		gl_panelListCate.setVerticalGroup(
			gl_panelListCate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelListCate.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panelListCate.createParallelGroup(Alignment.LEADING)
						.addComponent(txtTen)
						.addGroup(gl_panelListCate.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panelListCate.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLoi, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboDanhMuc, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
							.addComponent(feildName, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(txtBieuTuong, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(crollDanhMuc, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panelListCate.setLayout(gl_panelListCate);
		this.setVisible(true);
		
	}
	public void setBorderClick(JButton button) {
		if(listDanhMuc.get(button) == 0) {
			for(JButton btn : listDanhMuc.keySet()) {
				if(listDanhMuc.get(btn) == 1) {
					btn.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1));
					listDanhMuc.put(btn,listDanhMuc.get(btn)-1);
				}
			}
			button.setBorder(BorderFactory.createLineBorder(new Color(7, 164, 121), 3));
			listDanhMuc.put(button,listDanhMuc.get(button)+1);
			iconBtn = button.getName();
		}
	}
	
	public void addCate() {
		int loai;
		if(comboDanhMuc.getSelectedItem().equals("Chi Tiêu"))
			loai = 0;
		else
			loai = 1;
		cate.AddCaterogy(user.getUsername(),feildName.getText(), iconBtn ,loai);
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
