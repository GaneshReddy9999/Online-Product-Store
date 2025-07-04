<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Userdao.UserBean"
    import="java.util.ArrayList,dao.ProductBean,java.util.Iterator"
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<%
		UserBean ub = (UserBean) session.getAttribute("ubean");
		ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");
		out.println("<h2>Page Belongs to User : " + ub.getfName() + "</h2><br>");

		if (al.size() == 0) {
			out.println("<h2>No Products Available...</h2><br>");
		} else {
		%>
	<table>
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
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
			<td><a href='buy?pcode=<%=pb.getPcode()%>'>Buy</a></td>
		</tr>
		<%
		}
		%>
	</table>

	<%
	}
	%>
		<a href="logout">Logout</a>
</body>
</html>