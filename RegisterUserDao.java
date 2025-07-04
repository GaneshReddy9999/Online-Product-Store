package Userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUserDao {
	public int k = 0;
	public  int insert(UserBean ub) throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");

    Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/onlineproductstore",  "root",  "Archu@123");
    
    PreparedStatement ps = conn.prepareStatement("insert into usertab58 values (?,?,?,?,?,?,?)");
    
    ps.setString(1,ub.getUserName());
    ps.setString(2, ub.getPassword());
    ps.setString(3, ub.getfName());
    ps.setString(4, ub.getlName());
    ps.setString(5,ub.getAddress());
    ps.setLong(6,ub.getpNo());
    ps.setString(7, ub.getMid());
      
    k=ps.executeUpdate();
	return k;
	
	}
}
