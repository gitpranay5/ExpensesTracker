<%@page import="java.util.Base64"%>
<%@page import="com.jsp.expensetracker.entity.User"%>
<%@page import="com.jsp.expensetracker.service.UserServiceImpl"%>
<%@page import="com.jsp.expensetracker.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Update</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/updateprofile.css">
</head>
<body>
	<%
    	int userid = Integer.parseInt(request.getParameter("userid"));	
		UserService userService = new UserServiceImpl();
		User user = userService.findUserById(userid);
    %>
	<div class="head">
		<img id="wi" alt="" src="media/expenseicon.jpg">
        <h2>Spring Expenses Tracker</h2>
	       <div class="icons" align="right">
		        <a href="homepage.jsp" target=""><img id="mic" alt="" src="media/homeicon.png"></a>
		        <a href="#" target=""><img id="sic" alt="" src="media/acseticon.png"></a>
	       </div>
    </div>
    <div class="content">
	    <div class="profile">
		    <form action="UpdateUserProfile" method="post" enctype="multipart/form-data">
		    	<label>Username :</label> <input type="text" value="<%=user.getUsername()%>" name="username">
		    	<label>Fullname :</label> <input type="text" value="<%=user.getFullname()%>" name="fullname">
		    	<label>Email :</label> <input type="email" value="<%=user.getEmail()%>" name="email">
		    	<label>Mobile :</label> <input type="text" value="<%=user.getMobile()%>" name="mobile">
		    	<label>Password :</label> <input type="password" value="<%=user.getPassword()%>" name="password">
		    	<label>Profile Photo :</label> <input type="file" accept="image/*" name="imageFile">
		    	
		    	<!-- code to display an image if present in db -->
			<%
				byte byteArray[] = userService.getUserProfileImage(userid);
				if(byteArray != null){
					String image = Base64.getEncoder().encodeToString(byteArray);
			%>
				<img id="displayImage" src="data:image/jpg;base64,<%= image%>" width = "200" height="200"
				style="border-radius:100%">
			<% 
				}
				else{
			%>
				<img id="displayImage" width = "200" height="200" style="border-radius:100%; background-image: url('media/homeicon.png'); background-size: 100%">
			<%
				}
			%>
			
		    	<input name="id" value=<%= user.getUserid()%> type="number" hidden>
		    	<button type="submit">update</button>
		    </form>
	    </div>
    </div>
    
</body>
</html>