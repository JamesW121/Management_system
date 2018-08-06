<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/28721/5b597698f629d9117cc357a7.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/40719/5b5a7ddbf629d9117cc35810.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/32471/5b5a9320f629db117c8db747.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/47725/5b5a93a0f629db117c8db748.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/35366/5b612a6ef629d918a894110c.css' rel='stylesheet' type='text/css' />
<style>
	.title{
		font-family:'ACMEExplosive';
		text-align:center;
	}
	.others{
		font-family:'Howard-Light';
		text-align:center;
		font-size:20px
	}
</style>
<title>Data Management System</title>
</head>
<body bgcolor = #B5C064>
    <h1 class = title>New Product Added!</h1>
    		<h4 class = "others" >Name:   
    		   ${newproduct.getName()}</h4>
    		<h4 class = "others">ID:   
    		   ${newproduct.getID()} </h4> 
    		<h4 class = "others">Number:   
    		   ${newproduct.getCount()}</h4>
    		 <h4 class = "others">Category:   
    		   ${newproduct.getCategory()}</h4>
    		 <h4 class = "others">Price:   
    		   ${newproduct.getPrice()} </h4>
    		 <h4 class = "others">Cost:  
    			${newproduct.getCost()} </h4>
    		 <h4 class = "others">Expiration_date:   
    		 ${newproduct.getExpiration()} </h4>
    	 	<h4 class = "others">Provider:   
    		${newproduct.getSource()} </h4>
    		<h4 class = "others">Provider Contact:   
    		${newproduct.getSource_contact()} </h4>

    <center><a href='DB_manage_product.jsp' class='button'>Back</a></center>
    		          
</body>
</html>