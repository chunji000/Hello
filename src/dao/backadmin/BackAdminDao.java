package dao.backadmin;

import java.util.List;

import model.BackAdmin;
import model.authMsg;

public interface BackAdminDao {
	//登录
	public int getcount(String name,String pwd);
	//模糊查询
	public List<BackAdmin> getbackadmin(int uid,String uname,String spe);
	//修改查询
	public BackAdmin getlist(int uid);
	//查询全部用户类型
	public List<authMsg> getauthMsg();
	//查询单个用户类型
	public String agetauthMsg(int AuthRange);
	//修改
	public boolean update(BackAdmin bAdmin);
	//删除
	public boolean del(int uid);
	//总条数、
	public int getcount();
}
