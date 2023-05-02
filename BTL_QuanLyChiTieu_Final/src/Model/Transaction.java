package Model;

import java.sql.Date;
import javax.swing.JOptionPane;
import dao.TransactionDAO;

public class Transaction {
	private String iD;
	private Date date;
	private String note;
	private int money;
	private String category;
	private int loai;

	public Transaction() {
		this.date = null;
		this.note = null;
		this.money = 0;
		this.category = null;
		this.loai = 0;
	}
	
	public Transaction(Date date, String note, int money, String category, String iD) {
		this.date = date;
		this.note = note;
		this.money = money;
		this.category = category;
		this.iD = iD;
	}
	
	public Transaction(Date date, String note, int money, String category, int loai) {
		this.date = date;
		this.note = note;
		this.money = money;
		this.category = category;
		this.loai = loai;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}
	
	public int getLoai() {
		return loai;
	}

	public void setLoai(int loai) {
		this.loai = loai;
	}

	public void addTrans(String username, String danhMuc, Date ngayGiaoDich , int soTien, String ghiChu, int loai) {
			if(soTien ==  0 &&  danhMuc == null){
			JOptionPane.showMessageDialog(null,"Bạn chưa nhập dữ liệu");
				return;
			}
			else if(danhMuc.equals("")) {
				JOptionPane.showMessageDialog(null,"Bạn chưa chọn danh mục");	
				return;

			}else if(soTien == 0) {
				Object[] options = {"Tiếp tục",
				"Chỉnh sửa"};
				int n = JOptionPane.showOptionDialog(null,
				"Bạn chưa nhập số tiền hoặc số tiền không hợp lệ",
				"Bạn có muốn tiếp tục không?",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, //do not use a custom Icon
				options, //the titles of buttons
				options[0]); //default button title
				
				if(n == JOptionPane.NO_OPTION) {
					return;
				}
			}
			Transaction tran = new Transaction(ngayGiaoDich, ghiChu, soTien, danhMuc,loai);
			TransactionDAO.getInstance().insert(username, tran);	
	    }
	
	
	public void updateTran(String username, String danhMuc, Date ngayGiaoDich , int soTien, String ghiChu, String iD) {
			if(soTien == 0) {
			Object[] options = {"Tiếp tục",
			"Chỉnh sửa"};
			int n = JOptionPane.showOptionDialog(null,
			"Bạn chưa nhập số tiền",
			"Bạn có muốn tiếp tục không?",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null, //do not use a custom Icon
			options, //the titles of buttons
			options[0]); //default button title
			
			if(n == JOptionPane.NO_OPTION) {
				return;
			}
		}
			Transaction tran = new Transaction(ngayGiaoDich, ghiChu, soTien, danhMuc, iD);
			TransactionDAO.getInstance().update(username, tran);
    
    }
	
	public void deleteTran(String username, String iD) {		
		TransactionDAO.getInstance().delete(username, iD);
	}
}
