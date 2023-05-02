package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.FormCopy_Thu;
import View.FormListCate;
import View.FormListTrans;
import View.FormSearch;
import View.FormSuaThu;

public class SuaThuController implements ActionListener, WindowListener {
	private FormSuaThu suaThu;
	public SuaThuController(FormSuaThu suaThu) {
		this.suaThu = suaThu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JButton button = (JButton) e.getSource();
		
		if(button.getName().equals("up")){
			suaThu.tangMotNgay();
		} 
		else if(button.getName().equals("down")){
			suaThu.giamMotNgay();
		}else if(src.equals("Chỉnh sửa")){
			suaThu.updateTran();
		}else if(src.equals("Xóa")) {
			suaThu.deleteTran();
			this.suaThu.setVisible(false);
			new FormListTrans(suaThu.getUser());
		}else if(src.equals("Copy")) {
			this.suaThu.setVisible(false);
			new FormCopy_Thu(suaThu.getUser(), suaThu.getTran());
		}else if(button.getName().equals("back")){
			if(suaThu.nameFormBack().equals("listForm")) {
				this.suaThu.setVisible(false);
				new FormListTrans(suaThu.getUser());
			}else if(suaThu.nameFormBack().equals("searchForm")) {
				this.suaThu.setVisible(false);
				new FormSearch(suaThu.getUser());
			}	
		}else if(src.equals("Chỉnh sửa >")) {
			suaThu.setVisible(false);
			new FormListCate(suaThu.getUser(), suaThu.getNameForm(), suaThu.getTran(),suaThu.nameFormBack());
		}
		else {
			suaThu.setBorderClick(button);
			System.out.println(src + "\n---------------");
			suaThu.nameBtn();
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
			suaThu.setVisible(false);		
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
