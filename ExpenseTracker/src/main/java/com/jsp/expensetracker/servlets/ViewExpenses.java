package com.jsp.expensetracker.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expensetracker.entity.Expense;
import com.jsp.expensetracker.entity.User;
import com.jsp.expensetracker.service.ExpenseService;
import com.jsp.expensetracker.service.ExpenseServiceImpl;

/**
 * Servlet implementation class ViewExpenses
 */
@WebServlet("/ViewExpenses")
public class ViewExpenses extends HttpServlet {
	private ExpenseService expenseService = new ExpenseServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userinfo");
		
		List<Expense> listofExpense = expenseService.viewExpense(user.getUserid());
		request.setAttribute("list", listofExpense);
		RequestDispatcher dispatch = request.getRequestDispatcher("viewexpenses.jsp");
		dispatch.include(request, response);
		
	}

	
}
