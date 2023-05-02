package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
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

public class SearchController implements ActionListener, MouseListener, WindowListener {
	private FormSearch search;
	
	public SearchController(FormSearch search) {
		this.search = search;
	}

	@Override
	public void mouseClicked(MouseEvent e) {   // click
		 int loai = Integer.parseInt(search.layGiaTri());
		 if (e.getClickCount() == 2) {
	            System.out.println("Double-clicked!");
	            this.search.setVisible(false);
	            if(loai == 1)
	            	new FormSuaThu(search.getUser(),search.getTran(),search.nameForm() );
	            else if(loai == 0)
	            	new FormSuaChi(search.getUser(), search.getTran(),search.nameForm());            
	        }
		
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
	public void actionPerformed(ActionEvent e) {
		
		String src = e.getActionCommand();
		JButton btn = (JButton) e.getSource();
		
		if(btn.getName().equals("tìm kiếm")){
			System.out.println("search");
			search.reloadTable();
			
		}else if(btn.getName().equals("back")) {
			search.setVisible(false);
			new FormListTrans(search.getUser());
		}
		else if(src.equals("Nhập vào")) {
			search.setVisible(false);
			new MainPage_Chi(search.getUser());
		}else if(src.equals("Khác")) {
			search.setVisible(false);
			new FormSetting(search.getUser());
		}else if(src.equals("Ngân sách")) {
			search.setVisible(false);
			new FormBudget(search.getUser());
		}else if(src.equals("Báo cáo")) {
			search.setVisible(false);
			try {
				new FormBaoCaoTheoThang(search.getUser());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
			search.setVisible(false);		
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
