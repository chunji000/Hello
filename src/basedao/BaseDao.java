package basedao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	public Connection conn;
	public BaseDao() {
		String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=bbs";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection(url, "sa", "sasa");
			System.out.println(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
