<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset password page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/forgotpassword.css">
</head>
<body>
	<div class="head">
		<img id="wi" alt="" src="${pageContext.request.contextPath}/media/expenseicon.jpg">
        <h2>Spring Expenses Tracker</h2>
        
    </div>
    <form action="" method="post">
	    <div class="content">
		    <div class="fgtp">
		    	<h1></h1>
		    	<input type="password" name="newpassword" placeholder="New Password" id="myInput">
		    	<span id="spn1"> <input type="checkbox" onclick="myFunction()" id="checkbox"><span id="spn2">Show Password</span></span><br>
		    	<input type="text" name="newcpassword" placeholder="Confirm New Password"><br>
		    	<center><button type="submit">SIGN UP</button></center><br>
		    </div>
	    <div class="text">
	    	<p>Expenses Tracker Simply your personal reimbursement management. <br><br>
	    	Expense Tracker is used by user's to record their daily routine expenses in a digital and hassle-free way
	    	 as opposed to the convention manual documentation of expenses.</p>
	    </div>
    
 	</div>
 </form>
 <div class="foot">
    	<p>2023 Jspiders. All rights reserved.</p>
    </div>
 <script type="text/javascript">
 function myFunction() {
	  var x = document.getElementById("myInput");
	  if (x.type === "password") {
	    x.type = "text";
	  } else {
	    x.type = "password";
	  }
	}
 </script>
</body>
</html>