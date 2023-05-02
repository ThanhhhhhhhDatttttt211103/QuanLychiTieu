package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import View.FormDangKy;
import View.FormDangNhap;

public class DangKyController implements ActionListener, MouseListener{

	private FormDangKy dangKy;
	
	public DangKyController( FormDangKy dangKy) {
		this.dangKy = dangKy;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Đăng nhập thôi!")) {
			this.dangKy.setVisible(false);
			new FormDangNhap();
		}else if(src.equals("Đăng ký")) {
			try {
				String error = (String) dangKy.sighUp();
					dangKy.errorDangky(error);
			
			}catch(ClassCastException e1) {
				JOptionPane.showMessageDialog(dangKy,"Đăng ký thành công");
			}
			
			}
		}
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) { // click
		dangKy.click();
		
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		
		
}
