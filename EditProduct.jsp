<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="dao.AdminBean,dao.ProductBean,java.util.ArrayList,java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Jsp</title>
</head>
<body>
	<div class="container">
		<%
		AdminBean ab = (AdminBean) session.getAttribute("abean");
		out.println("<h2>Page Belongs to Admin : " + ab.getFirstname() + "</h2><br>");
		String pc = request.getParameter("pcode");

		ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");
		Iterator<ProductBean> it = al.iterator();

		while (it.hasNext()) {
			ProductBean pb = (ProductBean) it.next();

			if (pc.equals(pb.getPcode())) {
		%>

		<form action="update" method="post">
			<h2>Update Product Details</h2>
			<p>Update the Product Details Below</p>
			<div class="container">
				<input type="hidden" name="pcode" value=<%=pb.getPcode()%>>
				<input type="text" id="price" name="price" value=<%=pb.getPprice()%>>
				<input type="text" id="qty" name="qty" value=<%=pb.getPquantity()%>>
			</div>
			<input type="submit" value="Update Product">
		</form>

		<% 
		break;

		}
		}
		%>
	</div>
</body>
</html>