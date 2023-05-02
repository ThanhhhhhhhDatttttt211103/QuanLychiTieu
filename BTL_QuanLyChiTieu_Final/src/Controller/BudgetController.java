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
import View.FormListCate;
import View.FormListTrans;
import View.FormSetting;
import View.MainPage_Chi;

public class BudgetController implements ActionListener, WindowListener {
	private FormBudget budget;	
	
	public BudgetController(FormBudget budget ) {
		this.budget = budget;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JButton btn = (JButton) e.getSource();
		if(src.equals("Thêm ngân sách")) {
			budget.addBudget();
		}else if(src.equals("Nhập vào")) {
			budget.setVisible(false);
			new MainPage_Chi(budget.getUser());
		}else if(src.equals("Khác")) {
			budget.setVisible(false);
			new FormSetting(budget.getUser());	
		}else if(src.equals("Ngân sách hiện có")) {
			budget.setVisible(false);
			new FormListBudget(budget.getUser());	
		}else if(src.equals("Danh sách")) {
			budget.setVisible(false);
			new FormListTrans(budget.getUser());	
		}else if(src.equals("Báo cáo")) {
			budget.setVisible(false);
			try {
				new FormBaoCaoTheoThang(budget.getUser());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
		}else if(src.equals("Chỉnh sửa >")) {
			budget.setVisible(false);
			new FormListCate(budget.getUser(), budget.formName());	
		}
		else {
			budget.setBorderClick(btn);
			System.out.println(src);
		}
		
		budget.getNameUser();
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int con = JOptionPane.showConfirmDialog(null,  "Bạn chắc chắn muốn thoát chương trình?", "Xác nhân thoát", JOptionPane.YES_NO_OPTION);
		if(con == JOptionPane.YES_OPTION) {
			budget.setVisible(false);		
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
