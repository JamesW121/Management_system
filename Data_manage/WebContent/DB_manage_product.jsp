<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/28721/5b597698f629d9117cc357a7.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/40719/5b5a7ddbf629d9117cc35810.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/32471/5b5a9320f629db117c8db747.css' rel='stylesheet' type='text/css' />
<link href='http://cdn.webfont.youziku.com/webfonts/nomal/121256/47725/5b5a93a0f629db117c8db748.css' rel='stylesheet' type='text/css' />



<title>Data Management System</title>

<style>
body {
    margin: 0;
    background-color: #B5C064;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    padding-top: 15%;
    width: 18%;
    background-color: #B1C043;
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
    background-color: #96A526;
    color: white;
}

li a:hover:not(.active) {
    background-color: #F6FFB2;
    color: black;
}

.home_title{
	margin-left:20%;
	/*padding-top:20%;*/
	font-family:'AgencyFB';
	font-size: 35px;
	text-align: center;
}


.ull {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

.li_2 {
    display:inline;
}


		#btns
        {
            margin: 5px;
    
        }
         
        #ctn
        {
            margin: 12px;
            width: 400px;
            height: 360px;
            position: relative;    
            text-align: center;       
        }
        div.holder
        {
            width: 400px;
            height: 360px;
            position: absolute;
            top: 0;
            left: 0;
            padding-top: 30px;
            text-align: center;
        }
         
        #d1
        {
            margin-left:78%;
        }
         
        #d2
        {
            margin-left:78%;
        }
         
        #d3
        {
            margin-left:78%;
        }
         
        .btms{
        	border:0;
        	background-color:#96A526; 
        	font-family:'DimWitGauche';
        	font-size:30px;
        	padding-left: 100px;
        	padding-right:100px;
        	text-align: center;
        }
        
       .ipt{
		font-size:20px;
		height:1em;
		border-radius:10px;
		border:1px solid #c8cccf;
		color:#96A526;
		display:block;
		text-align:center;
	}
	
	.other_text{
	font-family:'ScrawnyKids';
	font-size:20px;
	text-align:left;
	}
	
.button {
    border-radius:10px;
    color: white;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s;
    transition-duration: 0.4s;
    cursor: pointer;
    border:none;
	}
	.button1 {
    background-color: white; 
    color: black; 
	}
	.button1:hover {
    background-color: #96A526;
    color: white;
	}
</style>

<title>Data Management System</title>
</head>
<body onload="show(1);">
	<ul>
		<li><a href="DB_manage.jsp">Home</a></li>
		<li><a href="DB_manage_emp.jsp">Employee</a></li>
		<li><a class="active" href="DB_manage_product.jsp">Product</a></li>
		<li><a href="DB_manage_order.jsp">Order</a></li>
		<li><a href="DB_manage_member.jsp">Membership</a></li>
	</ul>

<br>

<div class = "home_title">
<!-- 
	Employee
<br>
-->
<div id="btns">
        <input id="btn1" type="button" onclick="show(1);" value="add" class = "btms" />
        <input id="btn2" type="button" onclick="show(2);" value="Product News" class = "btms"  />
        <input id="btn3" type="button" onclick="show(3);" value="search" class = "btms"/>
    </div>
 
    <div id="ctn">
<div id="d1" class="holder">
  <form action="DBServlet" method="POST" id = "signup">
  
<div class= "other_text" style="float:left" >Name:</div> 
	<div><input id = "Name_product_add" class = "ipt" type = "text" name = "Name_product_add" required="required" style="float:right"></div>
	
	<br>
	
	<div class= "other_text" style="float:left">ID:</div>
	<div align="center"><input id = "ID_product_add" class = "ipt" type="text" name="ID_product_add" required="required" style="float:right"></div>
	
	<br>
	
	<div class= "other_text" style="float:left" >Category: </div>
	<div align="center"><input id = "Category_product_add" class = "ipt" type="text" name="Category_product_add" required="required" style="float:right"></div>
		
	<br>
	
	<div class= "other_text" style="float:left" >Price: </div>
	<div align="center"><input id = "Price_product_add" class = "ipt" type="text" name="Price_product_add" required="required" style="float:right"></div>
		
	<br>
	
	<div class= "other_text" style="float:left" >Cost: </div>
	<div align="center"><input id = "Cost_product_add" class = "ipt" type="text" name="Cost_product_add" required="required" style="float:right"></div>
		
	<br>
	
	<div class= "other_text" style="float:left">Count: </div>
	<div align="center"><input id = "Count_product_add" class = "ipt" type="text" name="Count_product_add" required="required" style="float:right"></div>
	
	<br>
	
	<div class= "other_text" style="float:left">Expiration-date: </div>
	<div align="center"><input id = "Expiration_product_add" class = "ipt" type="date" name="Expiration_product_add" required="required" style="float:right"></div>
	
	<br>
	<div class= "other_text" style="float:left">Source: </div>
	<div align="center"><input id = "Source_product_add" class = "ipt" type="text" name="Source_product_add" required="required" style="float:right"></div>
	
	<br>
	<div class= "other_text" style="float:left">Source-contact: </div>
	<div align="center"><input id = "Contact_product_add" class = "ipt" type="text" name="Contact_product_add" required="required" style="float:right"></div>
	
	<br>
	
	<div align="center">
	<button id = "product_add" class="button button1" name = "the_only_button" type="submit" value="product_add">
	Add to Database
	</button>
	</div>
	<br><br><br><br><br><br>
</form>

</div>
        <div id="d2" class="holder">
        
<form action="DBServlet" method="POST" id = "signup">

	<div align="center">
	<button id = "News" class="button button1" name = "the_only_button" type="submit" value="News">
	Process
	</button>
	</div>
	<br><br><br><br><br><br>
</form>

        </div>
        <div id="d3" class="holder">
  		         <form action="DBServlet" method="POST" id = "signup">
  
<div class= "other_text" style="float:left" >Name:</div> 
	<div><input id = "Name_search_product" class = "ipt" type = "text" name = "Name_search_product" style="float:right"></div>
	
	<br>
	
	<div class= "other_text" style="float:left">ID:</div>
	<div align="center"><input id = "ID_search_product" class = "ipt" type="text" name="ID_search_product" style="float:right"></div>
	
	<br>
	
	<div class= "other_text" style="float:left" >Category: </div>
	<div align="center"><input id = "Category_search_product" class = "ipt" type="text" name="Category_search_product" style="float:right"></div>
		
	<br>
	
	<div class= "other_text" style="float:left" >Price: </div>
	<div align="center"><input id = "Price_search_product" class = "ipt" type="text" name="Price_search_product" style="float:right"></div>
		
	<br>
	
	<div class= "other_text" style="float:left" >Cost: </div>
	<div align="center"><input id = "Cost_search_product" class = "ipt" type="text" name="Cost_search_product" style="float:right"></div>
		
	<br>
	
	<div class= "other_text" style="float:left">Count: </div>
	<div align="center"><input id = "Count_search_product" class = "ipt" type="text" name="Count_search_product" style="float:right"></div>
	
	<br>
	
	<div class= "other_text" style="float:left">Expiration-date: </div>
	<div align="center"><input id = "Expiration_search_product" class = "ipt" type="date" name="Expiration_search_product" style="float:right"></div>
	
	<br>
	<div class= "other_text" style="float:left">Source: </div>
	<div align="center"><input id = "Source_search_product" class = "ipt" type="text" name="Source_search_product" style="float:right"></div>
	
	<br>
	<div class= "other_text" style="float:left">Source-contact: </div>
	<div align="center"><input id = "Contact_search_product" class = "ipt" type="text" name="Contact_search_product" style="float:right"></div>
	
	<br>
	
	<div align="center">
	<button id = "Search_product" class="button button1" name = "the_only_button" type="submit" value="Search_product">
	Search
	</button>
	</div>
	<br><br><br><br><br><br>
</form>

        </div>
    </div>
 </div>


</body>
</html>

    <script type="text/javascript">
        function show(num)
        {
            for(var i=1; i<=3; i++)
            {
                document.getElementById("d"+i).style.display="none";
            }
            document.getElementById("d"+num).style.display="block";
            if(num == 1){
            	document.getElementById("btn1").style.backgroundColor ="#96A526";
            	document.getElementById("btn2").style.backgroundColor ="#CCDC55";
            	document.getElementById("btn3").style.backgroundColor ="#CCDC55";
            	
            	document.getElementById("btn1").style.color = "white";
            	document.getElementById("btn2").style.color = "black";
            	document.getElementById("btn3").style.color = "black";
            }
            else if(num == 2){
            	document.getElementById("btn1").style.backgroundColor ="#CCDC55";
            	document.getElementById("btn2").style.backgroundColor ="#96A526";
            	document.getElementById("btn3").style.backgroundColor ="#CCDC55";
            	
            	document.getElementById("btn2").style.color = "white";
            	document.getElementById("btn1").style.color = "black";
            	document.getElementById("btn3").style.color = "black";
            }
            else if(num ==3){
            	document.getElementById("btn1").style.backgroundColor ="#CCDC55";
            	document.getElementById("btn2").style.backgroundColor ="#CCDC55";
            	document.getElementById("btn3").style.backgroundColor ="#96A526";
            	
            	document.getElementById("btn3").style.color = "white";
            	document.getElementById("btn2").style.color = "black";
            	document.getElementById("btn1").style.color = "black";
            }
        }
       
    </script>