package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs == null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
		else
		{
			
			@SuppressWarnings("unchecked")
			ArrayList<ProductBean> al = (ArrayList<ProductBean>)hs.getAttribute("alist");
			
			String pCode = req.getParameter("pcode");
			
			Iterator<ProductBean> it = al.iterator();
			
			while(it.hasNext())
			{
				ProductBean pb = (ProductBean)it.next();
				
				if(pCode.equals(pb.getPcode()))
				{
					pb.setPprice(Double.parseDouble(req.getParameter("price")));
					pb.setPquantity(Integer.parseInt(req.getParameter("qty")));
					
					
					try {
					int 	k = new UpdateProductDAO().update(pb);
					
					
					if(k > 0)
					{
						req.setAttribute("msg", "Product Details Updated Successfully...");
						req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);;
					}} catch (ClassNotFoundException | SQLException e) {
						
						e.printStackTrace();
					}
					
					break;
				}
			}
			
		}
		
		
	}

}

	


