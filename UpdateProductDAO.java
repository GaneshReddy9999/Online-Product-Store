package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProductDAO {


	int k = 0;
	
	public int update(ProductBean pb) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineproductstore", "root",
				"Archu@123");
		PreparedStatement ps = conn.prepareStatement("update Product58 set pprice = ?, pquantity = ? where pcode = ?");
		
		ps.setDouble(1, pb.getPprice());
		ps.setInt(2, pb.getPquantity());
		ps.setString(3, pb.getPcode());
		k = ps.executeUpdate();
		return k;
		
	}


}

