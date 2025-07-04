<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Userdao.UserBean"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login Sucessfully</title>
</head>
<body>
<% UserBean ub=(UserBean) session.getAttribute("ubean");
out.println("<h2>Welcome User : " + ub.getfName() + "</h2><br>");
%>
<a href="view2">View All Products</a><br>
<a href="logout">Logout</a>
</body>
</html>