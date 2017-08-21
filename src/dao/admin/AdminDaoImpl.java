package dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.admin;

import basedao.BaseDao;

public class AdminDaoImpl extends BaseDao implements AdminDao {

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

	public List<admin> getadmininfo(String name) {
		List<admin> list=new ArrayList<admin>();
		String sql="select ui.infoId, u.uname,ui.birth,ui.sex,ui.picture,ui.exp,ui.money,ui.spe,a.authMsg  from Users u, UsersInfo ui,Auth a where u.uid=ui.uid and u.authid=a.authid and uname=?";
		System.out.println(sql);
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {			
				int infoId=rs.getInt(1);
				String uname=rs.getString(2);
				String birth=rs.getString(3);
				String sex=rs.getString(4);
				String picture=rs.getString(5);
				int exp=rs.getInt(6);
				int money=rs.getInt(7);
				String spe=rs.getString(8);
				String authMsg=rs.getString(9);
				admin admin=new admin(infoId, uname, birth, sex, picture, exp, money, spe, authMsg);
				list.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
