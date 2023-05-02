package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Notification;
import View.FormBaoCaoTheoThang;
import View.FormBudget;
import View.FormListCate;
import View.FormListTrans;
import View.FormSetting;
import View.MainPage_Chi;
import View.MainPage_Thu;

public class MainPage_ChiController implements ActionListener, WindowListener{
		private MainPage_Chi chi;
		
		public MainPage_ChiController( MainPage_Chi chi) {
			this.chi = chi;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String src = e.getActionCommand();
			JButton button = (JButton) e.getSource();
			
			if(src.equals("Nhập khoản chi")) {
				chi.addTrans();
				new Notification(chi.getUser(), chi.nameBtn());
			}
			else if(src.equals("Tiền thu")) {
				chi.setVisible(false);
				new MainPage_Thu(chi.getUser());
				}
			else if(button.getName().equals("up")){
				chi.tangMotNgay();
			} 
			else if(button.getName().equals("down")){
				chi.giamMotNgay();
			}else if(src.equals("Khác")) {
				chi.setVisible(false);
				new FormSetting(chi.getUser());
			}else if(src.equals("Ngân sách")) {
				chi.setVisible(false);
				new FormBudget(chi.getUser());
			}else if(src.equals("Danh sách")) {
				chi.setVisible(false);
				new FormListTrans(chi.getUser());
			}else if(src.equals("Báo cáo")) {
				chi.setVisible(false);
				try {
					new FormBaoCaoTheoThang(chi.getUser());
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(src.equals("Chỉnh sửa >")) {
				chi.setVisible(false);
				new FormListCate(chi.getUser(), chi.getNameForm());
			}
			else {
				chi.setBorderClick(button);
				System.out.println(src + "\n---------------");
				chi.nameBtn();
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
				chi.setVisible(false);		
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
