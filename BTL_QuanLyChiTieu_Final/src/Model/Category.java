package Model;

import dao.CategoryDAO;

public class Category {
	private String name;
	private String icon;
	private int loai;
	
	
	public Category() {
		
	}

	public Category(String name, String icon, int loai) {
		this.name = name;
		this.icon = icon;
		this.loai = loai;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getIcon() {
		return icon;
	}

	public int getLoai() {
		return loai;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setLoai(int loai) {
		this.loai = loai;
	}
	
	public void AddCaterogy(String username, String name, String icon, int loai) {	
		Category cate = new Category(name,icon,loai);
		CategoryDAO.getInstance().insert(username, cate);
	}
	
	public void deleteCate(String username, String name) {		
		CategoryDAO.getInstance().delete(username, name);
	}
	
}


