package Userdao;

import java.io.IOException;
import java.sql.SQLException;

import dao.ProductDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/register")
public class RegisterUserServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		UserBean ub=new UserBean();
		ub.setUserName(req.getParameter("UserName"));
		ub.setPassword(req.getParameter("Password"));
		ub.setfName(req.getParameter("fName"));
		ub.setlName(req.getParameter("lName"));
		ub.setAddress(req.getParameter("Address"));
		ub.setpNo(Long.parseLong(req.getParameter("pNo")));
		
		
		int k;
		try {
			k = new RegisterUserDao().insert(ub);
		

		if (k > 0) {
			//HttpSession session=req.getSession();
			req.setAttribute("msg", "register successfully");
			RequestDispatcher rd=req.getRequestDispatcher("Register.jsp");
			rd.forward(req, resp);
		}	
	}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}}
