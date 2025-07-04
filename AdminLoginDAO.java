package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminLoginDAO {
	AdminBean ab = null;
	public AdminBean login(String UN, String PS) throws SQLException, Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");//register Driver class
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineproductstore", "root",
				"Archu@123"); // extablish connection 
		PreparedStatement st = conn.prepareStatement("SELECT * FROM admintab58 WHERE UserName = ? AND password = ?");
		st.setString(1, UN);
		st.setString(2, PS);
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
		 ab = new AdminBean();
			ab.setUserName(rs.getString("UserName"));
			ab.setPassword(rs.getString("password"));
			ab.setFirstname(rs.getString("firstname"));
			ab.setLastname(rs.getString("lastname"));
			ab.setEmailid(rs.getString("emailid"));
			ab.setAdress(rs.getString("adress"));
		}
		return ab;

	}
}
