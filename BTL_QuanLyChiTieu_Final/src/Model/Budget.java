package Model;

import java.sql.Date;
import javax.swing.JOptionPane;
import dao.BudgetDAO;

public class Budget {
	private String iD;
    private int money;
    private Date startDate;
    private Date endDate;
    private String category;
    
    public Budget() {
    }

    public Budget(int money, Date startDate, Date endDate, String category) {
        this.money = money;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
    }
    
    public Budget(int money, Date startDate, Date endDate, String category, String iD) {
        this.money = money;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.iD = iD;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

	public void addBudget(String username, int soTien, Date ngayBatDau, Date ngayKetThuc, String danhMuc) {
		if(soTien ==  0 &&  danhMuc == null){
			JOptionPane.showMessageDialog(null,"Bạn chưa nhập đầy đủ dữ liệu");
				return;
		}
		else if(ngayBatDau == null || ngayKetThuc ==  null){
			JOptionPane.showMessageDialog(null,"Bạn chưa nhập đầy đủ thông tin hoặc "
					+ "\nNgày tháng không hợp lệ");
			return;
		}
		else if(danhMuc.equals("")) {
			JOptionPane.showMessageDialog(null,"Bạn chưa chọn danh mục");	
			return;
			

		}else if(soTien == 0) {
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
					
		Budget bud = new Budget(soTien, ngayBatDau, ngayKetThuc, danhMuc);
		BudgetDAO.getInstance().insert(username, bud);
	    }

    
    public void updateBudget(String username, String ID,  String danhMuc, int soTien, Date ngayBatDau, Date ngayKetThuc) {
    	if(ngayBatDau == null || ngayKetThuc == null) {
			JOptionPane.showMessageDialog(null,"Bạn chưa nhập đầy đủ thông tin hoặc "
					+ "\nNgày tháng không hợp lệ");
			return;
		}else if(danhMuc.equals("")) {
			JOptionPane.showMessageDialog(null,"Bạn chưa chọn danh mục");	
			return;
			

		}else if(soTien == 0) {
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
		Budget bud = new Budget(soTien, ngayBatDau, ngayKetThuc, danhMuc, ID);
		BudgetDAO.getInstance().update(username, bud);
		
    	
    }
    
    public void deleteBud(String username, String iD) {		
		BudgetDAO.getInstance().delete(username, iD);
	}
    
    public boolean CheckTransaction(Transaction transaction) {
        return transaction.getCategory().equals(category) &&
               transaction.getDate().compareTo(startDate) >= 0 &&
               transaction.getDate().compareTo(endDate) <= 0 &&
               transaction.getMoney() <= money;
    }

	@Override
	public String toString() {
		return "money=" + money + ", startDate=" + startDate + ", endDate=" + endDate + ", category=" + category;
	}
       
}
