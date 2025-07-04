<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Userdao.UserBean,java.util.ArrayList,dao.ProductBean,java.util.Iterator"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<%
		UserBean ub = (UserBean) session.getAttribute("ubean");
		ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");
		out.println("<h2>Page Belongs to Admin : " + ub.getfName() + "</h2><br>");

		if (al.size() == 0) {
			out.println("<h2>No Products Available...</h2><br>");
		} else {
			ProductBean pb = null;
		%>
	</div>
	<table>
		<tr>
			<th>ProductCode</th>
			<th>ProductName</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>
		<%
		Iterator<ProductBean> it = al.iterator();
		while (it.hasNext()) {
			pb = (ProductBean) it.next();
		%>
		<tr>
			<td><%=pb.getPcode()%></td>
			<td><%=pb.getPnamel()%></td>
			<td><%=pb.getPprice()%></td>
			<td><%=pb.getPquantity()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<form action="order" method="post">
		<input type="hidden" name="pcode" value="<%=pb.getPcode()%>">
		Enter Required Quantity : <input type="number" name="qty" id="qty"
			placeholder="Enter Required Quantity" required="required"><br>
		<input type="submit" value="Buy Product">
	</form>

	<%
	}
	%>
	<div class="container">
		<a href="logout">Logout</a>
	</div>
</body>
</html>