<%@page import="com.jsp.expensetracker.entity.User"%>
<%@page import="com.jsp.expensetracker.service.ExpenseServiceImpl"%>
<%@page import="com.jsp.expensetracker.service.ExpenseService"%>
<%@page import="com.jsp.expensetracker.entity.Expense"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Expense page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/updateexpenses.css">
</head>
<body>
	<%
    	int eid = Integer.parseInt(request.getParameter("expenseid"));	
		ExpenseService expenseService = new ExpenseServiceImpl();
		Expense expense = expenseService.findExpenseById(eid);
		User user = (User)session.getAttribute("userInfo");
    %>
<div class="head">
		<img id="wi" alt="" src="${pageContext.request.contextPath}/media/expenseicon.jpg">
        <h2>Spring Expenses Tracker</h2>
       <div class="icons" align="right">
	        <a href="homepage.jsp" target=""><img id="mic" alt="" src="${pageContext.request.contextPath}/media/homeicon.png"></a>
	        <a href="#" target=""><img id="sic" alt="" src="${pageContext.request.contextPath}/media/acseticon.png"></a>
       </div>
    </div>
    <div class="content">
    	
    		<div class="main">
		          <form action="UpdateExpense?eid=<%=expense.getExpenseid()%>" method="get">
		          		<br>
				            <h3 align="center">Update Expenses</h3>
				    
				            <input type="text" id="dt" placeholder="Ammount" name="amount" value="<%=expense.getAmount() %>" >
				            <input type="date" id="dt" name="date" value="<%=expense.getDate() %>">
				            <input type="text" id="dt" placeholder="Catagory" name="category" value="<%=expense.getCategory() %>">
				            <textarea rows="" cols="" name="description" ><%=expense.getDescription()%></textarea>
				   			<br>
				   		
				    		<center><button type="submit">Update</button></center><br>
				           	
		          </form>
           	</div>
     
    </div>
    <div class="foot">
    	<p>2023 Jspiders. All rights reserved.</p>
    </div>
</body>
</html>