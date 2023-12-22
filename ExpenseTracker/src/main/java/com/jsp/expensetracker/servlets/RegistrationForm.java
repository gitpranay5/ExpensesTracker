package com.jsp.expensetracker.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.expensetracker.entity.User;
import com.jsp.expensetracker.service.UserService;
import com.jsp.expensetracker.service.UserServiceImpl;

@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private UserService service = new UserServiceImpl();//upcasting to hide UserServiceImpl properties
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//fetch the data from registration jsp file
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
	
		
		//store the data in the user object
		User user = new User();
		user.setEmail(email);
		user.setFullname(fullname);
		user.setMobile(mobile);
		user.setPassword(password);
		user.setUsername(username);
	
			
		int userid = service.register(user, cpassword);
		
		// Print output on the browser
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");

		if(userid != 0) {
			
			//display accountlogin.jsp file foe successful registration
			RequestDispatcher dispatch = request.getRequestDispatcher("accountlogin.jsp");
			//to complete servlet chaining
			dispatch.include(request, response);
			writer.println("<h3 style='color:green'>Your registration successfull...</h3>");
			writer.print("<h3 style='color:grey'>Your userid = "+userid+"</h3>");
		}
		else {
			//display accountlogin.jsp file foe successful registration
			RequestDispatcher dispatch = request.getRequestDispatcher("registrationform.jsp");
			//to complete servlet chaining
			dispatch.include(request, response);
			writer.println("<center><h3 style='color:red'>please enter valid details....!</h3></center>");
		}
		
	}

}
