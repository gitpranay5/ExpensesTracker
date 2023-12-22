<%@page import="com.jsp.expensetracker.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/filterexpenses.css">
</head>
<body>
	<%
		User user = (User)session.getAttribute("userinfo");
	%>
	<div class="head">
		<img id="wi" alt="" src="media/expenseicon.jpg">
        <h2>Spring Expenses Tracker</h2>
       <div class="icons" align="right">
	        <a href="#" target=""><img id="mic" alt="" src="media/homeicon.png"></a>
	        <a href="#" target=""><img id="sic" alt="" src="media/acseticon.png"></a>
       </div>
    </div>
    <div class="content">
        <div class="page">
          <form action="../" method="post">
            <h3 align="center">Filter Expenses</h3><br>
            
    <center><label for="dt" >Select Date</label> </center><br>
            <input type="date" id="dt" required="required">
            
    <center><label for="ct">Select Category</label></center><br>
            <input type="text" id="ct" required="required">
            
    <center><label for="at">Select Category</label></center><br>
            <input type="text" id="at" required="required">
           
            <center><button type="submit">submit</button></center><br>
           	
           </form>
        </div>
    </div>
    <div class="foot">
    	<p>&copy; 2023 Jspiders. All rights reserved.</p>
    </div>
</body>
</html>