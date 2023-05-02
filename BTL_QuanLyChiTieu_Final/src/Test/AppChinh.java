package Test;

import java.awt.EventQueue;
import View.FormDangNhap;

public class AppChinh {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new FormDangNhap();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}