package Userdao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import dao.ProductBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/order")
public class OrderProductServlet extends HttpServlet {
	
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
				 double pPrice =  pb.getPprice();
					int orgQty = pb.getPquantity();
					int requiredQty = Integer.parseInt(req.getParameter("qty"));
					
					int newQty = orgQty - requiredQty;
					
					double totalPrice = pPrice * requiredQty;
					
					
					if(newQty > 0)
					{
						pb.setPquantity(newQty);
						
						int k = new OrderProductDao().update(pb);
						
						if(k > 0)
						{
							req.setAttribute("msg", totalPrice);
							req.getRequestDispatcher("OrderSuccess.jsp").forward(req, res);;
						}
					}
					break;
				}
			}
			
		}
		
		
	}

}