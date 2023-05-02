package dao;
public interface DAOinterface<T> {
	public int update(String user, T t);
	
	public int insert(String user, T t);
}
