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
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/35366/5b612a6ef629d918a894110c.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/46758/5b62ae09f629d80db4bc7ce4.css' rel='stylesheet' type='text/css' />
<style>
	.title{
		font-family:'ACMEExplosive';
		text-align:center;
	}
	.others{
		font-family:'HelveticaNeue';
		text-align:center;
		font-size:20px
	}
	.discount{
		font-family:'HelveticaNeue';
		text-align:center;
		font-size:30px
	}
</style>
<title>Data Management System</title>
</head>
<body bgcolor = #FF9473>
<%	Order the_Order = (Order)session.getAttribute("neworder"); %>
		
    <h1 class = title>New Order Added!</h1>
    		<h4 class = "others" >Order_id:   
    		   ${neworder.getOrder_id()}</h4>
    		<h4 class = "others">Date:   
    		   ${neworder.getDate()} </h4> 
    		<h4 class = "others">Product:   
    		   ${neworder.getGood_name()} </h4>
    		<h4 class = "others">Product_id:   
    		   ${neworder.getGood_id()}</h4>
    		 <h4 class = "others">Status:   
    		   ${neworder.getStatus()}</h4>
    		 <h4 class = "others">Number:   
    		   ${neworder.getNumber()} </h4>
    		 <h4 class = "others">Member_id:  
    			${neworder.getMember_id()} </h4>
    		 <h4 class = "others">Price:   
    		 ${neworder.getPrice()} </h4>
    		 <h2 class = "discount">
	<%		if(the_Order.getMember_id() != 0){
				out.print("You just got 10% off on your order!");
			}
	%>
	</h2>
    <center><a href='DB_manage_order.jsp' class='button'>Back</a></center>
    		          
</body>
</html>