<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/28721/5b597698f629d9117cc357a7.css' rel='stylesheet' type='text/css' />

<style>
body {
    margin: 0;
    background-color: #64A8D1;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    padding-top: 15%;
    width: 18%;
    background-color: #3D9AD1;
    position: fixed;
    height: 100%;
    overflow: auto;
    text-align: center;
    font-family:'ACMEExplosive';
    font-size: 23px;
}

li a {
    display: block;
    color: #000;
    padding: 15px 30px;
    text-decoration: none;
}

li a.active {
    background-color: #0969A2;
    color: white;
}

li a:hover:not(.active) {
    background-color: #A5DBFC;
    color: black;
}

.home_title{
	margin-left:20%;
	padding-top:20%;
	font-family:'ACMEExplosive';
	font-size: 40px;
	text-align: center;
}

</style>

<title>Data Management System</title>
</head>
<body>

	<ul>
		<li><a href="DB_manage.jsp">Home</a></li>
		<li><a href="DB_manage_emp.jsp">Employee</a></li>
		<li><a href="DB_manage_product.jsp">Product</a></li>
		<li><a href="DB_manage_order.jsp">Order</a></li>
		<li><a class="active" href="DB_manage_member.jsp">Membership</a></li>
	</ul>
<div class = "home_title">
	Membership
</div>

</body>
</html>