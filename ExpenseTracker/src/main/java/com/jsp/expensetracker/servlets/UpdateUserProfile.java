package com.jsp.expensetracker.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jsp.expensetracker.entity.User;
import com.jsp.expensetracker.service.UserService;
import com.jsp.expensetracker.service.UserServiceImpl;


@WebServlet("/UpdateUserProfile")
@MultipartConfig(maxFileSize = 16177215)

public class UpdateUserProfile extends HttpServlet {
	
	UserService userService = new UserServiceImpl();	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setUsername(request.getParameter("username"));
		user.setFullname(request.getParameter("fullname"));
		user.setMobile(request.getParameter("mobile"));
		user.setPassword(request.getParameter("password"));
		user.setUserid(Integer.parseInt(request.getParameter("id")));
		//to get Image Data
		Part part = request.getPart("imageFile");
		System.out.println(part.getName());
		System.out.println(part.getSize());
		System.out.println(part.getContentType());
		
		InputStream is = part.getInputStream();
		
		int status = userService.updateProfile(user, is);
		System.out.println(status);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
		dispatcher.include(request, response);
	}

}
