package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteProductDao {
int k = 0;
	
	public int delete(ProductBean pb)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineproductstore", "root",
					"Archu@123");
			
			PreparedStatement ps = conn.prepareStatement("delete from Product58 where Pcode = ?");
			
			ps.setString(1, pb.getPcode());
			
			k = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}

}
