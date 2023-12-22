<%@page import="com.jsp.expensetracker.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/accountlogin.css">
</head>
<body>
	
				<%
					User user = (User)session.getAttribute("userinfo");
					if(user != null){
						response.sendRedirect("homepage.jsp");
					}
					//to retrieve data - transferred from servlet class
					String message = (String)request.getAttribute("msg"); //downcasting
					if (message != null) {
				%>
						<script>
							alert("<%= message%>");
						</script>
				<%
					}
					message = null;
					
					//Reset the form - assignment
				%>
	<div class="head">
		<img id="wi" alt="" src="${pageContext.request.contextPath}/media/expenseicon.jpg">
        <h2>Spring Expenses Tracker</h2>
        
    </div>
  
    <div class = "content" align="center">
        <form action="LoginForm" method="post" id="loginform">
            <div class="box">
            <br>
                <h2>Sign In With</h2>
                <br>
                <div class="innerbox">
                	<div class="links">
	                    <a href="#" id="f"><img src="${pageContext.request.contextPath}/media/facebookicon.png" alt="">Facebook</a><span>&nbsp;
	                     </span>
	                    <a href="#" id="g"><img src="${pageContext.request.contextPath}/media/googleicon.png" alt="">Google</a>
                    </div>
                    <br>
                  
                    <label for="u">Username </label><br>
                    <input type="text" id="u" name="username" required="required">
                    <label for="p">Password </label><br>
                    <input type="password" id="p" name="password" required="required">
                    <input type="submit" value="Login" id="sub" >
                    <br>
                    <br>
                    <a href="checkemail.jsp" id="fp">forgot password ?</a>&nbsp;<a href="registrationform.jsp" id="new">create account</a>
                </div>
                
            </div>
        </form>
       </div>
   
   
    <div class="foot">
    	<p>2023 Jspiders. All rights reserved.</p>
    </div>
    <script>
		window.addEventListener("beforeunload", function (event) {
			// Reset the form when the user leaves the page
			document.getElementById("loginform").reset();
		});
	</script>
</body>
</html>