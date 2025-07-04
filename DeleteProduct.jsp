<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="dao.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DeleteProduct</title>
</head>
<body>
<div class="container">
		<%
		AdminBean ab = (AdminBean) session.getAttribute("abean");
		String msg = (String) request.getAttribute("msg");
		out.println("<h2>Page Belongs to Admin : " + ab.getFirstname()+ "</h2><br>");
		out.println("<h2>" + msg + "</h2><br>");
		%>

		<a href="Product.html">Add Product</a> <br>
		<a href="view1">View AllProducts</a> <br>
		<a href="logout">Logout</a>
	</div>
</body>
</html>