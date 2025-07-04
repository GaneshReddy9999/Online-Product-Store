package Userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDao {
	UserBean ub = null;

	public UserBean login(String UN, String Ps) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineproductstore", "root",
				"Archu@123");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM usertab58 WHERE UserName=? And password=?");
		ps.setString(1, UN);
		ps.setString(2, Ps);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			ub = new UserBean();
			ub.setUserName(rs.getString("UserName"));
			ub.setPassword(rs.getString("password"));
			ub.setfName(rs.getString("fName"));
			ub.setlName(rs.getString("lName"));
			ub.setAddress(rs.getString("Address"));
			ub.setpNo(rs.getLong("pNo"));
			ub.setMid(rs.getString("mid"));

		}

		return ub;

	}
}
