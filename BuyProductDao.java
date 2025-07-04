package Userdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.ProductBean;

public class BuyProductDao {
public ArrayList<ProductBean> al = new ArrayList<ProductBean>();
	
	public ArrayList<ProductBean> getProduct(String code)
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineproductstore", "root",
					"Archu@123");

			
			PreparedStatement ps = conn.prepareStatement("select * from Product58 where pcode = ?");
			
			ps.setString(1, code);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				ProductBean pb = new ProductBean();
				
				pb.setPcode(rs.getString(1));
				pb.setPnamel(rs.getString(2));
				pb.setPprice(rs.getDouble(3));
				pb.setPquantity(rs.getInt(4));;
				
				al.add(pb);  			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return al;
	}

}
