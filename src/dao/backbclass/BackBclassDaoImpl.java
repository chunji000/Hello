package dao.backbclass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.swing.internal.plaf.basic.resources.basic;

import dao.backadmin.BackAdminDaoImpl;

import model.BackAdmin;
import model.Bclass;
import model.authMsg;
import model.moderator;
import basedao.BaseDao;

public class BackBclassDaoImpl extends BaseDao implements BackBclassDao {

	public List<Bclass> getbclass(String classname,int bid) {
		BackBclassDaoImpl bDaoImpl=new BackBclassDaoImpl();
		List<Bclass> list=new ArrayList<Bclass>();
		String sql="select *  from bclass where 1=1 ";
		if (bid>0) {
			sql+=" and ClassId in (select ClassId from moderator where UserId= "+bid+")";
		}
		if (classname!=null&&!"".equals(classname)) {
			sql+=" and ClassName like '%"+classname+"%'";
		}
		
		PreparedStatement ps;
		int count=0;
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int classId=rs.getInt("ClassId");
				String UserName=bDaoImpl.getbname(classId);
				System.out.println(UserName);
				String className=rs.getString("ClassName");
				String classMsg=rs.getString("ClassMsg");	
				String classPicture=rs.getString("ClassPicture");
				Bclass bclass=new Bclass(classId, className, classMsg, classPicture,UserName);
				list.add(bclass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;
	}

	public String getbname(int bid) {
		String sql="select UserName  from users where UserId in (select UserId from moderator where ClassId=?) ";
		String UserName=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				UserName=rs.getString("UserName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UserName;
	}
	public int getuid(String username) {
		String sql="select UserId from users where UserName=? ";
		int count=0;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				count=rs.getInt("UserId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public List<BackAdmin> getbclassname() {
		List<BackAdmin> list=new ArrayList<BackAdmin>();
		String sql="select UserId,UserName from users where UserId in (select UserId from moderator)";
		PreparedStatement ps;
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int UserId=rs.getInt("UserId");
				String UserName=rs.getString("UserName");
				BackAdmin backAdmin=new BackAdmin(UserId, UserName);
				list.add(backAdmin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int getcount() {
		String sql="select count(*) from bclass";
		PreparedStatement ps;
		int count=0;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

	public boolean add(Bclass bclass) {
		String sql="insert into bclass values (?,?,?)";
		int count=0;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bclass.getClassName());
			ps.setString(2, bclass.getClassMsg());
			ps.setString(3, bclass.getClassPicture());
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count>0?true:false;
	}


	public boolean addbname(moderator moderator) {
		String sql="insert into moderator ClassId value ? where UserId=?";
		int count=0;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, moderator.getClassId());
			ps.setInt(2, moderator.getUserId());
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count>0?true:false;
	}

	public int getbid() {
		String sql="select top 1 ClassId from bclass order by ClassId desc ";
		int count=0;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				count=rs.getInt("ClassId");
			}
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}

}
