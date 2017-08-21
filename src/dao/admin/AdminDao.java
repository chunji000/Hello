package dao.admin;

import java.util.List;

import model.admin;

public interface AdminDao {
	public int getcount(String name,String pwd);
	
	public List<admin> getadmininfo( String name);
	
}
