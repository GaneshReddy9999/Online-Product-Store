 <%@page import="java.util.Iterator"%>
<%@page import="dao.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Product</title>
<style>
table {
	border: 2px solid black;
}
</style>
</head>
<body>
	<%
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	out.println("<h2>Page Belongs to Admin : " + ab.getFirstname() + "</h2><br>");

	%>
	<%
	ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");
	if (al.size() == 0) {
	%>
	<h1>Products are empty</h1>
	<%
	} else {
	%>
	<table>
		<tr>
			<th>pcode</th>
			<th>pname</th>
			<th>pprice</th>
			<th>pquantity</th>
			<th>Actions</th>
		</tr>
		<%
		Iterator<ProductBean> it = al.iterator();
		while (it.hasNext()) {
			ProductBean pb = (ProductBean) it.next();
		%>
		<tr>
			<td><%=pb.getPcode()%></td>
			<td><%=pb.getPnamel()%></td>
			<td><%=pb.getPprice()%></td>
			<td><%=pb.getPquantity()%></td>
			<td><a href='edit?pcode=<%=pb.getPcode()%>'>Edit</a>
			 <a href='delete?pcode=<%=pb.getPcode()%>'>Delete</a></td>
		</tr>

		<%
		}
		%>
	</table>
	<%
	}
	%>
	<a href="Product.html">AddProduct</a><br>
	<a href="logout">Logout</a>
</body>
</html>