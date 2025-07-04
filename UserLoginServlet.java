package Userdao;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/User")
public class UserLoginServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String UN=req.getParameter("UserName");
		String Ps=req.getParameter("Password");
		try {
			UserBean ub=new UserLoginDao().login(UN,Ps);
			if (ub == null) {
				req.setAttribute("msg", "Login failed");
				RequestDispatcher rd = req.getRequestDispatcher("Msg.jsp");
				rd.forward(req, resp);
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("ubean", ub);
				session.setAttribute("msg", "Login successfull");
				RequestDispatcher rd = req.getRequestDispatcher("UserLoginsucess.jsp");
				rd.forward(req, resp);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
