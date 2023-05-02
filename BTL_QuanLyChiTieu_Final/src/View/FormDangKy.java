package View;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Controller.DangKyController;
import Model.User;
import MyThread.Thread3_DanhMucMacDinh;
import ViewCover.JPanelCover;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class FormDangKy extends JFrame {
	private JPanel contentPane;
	private JPanelCover cover;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JPasswordField txtRePass;
	private User user;
	private JLabel txtError1;
	private JLabel txtError2;
	private JLabel txtError3;

	
	
	public FormDangKy() {
		this.user = new User();
		init();
		formCover();
	}
	
	private void formCover() {
		DangKyController ac = new DangKyController(this);
		Dimension size = new Dimension(200, 40);
			
		
		JLabel label = new JLabel("Đăng ký tài khoản");
		label.setFont(new Font("sansserif", 1, 30));
		label.setForeground(new Color(7, 164, 121));
		JPanel jPanelDangKy = new JPanel();
		jPanelDangKy.setBackground(new Color(255,255,255));
		
		
		JLabel jLabel_user = new JLabel("Tài khoản");
		jLabel_user.setFont(new Font("sansserif", 1, 15));
		jLabel_user.setIcon(new ImageIcon(FormDangKy.class.getResource("/Icon/userIcon.png")));
		
		txtUser = new JTextField("");
		txtUser.setColumns(25);
		txtUser.setPreferredSize(size);
		txtUser.setMinimumSize(size);
		txtUser.setFont(new Font("sansserif", 1, 15));
		txtUser.addMouseListener(ac);
		
		JLabel jLabel_Pass = new JLabel("Mật khẩu");
		jLabel_Pass.setIcon(new ImageIcon(FormDangKy.class.getResource("/Icon/passIcon.png")));
		jLabel_Pass.setFont(new Font("sansserif", 1, 15));
		txtPass = new JPasswordField("");
		txtPass.setColumns(25);
		txtPass.setPreferredSize(size);
		txtPass.setMinimumSize(size);
		txtPass.setFont(new Font("sansserif", 1, 15));
		txtPass.addMouseListener(ac);
		
		
		JLabel jLabel_RePass = new JLabel("Nhập lại mật khẩu");
		jLabel_RePass.setFont(new Font("sansserif", 1, 15));
		txtRePass = new JPasswordField("");
		txtRePass.setColumns(25);
		txtRePass.setPreferredSize(size);
		txtRePass.setMinimumSize(size);
		txtRePass.setFont(new Font("sansserif", 1, 15));
		txtRePass.addMouseListener(ac);
		txtRePass.addMouseListener(ac);
		
		txtError1 = new JLabel();
		txtError2 = new JLabel();
		txtError3 = new JLabel();
		
		
		
		JButton jButton = new JButton("Đăng ký");
		jButton.setFont(new Font("sansserif", 1, 15));
		jButton.setPreferredSize(size);
		jButton.setMinimumSize(size);
		jButton.setBorder(null);
		jButton.setBackground(new Color(7, 164, 121));
		jButton.setForeground(new Color(255,255,255));
		jButton.addActionListener(ac);
		cover = new JPanelCover();
		
		JLabel jLabel_Back = new JLabel("Chào mừng bạn!");
		jLabel_Back.setFont(new Font("sansserif", 1, 30));
		jLabel_Back.setForeground(new Color(255,255,255));
		
		JButton jButton_Back = new JButton("Đăng nhập thôi!");
		jButton_Back.setFont(new Font("sansserif", 1, 15));
		jButton_Back.setPreferredSize(size);
		jButton_Back.setMinimumSize(size);
		jButton_Back.setBackground(new Color(35, 117, 85));
		jButton_Back.setForeground(new Color(255,255,255));
		
		jButton_Back.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		jButton_Back.addActionListener(ac);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(cover, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addComponent(jPanelDangKy, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(165)
							.addComponent(label))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(cover, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(63)
					.addComponent(label)
					.addGap(37)
					.addComponent(jPanelDangKy, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_jPanelDangKy = new GroupLayout(jPanelDangKy);
		gl_jPanelDangKy.setHorizontalGroup(
			gl_jPanelDangKy.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelDangKy.createSequentialGroup()
					.addGroup(gl_jPanelDangKy.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanelDangKy.createSequentialGroup()
							.addGap(7)
							.addComponent(jLabel_user))
						.addGroup(gl_jPanelDangKy.createSequentialGroup()
							.addGap(7)
							.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPanelDangKy.createSequentialGroup()
							.addGap(7)
							.addComponent(txtError1))
						.addGroup(gl_jPanelDangKy.createSequentialGroup()
							.addGap(7)
							.addComponent(jLabel_Pass))
						.addGroup(gl_jPanelDangKy.createSequentialGroup()
							.addGap(7)
							.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPanelDangKy.createSequentialGroup()
							.addGap(7)
							.addComponent(txtError2))
						.addGroup(gl_jPanelDangKy.createSequentialGroup()
							.addGap(7)
							.addComponent(jLabel_RePass))
						.addGroup(gl_jPanelDangKy.createSequentialGroup()
							.addGap(7)
							.addComponent(txtRePass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_jPanelDangKy.createSequentialGroup()
							.addGap(7)
							.addComponent(txtError3))
						.addGroup(gl_jPanelDangKy.createSequentialGroup()
							.addGap(84)
							.addComponent(jButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_jPanelDangKy.setVerticalGroup(
			gl_jPanelDangKy.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelDangKy.createSequentialGroup()
					.addGap(7)
					.addComponent(jLabel_user)
					.addGap(4)
					.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(txtError1)
					.addGap(4)
					.addComponent(jLabel_Pass)
					.addGap(4)
					.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(txtError2)
					.addGap(4)
					.addComponent(jLabel_RePass)
					.addGap(4)
					.addComponent(txtRePass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(txtError3)
					.addGap(18)
					.addComponent(jButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		jPanelDangKy.setLayout(gl_jPanelDangKy);
		GroupLayout gl_cover = new GroupLayout(cover);
		gl_cover.setHorizontalGroup(
			gl_cover.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cover.createSequentialGroup()
					.addContainerGap(91, Short.MAX_VALUE)
					.addGroup(gl_cover.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_cover.createSequentialGroup()
							.addComponent(jLabel_Back)
							.addGap(69))
						.addGroup(Alignment.TRAILING, gl_cover.createSequentialGroup()
							.addComponent(jButton_Back, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(94))))
		);
		gl_cover.setVerticalGroup(
			gl_cover.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cover.createSequentialGroup()
					.addGap(162)
					.addComponent(jLabel_Back)
					.addGap(76)
					.addComponent(jButton_Back, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(246))
		);
		cover.setLayout(gl_cover);
		contentPane.setLayout(gl_contentPane);
		
		
	}
	
	private void init() {
		this.setTitle("Quản lý chi tiêu");
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(100, 100, 1020, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		this.setVisible(true);
	}
	
	public Object sighUp(){
		try {
			String error = (String) user.sighUp(txtUser.getText(), txtPass.getText(),txtRePass.getText());
			System.out.println(error);
			return error;
		}catch(ClassCastException e) {
			Thread3_DanhMucMacDinh t3 = new Thread3_DanhMucMacDinh(txtUser.getText());
			t3.start();
			return true;
		}	
	}
	
	public void errorDangky(String error) {
		if(error.equals("Tài khoản đã có người sử dụng")) {
			txtUser.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			txtError1.setText("* " + error);
			txtError1.setForeground(Color.red);
		}
			
		else if(error.equals("Mật khẩu không trùng khớp")) {
			txtPass.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			txtRePass.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			txtError3.setText("* " + error);
			txtError3.setForeground(Color.red);
		}
		else if(error.equals("Mật khẩu không được để trống")) {
			txtPass.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			txtError2.setText("* " + error);
			txtError2.setForeground(Color.red);
			
		}else if(error.equals("Độ dài mật khẩu lớn hơn 8")) {
			txtPass.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			txtError2.setText("* " + error);
			txtError2.setForeground(Color.red);
		}else if(error.equals("Hãy nhập tài khoản")) {
			txtUser.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			txtError1.setText("* " + error);
			txtError1.setForeground(Color.red);
		}
		
		
	}
	public void resetDangKy() {
		txtUser.setBorder(BorderFactory.createLineBorder(Color.black));
		txtPass.setBorder(BorderFactory.createLineBorder(Color.black));
		txtRePass.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void click() {
		txtUser.setBorder(BorderFactory.createLineBorder(Color.black));
		txtPass.setBorder(BorderFactory.createLineBorder(Color.black));
		txtRePass.setBorder(BorderFactory.createLineBorder(Color.black));
		txtError1.setText(null);
		txtError2.setText(null);
		txtError3.setText(null);
	}
	
}
