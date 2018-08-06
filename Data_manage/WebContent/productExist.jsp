<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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
<title>Confirm Page</title>
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
		.old{
		float:left;
		padding-left: 200px;
	}
	.new{
		float:right;
		padding-right: 200px;
	}
</style>

</head>
<body bgcolor = #B5C064>
 <form action="DBServlet" method="POST">
    <h1 class = title>Product Already Exist!</h1>
    <div class = "old">
    <center><h2>New Product</h2></center>
    		<h4 class = "others">Name:   
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
    </div>
    <div class = "new">
    	<center><h2>Existing Product</h2></center>
    		 <h4 class = "others">Name:   
    		   ${existingone.getName()}</h4>
    		<h4 class = "others">ID:   
    		   ${existingone.getID()} </h4> 
    		<h4 class = "others">Number:   
    		   ${existingone.getCount()}</h4>
    		 <h4 class = "others">Category:   
    		   ${existingone.getCategory()}</h4>
    		 <h4 class = "others">Price:   
    		   ${existingone.getPrice()} </h4>
    		 <h4 class = "others">Cost:  
    			${existingone.getCost()} </h4>
    		 <h4 class = "others">Expiration_date:   
    		 ${existingone.getExpiration()} </h4>
    	 	<h4 class = "others">Provider:   
    		${existingone.getSource()} </h4>
    		<h4 class = "others">Provider Contact:   
    		${existingone.getSource_contact()} </h4>
    		
    	<center><button id = "the_only_button" class='button' name = "the_only_button" value = "merge_product" type = "submit"> Merge </button></center>
    	<center><h4>(Information will be base on the exciting product)</h4></center>
    </div>
</form>
    

</body>
</html>