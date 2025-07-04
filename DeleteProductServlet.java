package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
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
					it.remove(); 
					
					int k = new DeleteProductDao().delete(pb);  
					
					if(k > 0)
					{
						req.setAttribute("msg", "Product Deleted Successfully...");
						req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);;
					}
					else
					{
						req.setAttribute("msg", "Failed to delete Product.");
				        req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);	
					}
					
					break;					
				}
			}
			
		}
		
	}

}
