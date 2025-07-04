package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewProductDao {

	ArrayList<ProductBean> al = new ArrayList<ProductBean>();

	public ArrayList<ProductBean> retrive() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineproductstore", "root",
				"Archu@123");

		PreparedStatement st = conn.prepareStatement("select * from product58");

		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			ProductBean pb = new ProductBean();
			pb.setPcode(rs.getString(1));
			pb.setPnamel(rs.getString(2));
			pb.setPprice(rs.getDouble(3));
			pb.setPquantity(rs.getInt(4));
			al.add(pb);

		}

		return al;

	}

}
