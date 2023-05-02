package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import View.FormDoiMK;

public class DoiMatKhauController implements ActionListener, MouseListener{
	
	private FormDoiMK matkhau;
	
	public DoiMatKhauController(FormDoiMK matkhau) {
		this.matkhau = matkhau;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
			if(src.equals("Đổi mật khẩu")) {
				try {
					String error = (String) matkhau.changePass();
						matkhau.errorDoiMK(error);
				}catch(ClassCastException e1) {
					JOptionPane.showMessageDialog(null,"Đổi mật khẩu thành công");
					matkhau.setVisible(false);
					}		
				}				
			}

	@Override
	public void mouseClicked(MouseEvent e) {
		matkhau.click();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
