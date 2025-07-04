package Userdao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dao.ProductBean;
import dao.ViewProductDao;
@WebServlet("/view2")
public class ViewAllProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs=req.getSession(false);
		if(hs == null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, resp);
		}
		else
		{
			ArrayList<ProductBean> al;
			try {
				al = new ViewProductDao().retrive();
					
			hs.setAttribute("alist", al);
			
			req.getRequestDispatcher("ViewAllProducts2.jsp").forward(req, resp);
		}
	catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}}}
		
	
		
		
