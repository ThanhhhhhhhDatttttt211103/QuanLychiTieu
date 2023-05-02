package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.FormBaoCaoTheoThang;
import View.FormBudget;
import View.FormListCate;
import View.FormListTrans;
import View.FormSetting;
import View.MainPage_Chi;
import View.MainPage_Thu;

public class MainPage_ThuController implements ActionListener, WindowListener {
		private MainPage_Thu thu;
		
		
		public MainPage_ThuController( MainPage_Thu thu) {
			this.thu = thu;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String src = e.getActionCommand();
			JButton button =  (JButton) e.getSource();
			
			if(src.equals("Nhập khoản thu")){
				thu.addTrans();
				System.out.println(src);
			}else if(src.equals("Tiền chi")) {
				this.thu.setVisible(false);
				new MainPage_Chi(thu.getUser());
			}else if(button.getName().equals("up")){
					thu.tangMotNgay();
			}else if(button.getName().equals("down")){
				thu.giamMotNgay();			
			}else if(src.equals("Khác")) {
				thu.setVisible(false);
				new FormSetting(thu.getUser());
			}else if(src.equals("Ngân sách")) {
				thu.setVisible(false);
				new FormBudget(thu.getUser());
			}else if(src.equals("Báo cáo")) {
				thu.setVisible(false);
				try {
					new FormBaoCaoTheoThang(thu.getUser());
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(src.equals("Danh sách")) {
				thu.setVisible(false);
				new FormListTrans(thu.getUser());
			}else if(src.equals("Chỉnh sửa >")) {
				new FormListCate(thu.getUser(), thu.getNameForm());
			}
			else{
				thu.setBorderClick(button);
				System.out.println(src);
			}
			thu.getNameUser();	
	}
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowClosing(WindowEvent e) {
			int con = JOptionPane.showConfirmDialog(null,  "Bạn chắc chắn muốn thoát chương trình?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
			if(con == JOptionPane.YES_OPTION) {
				thu.setVisible(false);
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
