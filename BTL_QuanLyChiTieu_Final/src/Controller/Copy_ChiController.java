package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import View.FormCopy_Chi;
import View.FormCopy_Thu;
import View.FormListCate;
import View.FormListTrans;

public class Copy_ChiController implements ActionListener, WindowListener{
		private FormCopy_Chi chi;
		
		public Copy_ChiController( FormCopy_Chi chi) {
			this.chi = chi;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			String src = e.getActionCommand();
			JButton button = (JButton) e.getSource();
			
			if(src.equals("Nhập khoản chi")) {
				chi.addTrans();
			}
			else if(src.equals("Tiền thu")) {
				chi.setVisible(false);
				new FormCopy_Thu(chi.getUser(), chi.getTran());
				}
			else if(button.getName().equals("up")){
				chi.tangMotNgay();
			} 
			else if(button.getName().equals("down")){
				chi.giamMotNgay();
			}else if(button.getName().equals("back")) {
				chi.setVisible(false);
				new FormListTrans(chi.getUser());
			}else if(src.equals("Chỉnh sửa >")) {
				chi.setVisible(false);
				new FormListCate(chi.getUser(), chi.getNameForm(),chi.getTran());
			}
			else {
				chi.setBorderClick(button);
				System.out.println(src + "\n---------------");
				chi.nameBtn();
			}
			
			
			chi.getNameUser();
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
