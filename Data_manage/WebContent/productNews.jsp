<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/28721/5b597698f629d9117cc357a7.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/40719/5b5a7ddbf629d9117cc35810.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/32471/5b5a9320f629db117c8db747.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/47725/5b5a93a0f629db117c8db748.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/46721/5b615d69f629d80db4bc7c4d.css' rel='stylesheet' type='text/css' />
<title>Product News</title>

<style>
.title{
		font-family:'ACMEExplosive';
		text-align:center;
		padding: 0;
	}
	.others{
		font-family:'Regencie';
		text-align:center;
		font-size:16px
	}
	p{
		margin:0px;
		padding:0px;
		white-space:nowrap;
	}

</style>

</head>
<body bgcolor = #B5C064>
		<% 	Product min_number = (Product)session.getAttribute("min_num");
			Product next_exp = (Product)session.getAttribute("next_sell"); 	
			Product best = (Product)session.getAttribute("best_seller"); %>
			<h1 class = title >Product News</h1>
			<br>
		<p class = title >There are only</p>
		<p class = title style="font-weight:bold;">
		<% out.print( min_number.getCount() + "&nbsp"); 
		   out.print(min_number.getName() + " left!");%></p>
		   <p class = title ><br> Contact</p>
		<p class = title style="font-weight:bold;"> <%out.print(  min_number.getSource() );%></p>
		 <p class = title >to get more. <br>Tel: </p>
		 <p class = title style="font-weight:bold;" ><%out.print(min_number.getSource_contact());%></p>

		<br><br>
		<p class = title >
		<% out.print(next_exp.getName() + "<br>"); %>
		 <%  out.println("will be expired in <br>"+next_exp.getExpiration() + "!"); %>
		 </p>
		 
		 <p class = title > <% out.print("This is your next expiring item.");%></p>
		
		<br><br><br>
		<p class = title > <% out.print("The Best Selling item is...");%></p>
				<h4 class = title >
		<% out.print(best.getName() + "! <br> ID: " + best.getID() + "<br><br>"); 
		   out.print(best.getCount() +" " + best.getName() + "<br> were sold!");
		%>
		 </h4>
		 <br><br>
		 
		  <center><a href='DB_manage_product.jsp' class='button'>Back</a></center>

</body>
</html>