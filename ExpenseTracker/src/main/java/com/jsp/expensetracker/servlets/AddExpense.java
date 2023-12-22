package com.jsp.expensetracker.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expensetracker.entity.Expense;
import com.jsp.expensetracker.service.*;
import com.jsp.expensetracker.entity.*;


@WebServlet("/AddExpense")
public class AddExpense extends HttpServlet {
	
	private ExpenseService expenseService = new ExpenseServiceImpl();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetch the data from HTML form and store in expense object
		
		 Expense expense = new Expense();
		 expense.setAmount(Double.parseDouble(request.getParameter("amount")));
		 expense.setDescription(request.getParameter("description"));
		 expense.setCategory(request.getParameter("category"));
		 expense.setDate(Date.valueOf(request.getParameter("date")));
		 
		 //to do get userid of an user, who logged in an application 
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userinfo");
		
		int expenseid = expenseService.addExpense(expense, user.getUserid());
		
		
		//PrintWriter writer = response.getWriter();
		//writer.print("<h1>Expense added sucessfully, Expenseid = "+expenseid+"</h1>");
		if(expenseid != 0) {
			//call viewExpense method--> ExpenseService
			List<Expense> list = expenseService.viewExpense(user.getUserid());
			request.setAttribute("expenselist", list);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("viewexpenses.jsp");
			dispatch.include(request, response);
		}
		else {
			request.setAttribute("msg", "please enter valid details");
			RequestDispatcher dispatch = request.getRequestDispatcher("addexpenses.jsp");
			dispatch.include(request, response);
		}
	
	}
	
}
