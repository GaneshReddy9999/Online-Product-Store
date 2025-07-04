package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.http.HttpSession;

public class ProductDao {
	public int k=0;
    public int insert(ProductBean product) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/onlineproductstore",  "root",  "Archu@123");

        PreparedStatement st = conn.prepareStatement(
            "INSERT INTO product58 (pcode, pnamel, pprice, pquantity) VALUES (?, ?, ?, ?)");
        st.setString(1, product.getPcode());
        st.setString(2, product.getPnamel());
        st.setDouble(3, product.getPprice());
        st.setInt(4, product.getPquantity());
         k = st.executeUpdate(); 
        return k; 
    }
}
