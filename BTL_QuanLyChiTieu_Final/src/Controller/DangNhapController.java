package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;
import View.FormDangKy;
import View.FormDangNhap;
import View.MainPage_Chi;

public class DangNhapController implements ActionListener{
	private FormDangNhap dangNhap;
	
	public DangNhapController(FormDangNhap formDangNhap) {
		this.dangNhap = formDangNhap;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Đăng Ký Nào")) {
			this.dangNhap.setVisible(false);
			new FormDangKy();		
		} else	
			if(src.equals("Đăng Nhập") && dangNhap.login() ) {
				this.dangNhap.setVisible(false);
				new MainPage_Chi(dangNhap.getUser()); 
			}else {
				dangNhap.errorDangNhap();
				JOptionPane.showMessageDialog(dangNhap,"Tài khoản hoặc mật khẩu không hợp lệ");
				dangNhap.resetDangNhap();
			}
	}
}
