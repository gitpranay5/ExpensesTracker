<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>account creation page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/registerpage.css">
</head>
<body>
	<div class="head">
		<img id="wi" alt="" src="${pageContext.request.contextPath}/media/expenseicon.jpg">
        <h2>Spring Expenses Tracker</h2>
        
    </div>
    <div class="content">
    	<img alt="" src="${pageContext.request.contextPath}/media/signup.gif">
        <div class="page">
          <form action="RegistrationForm" method="post" id="register">
            <h3 align="center">new registration</h3>
            
            <input type="text" placeholder="enter your username" name="username" required="required">
            <input type="text" placeholder="enter your fullname" name="fullname" required="required">
            <input type="email" placeholder="enter your email" name="email" required="required">
            <input type="text" placeholder="enter your mobile" pattern="[6-9]{1}[0-9]{9}" name="mobile" required="required">
            <input type="password" placeholder="enter your password" name ="password" required="required">
            <input type="password" placeholder="re-enter your password" name ="cpassword" required="required">
            
            <br>
            <center><button type="submit">SIGN UP</button></center><br>
           	<center><span>already have an account click here : <a href="accountlogin.jsp">Log in</a>  </span></center>
           </form>
        </div>
    	
    </div>
    
    <div class="foot">
    	<p>2023 Jspiders. All rights reserved.</p>
    </div>
	<!-- JS -->
	 <script>
		window.addEventListener("beforeunload", function (event) {
			// Reset the form when the user leaves the page
			document.getElementById("register").reset();
		});
	</script>
</body>
</html>