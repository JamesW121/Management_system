<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/28721/5b597698f629d9117cc357a7.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/40719/5b5a7ddbf629d9117cc35810.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/32471/5b5a9320f629db117c8db747.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/47725/5b5a93a0f629db117c8db748.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/46721/5b615d69f629d80db4bc7c4d.css' rel='stylesheet' type='text/css' />
<title>Product Search</title>

<style>
.title{
		font-family:'ACMEExplosive';
		text-align:center;
	}
	.others{
		font-family:'Regencie';
		text-align:center;
		font-size:16px
	}

</style>
</head>
<body bgcolor = #FF9473>
	<%  ArrayList<Order> qualified_order = new ArrayList<Order>();
		qualified_order = (ArrayList)session.getAttribute("ordersearchresult"); %>
		<br>
	<h1 class = title >There are 
	<% out.print(qualified_order.size()); %>
	Qualified Results!
	</h1><br>
	<table border="1" align = "center">
  		<tr>
   			<th>ID</th>
   			<th>Product</th>
   			<th>Product_Id</th>
   			<th>Date</th>
   			<th>Number</th>
   			<th>Price</th>
   			<th>Status</th>
   			<th>Member_Id</th>
  		</tr>
	<%
	for(int i = 0; i < qualified_order.size(); i++){
		out.print("<tr>");
		out.print("<td><center>");
		out.println(qualified_order.get(i).getOrder_id());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_order.get(i).getGood_name());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_order.get(i).getGood_id());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_order.get(i).getDate());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_order.get(i).getNumber());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_order.get(i).getPrice());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_order.get(i).getStatus());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_order.get(i).getMember_id());
		out.println("</center></td>");
		out.print("</tr>");
	}
	out.print("</table>");
	%>
	<br><br>
	    <center><a href='DB_manage_order.jsp' class='button'>Back</a></center>
</body>
</html>