package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
 
		String pcode = req.getParameter("pcode");
		String pnamel = req.getParameter("pnamel");
		double pprice = Double.parseDouble(req.getParameter("pprice"));
		int pquantity=Integer.parseInt(req.getParameter("pquantity"));
//		System.out.println(pcode);
		ProductBean product = new ProductBean();
		product.setPcode(pcode);
		product.setPnamel(pnamel);
		product.setPprice(pprice);
		product.setPquantity(pquantity);
		
		//PrintWriter out = resp.getWriter();
		try {
			int k = new ProductDao().insert(product);

			if (k > 0) {
				//HttpSession session=req.getSession();
				hs.setAttribute("msg", "product added successfully");
				RequestDispatcher rd=req.getRequestDispatcher("AdminLoginsucess.jsp");
				rd.forward(req, resp);
			}	
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}
	}
}
