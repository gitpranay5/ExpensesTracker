<%@page import="java.util.Base64"%>
<%@page import="com.jsp.expensetracker.service.UserServiceImpl"%>
<%@page import="com.jsp.expensetracker.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jsp.expensetracker.entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page of Candidate</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/homepage.css">
</head>
<body>
  
	<%
		response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Cache-Control", "no-store");
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
		String message = (String)request.getAttribute("msg");
		//User user = (User)request.getAttribute("userinfo");
		User user = (User)session.getAttribute("userinfo");
		System.out.println(user);
		if(user == null){
	%>
		<!-- to display login page -->
		<jsp:forward page="accountlogin.jsp"></jsp:forward>
	 <%
		}
    //to retrieve data - transferred from servlet class
    if(message!=null){
    	%>
    		<script>
    			alert("<%=message%>"+"<%=user.getUserid()%>");
    		</script>
    	<%
    		message=null;
    	}
    	%>
<div class="container">

	    <div class="navbar">
	    <img class="logo" src="${pageContext.request.contextPath}/media/expenseicon.jpg">
        <h2>Spring Expenses Tracker</h2> 
		    <nav>
		    	<ul>
		    		<li><a href="updateprofile.jsp?userid=<%=user.getUserid()%>">update profile</a></li>
		    		<li><a href="Logout">Logout</a></li>
		    		
		    	</ul>
		    	
		    </nav>
	   	 <img class="menu-icon" src="${pageContext.request.contextPath}/media/acseticon.png">
	    </div>
	    <div class="row">
	    	<div class="col">
	    	
	    	
	   
		<%
            	UserService service = new UserServiceImpl();
				byte byteArray[] = service.getUserProfileImage(user.getUserid());
				if(byteArray != null){
					String image = Base64.getEncoder().encodeToString(byteArray);
		%>
				<img id="displayImage" src="data:image/jpg;base64,<%= image%>" width="100" height="100" style="border-radius: 100%">
		<% 
				}
		%>
		
		<%
			if(user != null){
	
		%>
			<h1 style="color: orange;">welcome 	<%=user.getEmail() %></h1>
		<%
    		}
       	%>
				<p>lorem</p>
	    	</div>
	    	
	    	<div class="col">
	    		<div class="card">
	    			<img src="${pageContext.request.contextPath}/media/add_icon.png"> <a href="addexpenses.jsp">Add Expenses</a>
	    		</div>
	    		<div class="card">
	    			<img src="${pageContext.request.contextPath}/media/view_icon.png"><a href="ViewExpenses">View Expenses</a>
	    		</div><br>
	    		<div class="card">
	    			<img src="${pageContext.request.contextPath}/media/filter_icon.png"><a href="filterexpenses.jsp">Filter Expenses</a>
	    		</div>
	    		<div class="card">
	    			<img src="${pageContext.request.contextPath}/media/sum_icon.png"><a href="totalexpenses.jsp">Total Expenses</a>
	    		</div>
	    	</div>

	     </div>
</div>  

</body>
</html>