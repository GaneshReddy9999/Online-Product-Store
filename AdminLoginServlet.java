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

@WebServlet("/Admin")
public class AdminLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String UN = req.getParameter("UserName");
		String PS = req.getParameter("password");
		try {
			AdminBean ab = new AdminLoginDAO().login(UN, PS);
//			System.out.println(ab.getFirstname());
//			System.out.println(ab.getPassword());
			if (ab == null) {
				req.setAttribute("msg", "Login failed");
				RequestDispatcher rd = req.getRequestDispatcher("Msg.jsp");
				rd.forward(req, resp);
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("abean", ab);
				session.setAttribute("msg", "Login successfull");
				RequestDispatcher rd = req.getRequestDispatcher("AdminLoginsucess.jsp");
				rd.forward(req, resp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
