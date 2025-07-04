<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="dao.AdminBean"
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ProductStatus</title>
<link rel="stylesheet" href="css/OnlineStoreStyles.css">
</head>
<body>
	<div class="container">
		<%
		AdminBean ab = (AdminBean) session.getAttribute("abean");
		String msg = (String) request.getAttribute("msg");
		out.println("<h2>Page Belongs to Admin : " + ab.getFirstname() + "</h2><br>");
		out.println("<h2>" + msg + "</h2><br>");
		%>
	</div>
	<a href="product.html">Add Product</a><br>
	<a href="view1">View All Products</a><br>
	<a href="logout">Logout</a>

</body>
</html>