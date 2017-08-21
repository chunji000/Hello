package dao.backbclass;

import java.util.List;

import model.BackAdmin;
import model.Bclass;
import model.moderator;

public interface BackBclassDao {
	//查询
	public List<Bclass> getbclass(String classname,int bid);
	//版块ID得到版主名字
	public String getbname(int bid);
	//版主名字得到版主ID
	public int getuid(String username);
	//查询所有版主
	public List<BackAdmin> getbclassname();
	//总条数
	public int getcount();
	//添加板块
	public boolean add(Bclass bclass);
	//添加板主
	public boolean addbname(moderator moderator);
	//查询新添加的板块的ID
	public int getbid();
}
