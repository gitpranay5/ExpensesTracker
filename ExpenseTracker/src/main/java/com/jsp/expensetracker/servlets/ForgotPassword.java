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

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private UserService service = new UserServiceImpl();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 1.fetch email from forgotpassword jsp file
		 * 2.call forgotpassword() from userservice interface
		 * 3.perform servlet chaining
		 * 4.transfer data
		 */
		
		String email = request.getParameter("email");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String valid =service.forgotPassword(email);
		if(valid!=null) {
			//credentials are valid - show the home page of expense tracker
			//to transfer data
			//request.setAttribute("userinfo", user);
			//request.setAttribute("msg", "login successfully...");
			RequestDispatcher dispatch = request.getRequestDispatcher("forgotpassword.jsp");
			dispatch.include(request, response);
			writer.println(valid);
		}
		else {
			//request.setAttribute("msg", "please enter valid credentials...");
			RequestDispatcher dispatch = request.getRequestDispatcher("checkemail.jsp");
			dispatch.include(request, response);
			writer.println("invalid");
		}
		
	}

}
