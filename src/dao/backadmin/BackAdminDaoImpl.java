package dao.backadmin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BackAdmin;
import model.authMsg;

import basedao.BaseDao;

public class BackAdminDaoImpl  extends BaseDao implements BackAdminDao {

	public int getcount(String name, String pwd) {
		String sql="select count(*) from users where uname=? and upwd=?";
		PreparedStatement ps;
		int count=0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
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

	public List<BackAdmin> getbackadmin(int uid, String uname, String spe) {
		BackAdminDaoImpl bAdminDaoImpl=new BackAdminDaoImpl();
		List<BackAdmin> list=new ArrayList<BackAdmin>();
		String sql="select UserId,UserName,UserBirth,UserSex,UserPicture,UserExp,UserMoney,UserSpe,AuthRange,UserRegTime,UserLastTime,UserPwd  from Users where 1=1 ";
		if (uid>0) {
			sql+=" and UserId="+uid+"";
		}
		if (uname!=null&&!"".equals(uname)) {
			sql+=" and UserName like '%"+uname+"%'";
		}
		if (spe!=null&&!"".equals(spe)) {
			sql+=" and UserSpe like '%"+spe+"%'";
		}
		PreparedStatement ps;
		int count=0;
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int uid2=rs.getInt("UserId");
				String uname2=rs.getString("UserName");
				String upwd=rs.getString("UserPwd");	
				String birth=rs.getString("UserBirth");
				String sex=rs.getString("UserSex");
				String picture=rs.getString("UserPicture");
				int exp=rs.getInt("UserExp");
				int money=rs.getInt("UserMoney");
				String spe2=rs.getString("UserSpe");
				int AuthRange=rs.getInt("AuthRange");
				String authMsg=bAdminDaoImpl.agetauthMsg(AuthRange);
				String regTime=rs.getString("UserRegTime");
				String lastTime=rs.getString("UserLastTime");
				BackAdmin admin=new BackAdmin(uid2, uname2, upwd, birth, sex, picture, exp, money, spe2, authMsg, regTime, lastTime);
				list.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public BackAdmin getlist(int uid) {
		BackAdminDaoImpl bAdminDaoImpl=new BackAdminDaoImpl();
		String sql="select UserId,UserName,UserBirth,UserSex,UserPicture,UserExp,UserMoney,UserSpe,AuthRange,UserRegTime,UserLastTime,UserPwd  from Users where UserId=?";
		PreparedStatement ps;
		System.out.println(sql);
		BackAdmin admin=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int uid2=rs.getInt("UserId");
				String uname=rs.getString("UserName");
				String upwd=rs.getString("UserPwd");	
				String birth=rs.getString("UserBirth");
				String sex=rs.getString("UserSex");
				String picture=rs.getString("UserPicture");
				int exp=rs.getInt("UserExp");
				int money=rs.getInt("UserMoney");
				String spe=rs.getString("UserSpe");
				int AuthRange=rs.getInt("AuthRange");
				String authMsg=bAdminDaoImpl.agetauthMsg(AuthRange);
				String regTime=rs.getString("UserRegTime");
				String lastTime=rs.getString("UserLastTime");
				admin=new BackAdmin(uid2,uname, upwd, birth, sex, picture, exp, money, spe, authMsg, regTime, lastTime);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return admin;
	}

	public List<authMsg> getauthMsg() {
		List<authMsg> list=new ArrayList<authMsg>();
		String sql="select * from Auth";
		PreparedStatement ps;
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int authId=rs.getInt("authId");
				String authMsg=rs.getString("authMsg");
				authMsg auth=new authMsg(authId, authMsg);
				list.add(auth);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public boolean update(BackAdmin bAdmin) {
		String sql="update users set UserName=?,UserPwd=?,UserBirth=?,UserSex=?,UserPicture=?,UserExp=?,UserMoney=?,UserSpe=? where UserId=?";
		System.out.println(bAdmin);
		int count=0;
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);			
			ps.setString(1, bAdmin.getUname());
			ps.setString(2, bAdmin.getUpwd());
			ps.setString(3, bAdmin.getBirth());
			ps.setString(4, bAdmin.getSex());
			ps.setString(5, bAdmin.getPicture());		
			ps.setInt(6, bAdmin.getExp());
			ps.setInt(7, bAdmin.getMoney());
			ps.setString(8, bAdmin.getSpe());
			ps.setInt(9, bAdmin.getUid());
			count=ps.executeUpdate();
			System.out.println(sql);
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return count>0?true:false;
	}

	public boolean del(int uid) {
		String sql="delete from users where UserId=?";
		System.out.println(sql);
		int count=0;
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);		
			ps.setInt(1, uid);
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return count>0?true:false;
	}


	public int getcount() {
		String sql="select count(*) from users";
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

	public String agetauthMsg(int AuthRange) {
		String sql="select AuthMsg from auth where AuthRange=?";
		PreparedStatement ps;
		String authMsg=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, AuthRange);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				authMsg=rs.getString("authMsg");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return authMsg;
	}


}
