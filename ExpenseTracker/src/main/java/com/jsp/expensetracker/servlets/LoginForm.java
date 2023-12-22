package com.jsp.expensetracker.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expensetracker.entity.User;
import com.jsp.expensetracker.service.UserService;
import com.jsp.expensetracker.service.UserServiceImpl;

/**
 * Servlet implementation class LoginForm
 */
@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
	
	private UserService service = new UserServiceImpl();
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetch data from accountlogin.jsp file
		String un = request.getParameter("username");
		String pd = request.getParameter("password");

		
		User user =service.login(un, pd);
		HttpSession session = request.getSession();
		System.out.println(session);
		if(user!=null) {
			
			System.out.println(user);
			//credentials are valid - show the home page of expense tracker
			//to transfer data
			session.setAttribute("userinfo", user);
			
			request.setAttribute("msg", "login successfully...");
			//RequestDispatcher dispatch = request.getRequestDispatcher("homepage.jsp");
			//dispatch.include(request, response);
			response.sendRedirect("homepage.jsp");
			
		}
		else {
			request.setAttribute("msg", "please enter valid credentials...");
			RequestDispatcher dispatch = request.getRequestDispatcher("accountlogin.jsp");
			dispatch.include(request, response);
			
		}

	}

}

