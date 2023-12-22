<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check email</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/checkemail.css">
</head>
<body>
	<div class="head">
		<img id="wi" alt="" src="${pageContext.request.contextPath}/media/expenseicon.jpg">
        <h2>Spring Expenses Tracker</h2>
        
    </div>
    <form action="ForgotPassword" method="post">
	    <div class="content">
		    <div class="fgtp">
		    	<h1></h1>
		    	<input type="email" name="email" placeholder="enter your email" required="required"><br>
		    	<center><button type="submit">SIGN UP</button></center><br>
		    </div>
 		</div>
 	</form>
 <div class="foot">
    	<p>2023 Jspiders. All rights reserved.</p>
    </div>
</body>
</html>