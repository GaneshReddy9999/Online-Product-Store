<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Userdao.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		UserBean ub = (UserBean) session.getAttribute("ubean");
		out.println("<h2>Page belongs to User : " + ub.getfName() + "</h2><br>");
		double msg = (double) request.getAttribute("msg");
		out.println("<h2>Your Total Bill Amount is : Rs." + msg + "</h2><br>");
		%>
		<a href="payment.html">Payment</a> <br>
		<a href="view2">View AllProducts</a> <br>
		<a href="logout">Logout</a>
</body>
</html>