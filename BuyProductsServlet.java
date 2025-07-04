package Userdao;

import java.io.IOException;
import java.util.ArrayList;

import dao.ProductBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


	@SuppressWarnings("serial")
	@WebServlet("/buy")
	public class BuyProductsServlet extends HttpServlet {
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
		{
			HttpSession hs = req.getSession(false);
			
			if(hs == null)
			{
				req.setAttribute("msg", "Session Expired...<br>");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
			else
			{
				String pCode = req.getParameter("pcode");
				ArrayList<ProductBean> al = new BuyProductDao().getProduct(pCode);
				hs.setAttribute("alist", al);
				
				req.getRequestDispatcher("BuyProducts.jsp").forward(req, res);
			}
		}}


	
