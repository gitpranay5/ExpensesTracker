<%@page import="com.jsp.expensetracker.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Expenses</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/addexpenses.css">
</head>

<body>
<div class="head">
		<img id="wi" alt="" src="media/expenseicon.jpg">
        <h2>Spring Expenses Tracker</h2>
       <div class="icons" align="right">
	        <a href="homepage.jsp" target=""><img id="mic" alt="" src="media/homeicon.png"></a>
	        <a href="#" target=""><img id="sic" alt="" src="media/acseticon.png"></a>
       </div>
    </div>
    <div class="content">
    	<%
    	User user = (User)session.getAttribute("userinfo");
    	%>
        <div class="page">
        	<div class="gif">
    			
    		</div>
    		<div class="main">
		          <form action="AddExpense" method="get" id="add">
		          		<br>
				            <h3 align="center">Add Expenses</h3>
				    
				            <input type="text" id="dt" placeholder="Ammount" required="required" name="amount">
				            <input type="date" id="dt" required="required" name="date">
				            <input type="text" id="dt" placeholder="Catagory" required="required" name="category">
				            <textarea rows="" cols="" name="description"></textarea>
				   			<br>
				   		
				    <center><button type="submit">Add &#43;</button></center><br>
				           	
		          </form>
		    <%
            	String message = (String)request.getAttribute("msg");
            	if(message != null){
            %>
            	<h2 style="color:red;"><%= message%></h2>
            <%
            	}
            %>  
           	</div>
        </div>
    </div>
    <div class="foot">
    	<p>&copy; 2023 Jspiders. All rights reserved.</p>
    </div>
     <script>
		window.addEventListener("beforeunload", function (event) {
			//Reset the form when the user leaves the page
			document.getElementById("add").reset();
		});
	</script>
</body>
</html>