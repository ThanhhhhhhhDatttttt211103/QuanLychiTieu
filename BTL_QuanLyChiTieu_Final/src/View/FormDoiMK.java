package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;
import Controller.DoiMatKhauController;
import javax.swing.JButton;
import javax.swing.BorderFactory;

public class FormDoiMK extends JFrame {
	private User user;
	private JPasswordField txtPass;
	private JPasswordField txtNewPass;
	private JPasswordField txtReNewPass;
	private JLabel txtError1;
	private JLabel txtError3;
	private JLabel txtError2;

	public FormDoiMK(User user) {
		this.user = user;
		init();
	}
	
	public void init() {
		this.setTitle("Đổi mật khẩu");
		this.setSize(500, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		DoiMatKhauController ac = new DoiMatKhauController(this);
		
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.setBackground(Color.WHITE);
		
		JPanel content_TD = new JPanel();
		content_TD.setLayout(new FlowLayout(FlowLayout.CENTER));
		content_TD.setBackground(Color.WHITE);
		
		JLabel txtDoiMK = new JLabel("Đổi Mật Khẩu");
		txtDoiMK.setFont(new Font("sansserif", 1, 30));
		txtDoiMK.setForeground(new Color(7, 164, 121));
		content_TD.add(txtDoiMK);
		
		
		
		content.add(content_TD, BorderLayout.NORTH);
		
		
		getContentPane().add(content);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		content.add(panel, BorderLayout.CENTER);
		
		JLabel txtMKCu = new JLabel("Nhập lại mật khẩu :");
		txtMKCu.setForeground(new Color(0, 0, 0));
		txtMKCu.setFont(new Font("SansSerif", Font.PLAIN, 20));
		
		JLabel lblNhpMtKhu = new JLabel("Nhập mật khẩu mới :");
		lblNhpMtKhu.setForeground(new Color(0, 0, 0));
		lblNhpMtKhu.setFont(new Font("SansSerif", Font.PLAIN, 20));
		
		JLabel txtMKCu_2 = new JLabel("Nhập lại mật khẩu :");
		txtMKCu_2.setForeground(new Color(0, 0, 0));
		txtMKCu_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		
		txtPass = new JPasswordField();
		txtPass.setPreferredSize(new Dimension(200, 40));
		txtPass.setMinimumSize(new Dimension(200, 40));
		txtPass.setFont(new Font("SansSerif", Font.BOLD, 15));
		txtPass.setColumns(25);
		txtPass.addMouseListener(ac);
		
		txtNewPass = new JPasswordField();
		txtNewPass.setPreferredSize(new Dimension(200, 40));
		txtNewPass.setMinimumSize(new Dimension(200, 40));
		txtNewPass.setFont(new Font("SansSerif", Font.BOLD, 15));
		txtNewPass.setColumns(25);
		txtNewPass.addMouseListener(ac);
		
		txtReNewPass = new JPasswordField();
		txtReNewPass.setPreferredSize(new Dimension(200, 40));
		txtReNewPass.setMinimumSize(new Dimension(200, 40));
		txtReNewPass.setFont(new Font("SansSerif", Font.BOLD, 15));
		txtReNewPass.setColumns(25);
		txtReNewPass.addMouseListener(ac);
		
		
		JButton jButton_DoiMK = new JButton("Đổi mật khẩu");
		jButton_DoiMK.setPreferredSize(new Dimension(175, 40));
		jButton_DoiMK.setMinimumSize(new Dimension(50, 30));
		jButton_DoiMK.setForeground(new Color(7, 164, 121));
		jButton_DoiMK.setFont(new Font("SansSerif", Font.BOLD, 22));
		jButton_DoiMK.setBorder(BorderFactory.createLineBorder(new Color(218, 235, 231), 2));
		jButton_DoiMK.setBackground(new Color(218, 235, 231));
		jButton_DoiMK.addActionListener(ac);
		
		txtError1 = new JLabel();
		txtError1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtError1.setForeground(new Color(255, 11, 17));
		
		txtError3 = new JLabel();
		txtError3.setForeground(new Color(255, 11, 17));
		txtError3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtError2 = new JLabel();
		txtError2.setForeground(new Color(255, 11, 17));
		txtError2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtError3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtError2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(181)
							.addComponent(jButton_DoiMK, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtNewPass, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNhpMtKhu, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtError1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMKCu)
						.addComponent(txtReNewPass, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMKCu_2, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addComponent(txtMKCu, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtError1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNhpMtKhu, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNewPass, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(txtError2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtMKCu_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtReNewPass, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtError3)
					.addGap(45)
					.addComponent(jButton_DoiMK, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(65, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new FormDoiMK(new User("thanhdat1", "12345678"));
	}
	
	public Object changePass(){
		try {
			String error = (String) user.changePass(user.getUsername(),txtPass.getText(), txtNewPass.getText(),txtReNewPass.getText());
			System.out.println(error);
			return error;
		}catch(ClassCastException e) {
			return true;
		}	
	}
	
	public void errorDoiMK(String error) {
		if(error.equals("Mật khẩu không trùng khớp")) {
			txtReNewPass.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			txtReNewPass.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			txtError3.setText("* " + error);
			txtError3.setForeground(Color.red);
		}
		else if(error.equals("Mật khẩu không được để trống")) {
			txtNewPass.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			txtError2.setText("* " + error);
			txtError2.setForeground(Color.red);
			
		}else if(error.equals("Độ dài mật khẩu lớn hơn 8")) {
			txtNewPass.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			txtError2.setText("* " + error);
			txtError2.setForeground(Color.red);
		}else if(error.equals("Nhập sai mật khẩu")) {
			txtPass.setBorder(BorderFactory.createLineBorder(Color.red, 1));
			txtError1.setText("* " + error);
			txtError1.setForeground(Color.red);
		}	
	}
	
	public void click() {
		txtPass.setBorder(BorderFactory.createLineBorder(Color.black));
		txtNewPass.setBorder(BorderFactory.createLineBorder(Color.black));
		txtReNewPass.setBorder(BorderFactory.createLineBorder(Color.black));
		txtError1.setText(null);
		txtError2.setText(null);
		txtError3.setText(null);
	}
}
