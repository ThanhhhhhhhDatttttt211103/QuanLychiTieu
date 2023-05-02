package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import View.FormBaoCaoTheoNam;
import View.FormBaoCaoTheoThang;
import View.FormListTrans;
import View.FormSetting;
import View.MainPage_Chi;

public class BaoCaoTheoNamController implements ActionListener, WindowListener {
	private  FormBaoCaoTheoNam baocao;
	
	public BaoCaoTheoNamController(FormBaoCaoTheoNam baocao) {
		this.baocao = baocao;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		JButton btn = (JButton) e.getSource();
		
		if(btn.getName().equals("up")) {
			baocao.tang1Lan();
			System.out.println("up");
			try {
				baocao.reloadChiTietBaoCao();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(btn.getName().equals("down")) {
			baocao.giam1Lan();
			System.out.println("down");
			
			try {
				baocao.reloadChiTietBaoCao();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(src.equals("Nhập vào")) {
			baocao.setVisible(false);
			new MainPage_Chi(baocao.getUser());
		}else if(src.equals("Danh sách")) {
			baocao.setVisible(false);
			new FormListTrans(baocao.getUser());
		}else if(src.equals("Ngân sách")) {
			baocao.setVisible(false);
			new FormListTrans(baocao.getUser());
		}else if(src.equals("Khác")) {
			baocao.setVisible(false);
			new FormSetting(baocao.getUser());
		}else if(src.equals("Thu Nhập")) {
			baocao.baoCaoThuNhap();
			System.out.println(src);
		}else if(src.equals("Chi Tiêu")) {
			baocao.baoCaoChiTieu();
			System.out.println(src);
		}else if(src.equals("Hàng Tháng")) {
			baocao.setVisible(false);
			try {
				new FormBaoCaoTheoThang(baocao.getUser());
			} catch (InterruptedException e1) {
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
			baocao.setVisible(false);		
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
