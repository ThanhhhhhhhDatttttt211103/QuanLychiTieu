package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.FormBaoCaoTheoThang;
import View.FormBudget;
import View.FormListTrans;
import View.FormSearch;
import View.FormSetting;
import View.FormSuaChi;
import View.FormSuaThu;
import View.MainPage_Chi;

public class ListTranController implements ActionListener,MouseListener, WindowListener{
	private FormListTrans formListTrans;
	
	public ListTranController(FormListTrans formListTrans) {
		this.formListTrans = formListTrans;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		JButton btn = (JButton) e.getSource();
		
		if(btn.getName().equals("up")) {
			formListTrans.tangMotThang();
			formListTrans.reloadTable();
		}else if(btn.getName().equals("down")) {
			formListTrans.giamMotThang();
			formListTrans.reloadTable();
		}else if(btn.getName().equals("tìm kiếm")){
			formListTrans.setVisible(false);
			new FormSearch(formListTrans.getUser());
		}
		else if(src.equals("Nhập vào")) {
			formListTrans.setVisible(false);
			new MainPage_Chi(formListTrans.getUser());
		}else if(src.equals("Khác")) {
			formListTrans.setVisible(false);
			new FormSetting(formListTrans.getUser());
		}else if(src.equals("Ngân sách")) {
			formListTrans.setVisible(false);
			new FormBudget(formListTrans.getUser());
		}else if(src.equals("Báo cáo")) {
			formListTrans.setVisible(false);
			try {
				new FormBaoCaoTheoThang(formListTrans.getUser());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		formListTrans.getNameUser();
	}


	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		 int loai = Integer.parseInt(formListTrans.layGiatri());
		 if (e.getClickCount() == 2) {
	            System.out.println("Double-clicked!");
	            this.formListTrans.setVisible(false);
	            if(loai == 1)
	            	new FormSuaThu(formListTrans.getUser(),formListTrans.getTran(), formListTrans.nameForm());
	            else if(loai == 0)
	            	new FormSuaChi(formListTrans.getUser(), formListTrans.getTran(), formListTrans.nameForm());            
	        }
		
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


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		int con = JOptionPane.showConfirmDialog(null,  "Bạn chắc chắn muốn thoát chương trình?", "Xác nhân thoát", JOptionPane.YES_NO_OPTION);
		if(con == JOptionPane.YES_OPTION) {
			formListTrans.setVisible(false);		
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
