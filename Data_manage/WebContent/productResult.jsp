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
<body bgcolor = #B5C064>
	<%  ArrayList<Product> qualified_product = new ArrayList<Product>();
		qualified_product = (ArrayList)session.getAttribute("searchresult"); %>
		<br>
	<h1 class = title >There are 
	<% out.print(qualified_product.size()); %>
	Qualified Results!
	</h1><br>
	<table border="1" align = "center">
  		<tr>
    		<th>Name</th>
   			<th>ID</th>
   			<th>Number</th>
   			<th>Category</th>
   			<th>Expiration_date</th>
   			<th>Provider</th>
   			<th>Price</th>
   			<th>Cost</th>
   			<th>Provider_contact</th>
  		</tr>
	<%
	for(int i = 0; i < qualified_product.size(); i++){
		out.print("<tr>");
		out.print("<td><center>");
		out.println(qualified_product.get(i).getName());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_product.get(i).getID());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_product.get(i).getCount());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_product.get(i).getCategory());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_product.get(i).getExpiration());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_product.get(i).getSource());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_product.get(i).getPrice());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_product.get(i).getCost());
		out.println("</center></td>");
		out.print("<td><center>");
		out.println(qualified_product.get(i).getSource_contact());
		out.println("</center></td>");
		out.print("</tr>");
	}
	out.print("</table>");
	%>
	<br><br>
	    <center><a href='DB_manage_product.jsp' class='button'>Back</a></center>
</body>
</html>