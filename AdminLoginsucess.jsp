<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

h1{
border:2px solid black;
width:200px;
height:100px;
padding-right:50px;
padding-top:50px;
padding-left:50px;
padding-bottom:50px;
margin-left:250px;
margin-top:20px;
background-color:pink;
text-align:center;
font-size:14px;
}
</style>
</head>
<body>
<div>
<% String msg=(String)session.getAttribute("msg"); %>
<h1><%=msg %>
<br>
<button><a href="Product.html">AddProduct</a></button><br><br>
<button><a href="view1">View All Products</a></button><br><br>
<button><a href="logout">Logout</button></a>
</h1>
</div>
</body>
</html>