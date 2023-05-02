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

public class Copy_ThuController implements ActionListener, WindowListener {
		private FormCopy_Thu thu;
		
		
		public Copy_ThuController( FormCopy_Thu thu) {
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
				new FormCopy_Chi(thu.getUser(), thu.getTran());
			}else if(button.getName().equals("up")){
					thu.tangMotNgay();
			}else if(button.getName().equals("down")){
				thu.giamMotNgay();			
			}else if(button.getName().equals("back")) {
				thu.setVisible(false);
				new FormListTrans(thu.getUser());
			}else if(src.equals("Chỉnh sửa >")) {
				thu.setVisible(false);
				new FormListCate(thu.getUser(), thu.getNameForm(), thu.getTran());
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
			int con = JOptionPane.showConfirmDialog(null,  "Bạn chắc chắn muốn thoát chương trình?", "Xác nhân thoát", JOptionPane.YES_NO_OPTION);
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
