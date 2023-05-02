package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.FormBaoCaoTheoThang;
import View.FormBudget;
import View.FormListBudget;
import View.FormListTrans;
import View.FormSetting;
import View.MainPage_Chi;

public class ListBudgetController implements ActionListener, WindowListener {

	private FormListBudget listBud;
	
	public ListBudgetController(FormListBudget listBud) {
		this.listBud = listBud;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		JButton btn = (JButton) e.getSource();
		
		if(src.equals("Sửa ngân sách")) {
			int giaTri =  listBud.layGiaTri();
			if(giaTri == 1)
				listBud.formCapNhat();
		}else if(src.equals("Nhập vào")) {
			listBud.setVisible(false);
			new MainPage_Chi(listBud.getUser());
		}else if(src.equals("Danh sách")) {
			listBud.setVisible(false);
			new FormListTrans(listBud.getUser());
		}else if(src.equals("Khác")) {
			listBud.setVisible(false);
			new FormSetting(listBud.getUser());
		}else if(src.equals("Báo cáo")){
			listBud.setVisible(false);
			try {
				new FormBaoCaoTheoThang(listBud.getUser());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(src.equals("Cập nhật")) {
			listBud.updateBudget();
			listBud.reloadTable();
		}else if(src.equals("Xóa")) {
			listBud.deleteBudget();
			listBud.reloadTable();
			listBud.formHT();
		}
		else if (btn.getName().equals("back")) {
			listBud.setVisible(false);
			new FormBudget(listBud.getUser());
		}
		
		listBud.getNameUser();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int con = JOptionPane.showConfirmDialog(null,  "Bạn chắc chắn muốn thoát chương trình?", "Xác nhân thoát", JOptionPane.YES_NO_OPTION);
		if(con == JOptionPane.YES_OPTION) {
			listBud.setVisible(false);		
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
