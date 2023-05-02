package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import View.FormBudget;
import View.FormCopy_Chi;
import View.FormCopy_Thu;
import View.FormListCate;
import View.FormSuaChi;
import View.FormSuaThu;
import View.FormThemDanhMuc;
import View.MainPage_Chi;
import View.MainPage_Thu;

public class ListCateController implements ActionListener, MouseListener, WindowListener {

	private FormListCate listCate;
	
	public ListCateController(FormListCate listCate) {
		this.listCate = listCate;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JButton button = (JButton) e.getSource();
		if(src.equals("Thu Nhập")) {
			listCate.tableThuNhap();
		}else if(src.equals("Chi Tiêu")) {
			listCate.tableChiTieu();
		}else if(src.equals("Thêm danh mục")) {
			listCate.setVisible(false);
			if(listCate.nameBack() == null)
				new FormThemDanhMuc(listCate.getUser(), listCate.formBack(), listCate.getTranBack());
			else {
				new FormThemDanhMuc(listCate.getUser(), listCate.formBack(), listCate.getTranBack(),listCate.nameBack());
			}
				

		}else if(src.equals("Xóa danh mục")) {
			listCate.deleteCate();
			listCate.reloadTable();
		}else if(button.getName().equals("back")) {
			listCate.setVisible(false);
			if(listCate.formBack().equals("Chi"))
				new MainPage_Chi(listCate.getUser());
			else if(listCate.formBack().equals("Thu"))
				new MainPage_Thu(listCate.getUser());
			else if(listCate.formBack().equals("Ngân sách"))
				new FormBudget(listCate.getUser());
			else if(listCate.formBack().equals("suaChi"))
				new FormSuaChi(listCate.getUser(), listCate.getTranBack(),listCate.nameBack());
			else if(listCate.formBack().equals("suaThu"))
				new FormSuaThu(listCate.getUser(), listCate.getTranBack(),listCate.nameBack());
			else if(listCate.formBack().equals("copyChi"))
				new FormCopy_Chi(listCate.getUser(), listCate.getTranBack());
			else if(listCate.formBack().equals("copyThu"))
				new FormCopy_Thu(listCate.getUser(), listCate.getTranBack());
		}	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
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
			listCate.setVisible(false);		
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
