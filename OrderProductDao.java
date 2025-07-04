package Userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import dao.ProductBean;

public class OrderProductDao {
int k = 0;
	
	public int update(ProductBean pb)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		    Connection conn = DriverManager.getConnection(
		        "jdbc:mysql://localhost:3306/onlineproductstore",  "root",  "Archu@123");
			
			PreparedStatement ps = conn.prepareStatement("update Product58 set pquantity = ? where pcode = ?");

			ps.setInt(1, pb.getPquantity());
			ps.setString(2, pb.getPcode());
			
			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}

