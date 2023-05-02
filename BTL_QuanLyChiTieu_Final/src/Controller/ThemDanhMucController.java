package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.FormListCate;
import View.FormThemDanhMuc;

public class ThemDanhMucController implements ActionListener, WindowListener {
	private FormThemDanhMuc them;
	
	
	
	public ThemDanhMucController(FormThemDanhMuc them) {
		this.them = them;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JButton button =  (JButton) e.getSource();
		if(src.equals("Lưu")) {
			System.out.println(src);
			them.addCate();
		}else if(button.getName().equals("back")) {
			them.setVisible(false);
			if(them.nameBack() == null)
				new FormListCate(them.getUser(), them.formBack(), them.getTranBack());
			else
				new FormListCate(them.getUser(), them.formBack(), them.getTranBack(), them.nameBack());
		}
			
		else {
			them.setBorderClick(button);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int con = JOptionPane.showConfirmDialog(null,  "Bạn chắc chắn muốn thoát chương trình?", "Xác nhân thoát", JOptionPane.YES_NO_OPTION);
		if(con == JOptionPane.YES_OPTION) {
			them.setVisible(false);		
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
