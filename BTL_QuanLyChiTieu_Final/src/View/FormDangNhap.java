package View;

import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Controller.DangNhapController;
import Model.User;
import ViewCover.JPanelCover;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class FormDangNhap extends JFrame {
	private JPanel contentPane;
	private JPanelCover cover;
	private User user;
	private JTextField txtUser;
	private JPasswordField txtPass;
	
	
	public FormDangNhap() {
		this.user = new User();
		init();
		formCover();
	}
	
	private void formCover() {
		cover = new JPanelCover();
		Dimension size = new Dimension(200, 40);
		ActionListener ac = new DangNhapController(this);
		
		
		JLabel label = new JLabel("Đăng Nhập");
		label.setFont(new Font("sansserif", 1, 45));
		label.setForeground(new Color(7, 164, 121));
		
		JPanel jPanelDangNhap = new JPanel();
		jPanelDangNhap.setBackground(new Color(255,255,255));
		
		JLabel jLabel_user = new JLabel("Tên đăng nhập");
		jLabel_user.setFont(new Font("sansserif", 1, 15));
		jLabel_user.setIcon(new ImageIcon(FormDangKy.class.getResource("/Icon/userIcon.png")));
		
		txtUser = new JTextField();
		txtUser.setColumns(25);
		txtUser.setPreferredSize(size);
		txtUser.setMinimumSize(size);
		txtUser.setFont(new Font("sansserif", 1, 15));

		
		
		JLabel jLabel_Pass = new JLabel("Mật khẩu");
		jLabel_Pass.setIcon(new ImageIcon(FormDangKy.class.getResource("/Icon/passIcon.png")));
		jLabel_Pass.setFont(new Font("sansserif", 1, 15));
		txtPass = new JPasswordField();
		txtPass.setColumns(25);
		txtPass.setPreferredSize(size);
		txtPass.setMinimumSize(size);
		txtPass.setFont(new Font("sansserif", 1, 15));
		
		JLabel textForget = new JLabel("Bạn quên mật khẩu à ?");
		textForget.setFont(new Font("sansserif", 1, 12));
		
		JButton jButton = new JButton("Đăng Nhập");
		jButton.setFont(new Font("sansserif", 1, 15));
		jButton.setPreferredSize(size);
		jButton.setMinimumSize(size);
		jButton.setBorder(null);
		jButton.setBackground(new Color(7, 164, 121));
		jButton.setForeground(new Color(255,255,255));
		jButton.addActionListener(ac);
		GroupLayout gl_jPanelDangNhap = new GroupLayout(jPanelDangNhap);
		gl_jPanelDangNhap.setHorizontalGroup(
			gl_jPanelDangNhap.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelDangNhap.createSequentialGroup()
					.addGap(7)
					.addComponent(jLabel_user, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(224))
				.addGroup(gl_jPanelDangNhap.createSequentialGroup()
					.addGap(7)
					.addComponent(txtUser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_jPanelDangNhap.createSequentialGroup()
					.addGap(7)
					.addComponent(jLabel_Pass, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(268))
				.addGroup(gl_jPanelDangNhap.createSequentialGroup()
					.addGap(7)
					.addComponent(txtPass, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_jPanelDangNhap.createSequentialGroup()
					.addGap(121)
					.addComponent(textForget, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(114))
				.addGroup(gl_jPanelDangNhap.createSequentialGroup()
					.addGap(85)
					.addComponent(jButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(78))
		);
		gl_jPanelDangNhap.setVerticalGroup(
			gl_jPanelDangNhap.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelDangNhap.createSequentialGroup()
					.addGap(7)
					.addComponent(jLabel_user, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(4)
					.addComponent(txtUser, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addGap(4)
					.addComponent(jLabel_Pass)
					.addGap(4)
					.addComponent(txtPass, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addGap(4)
					.addComponent(textForget)
					.addGap(8)
					.addComponent(jButton, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
		);
		jPanelDangNhap.setLayout(gl_jPanelDangNhap);
		
		
		JPanel jpanel = new JPanel();
		jpanel.setBackground(new Color(255,255,255));
		
		
		
		JButton jButton_SignUp = new JButton("Đăng Ký Nào");
		jButton_SignUp.setFont(new Font("sansserif", 1, 15));
		jButton_SignUp.setPreferredSize(size);
		jButton_SignUp.setMinimumSize(size);
		jButton_SignUp.setBorder(null);
		jButton_SignUp.setBackground(new Color(38, 122, 83));
		jButton_SignUp.setForeground(new Color(255,255,255));
		jButton_SignUp.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		jButton_SignUp.addActionListener(ac);
		
		JLabel label_Hello = new JLabel("Xin Chào Bạn!");
		label_Hello.setFont(new Font("sansserif", 1, 30));
		label_Hello.setForeground(new Color(255, 255, 255));
		GroupLayout gl_cover = new GroupLayout(cover);
		gl_cover.setHorizontalGroup(
			gl_cover.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_cover.createSequentialGroup()
					.addContainerGap(101, Short.MAX_VALUE)
					.addGroup(gl_cover.createParallelGroup(Alignment.TRAILING)
						.addComponent(jButton_SignUp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_Hello))
					.addGap(95))
		);
		gl_cover.setVerticalGroup(
			gl_cover.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_cover.createSequentialGroup()
					.addContainerGap(161, Short.MAX_VALUE)
					.addComponent(label_Hello)
					.addGap(99)
					.addComponent(jButton_SignUp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(224))
		);
		cover.setLayout(gl_cover);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(109)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(64))
						.addComponent(jPanelDangNhap, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(112)
					.addComponent(jpanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(cover, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(108)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(38)
					.addComponent(jPanelDangNhap, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
					.addGap(152))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(519)
					.addComponent(jpanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addComponent(cover, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}	
	private void init() {
		this.setTitle("Quản lý chi tiêu");
		this.setBackground(new Color(255, 255, 255));
		this.setSize(1020,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		this.setVisible(true);
	}
	
	
	public boolean login(){
		if(this.user.login(txtUser.getText(), txtPass.getText())) {
			user = new User(txtUser.getText(),txtPass.getText());
			return true;
		}	
		else
			return false;
	}
	
	
	public void errorDangNhap() {
		txtUser.setBorder(BorderFactory.createLineBorder(Color.red, 1));
		txtPass.setBorder(BorderFactory.createLineBorder(Color.red, 1));
	}
	public void resetDangNhap() {
		txtUser.setBorder(BorderFactory.createLineBorder(Color.black));
		txtPass.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public User getUser() {
		return user;
	}
}
