package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import View.FormCopy_Chi;
import View.FormListCate;
import View.FormListTrans;
import View.FormSearch;
import View.FormSuaChi;


public class SuaChiController implements ActionListener, WindowListener {
	private FormSuaChi suaChi;
	public SuaChiController(FormSuaChi suaChi) {
		this.suaChi = suaChi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JButton button = (JButton) e.getSource();
		
		if(button.getName().equals("up")){
			suaChi.tangMotNgay();
		} 
		else if(button.getName().equals("down")){
			suaChi.giamMotNgay();
		}else if(src.equals("Chỉnh sửa")){
			suaChi.updateTran();
		}else if(src.equals("Xóa")) {
			suaChi.deleteTran();
			this.suaChi.setVisible(false);
			new FormListTrans(suaChi.getUser());
		}else if(src.equals("Copy")) {
			this.suaChi.setVisible(false);
			new FormCopy_Chi(suaChi.getUser(), suaChi.getTran());
		}else if(button.getName().equals("back")){
			if(suaChi.nameFormBack().equals("listForm")) {
				this.suaChi.setVisible(false);
				new FormListTrans(suaChi.getUser());
			}else if(suaChi.nameFormBack().equals("searchForm")) {
				this.suaChi.setVisible(false);
				new FormSearch(suaChi.getUser());
			}	
		}else if(src.equals("Chỉnh sửa >")) {
			suaChi.setVisible(false);
			new FormListCate(suaChi.getUser(), suaChi.getNameForm(), suaChi.getTran(), suaChi.nameFormBack());
		}
		else {
			suaChi.setBorderClick(button);
			System.out.println(src + "\n---------------");
			suaChi.nameBtn();
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
			suaChi.setVisible(false);		
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
