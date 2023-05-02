package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import View.FormBaoCaoTheoThang;
import View.FormBudget;
import View.FormDangNhap;
import View.FormDoiMK;
import View.FormListTrans;
import View.FormSetting;
import View.MainPage_Chi;

public class SettingController implements ActionListener, WindowListener {
	private FormSetting setting;
	
	public SettingController(FormSetting setting) {
		this.setting = setting;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Cập nhật thông tin")) {
			System.out.println(src);
			setting.setThongTin();
		}
		else if(src.equals("Cập nhật")) {
			System.out.println(src);
			setting.UpdateInfor();
		}else if(src.equals("Đăng xuất")){
			System.out.println(src);
			setting.setVisible(false);
			new FormDangNhap();
		}else if(src.equals("Nhập vào")) {
			System.out.println(src);
			setting.setVisible(false);
			new MainPage_Chi(setting.getUser());
		}else if(src.equals("Ngân sách")) {
			System.out.println(src);
			setting.setVisible(false);
			new FormBudget(setting.getUser());
		}else if(src.equals("Danh sách")) {
			setting.setVisible(false);
			new FormListTrans(setting.getUser());
		}else if(src.equals("Báo cáo")) {
			setting.setVisible(false);
			try {
				new FormBaoCaoTheoThang(setting.getUser());
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}			
		}else if(src.equals("Đổi Mật Khẩu")) {
			new FormDoiMK(setting.getUser());
		}

		setting.getNameUser();
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int con = JOptionPane.showConfirmDialog(null,  "Bạn chắc chắn muốn thoát chương trình?", "Xác nhân thoát", JOptionPane.YES_NO_OPTION);
		if(con == JOptionPane.YES_OPTION) {
			setting.setVisible(false);		
		}
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
