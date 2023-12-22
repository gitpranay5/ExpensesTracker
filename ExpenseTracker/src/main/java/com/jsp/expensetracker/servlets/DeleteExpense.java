package com.jsp.expensetracker.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expensetracker.entity.User;
import com.jsp.expensetracker.service.ExpenseService;
import com.jsp.expensetracker.service.ExpenseServiceImpl;

/**
 * Servlet implementation class DeleteExpense
 */
@WebServlet("/DeleteExpense")
public class DeleteExpense extends HttpServlet {
		
	private ExpenseService service = new ExpenseServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetch data from URL
		 String temp = request.getParameter("expenseid");
		 int expenseid = Integer.parseInt(temp);
		 
		 int status = service.deleteExpense(expenseid);
		 if(status != 0) {
			 HttpSession session = request.getSession();
			 User user = (User)session.getAttribute("userinfo");
			 request.setAttribute("list", service.viewExpense(user.getUserid()));
			 
			 RequestDispatcher dispatch = request.getRequestDispatcher("viewexpenses.jsp");
			 dispatch.include(request, response);
		 }
	}
}
