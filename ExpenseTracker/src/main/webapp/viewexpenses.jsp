
<%@page import="com.jsp.expensetracker.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.expensetracker.entity.Expense"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Expenses</title>
<link rel="stylesheet" href="css/viewexpenses.css">
</head>
<body>
	<%
       User user = (User)session.getAttribute("userInfo");
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
   
    	<table cellpadding="20px" >
    	
    	<thead>
    	<tr>
    		<th colspan="6" style="font-size: 20px;border:0px;">List of Expenses</th>
    	</tr>
    		<tr style="font-size: 17px; color:gray;">
    			<th>Sr.no</th>
    			<th>Date</th>
    			<th>Amount</th>
    			<th>Category</th>
    			<th>Description</th>
    			<th>Action</th>
    		</tr>
    	<tbody>
    			
    	 <%
    	 
		    //to retrieve data - transferred from servlet class
		    
		    List<Expense> listofExpense = (List<Expense>)request.getAttribute("list");
		    
    		if(listofExpense!=null && !listofExpense.isEmpty()){
    			int a=0;
    			for(Expense e : listofExpense){
		%>
			<tr>
				<th><%=++a %></th>
				<td><%=e.getDate() %></td>
				<td><%=e.getAmount() %></td>
				<td><%=e.getCategory() %></td>
				<td><%=e.getDescription() %></td>
				<td>
				
					<a href="updateexpense.jsp?expenseid=<%=e.getExpenseid()%>">
						<button style="background-color: rgba(255,30,0,0.9);box-shadow: 0 0 5px red;">Update</button></a>
					
					<span>&nbsp;</span>
					<a href="DeleteExpense?expenseid=<%=e.getExpenseid()%>">
						<button style="background-color: rgba(30,255,0,0.9);box-shadow: 0 0 5px green;">Delete</button></a>
				</td>
			</tr>
			<%
    			}
    		}
    		else{
    		%>
    		<h3 style="color:red">No Record Found</h3>
    		<%	
    		}
    		if(request.getAttribute("sum") != null){
              	%>
              <tr>
              	<th colspan="6" style="text-align: center;">
              		Total = <%= request.getAttribute("sum")%>
              	</th>
              </tr>
              <%
              			}
              		%>
            </tbody>
				
	  </table>
	  
    </div>
    <div class="foot">
    	<p>&copy; 2023 Jspiders. All rights reserved.</p>
    </div>
  
</body>
</html>