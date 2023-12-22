package com.jsp.expensetracker.servlets;

import java.io.IOException;
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
import com.jsp.expensetracker.entity.User;
import com.jsp.expensetracker.service.ExpenseService;
import com.jsp.expensetracker.service.ExpenseServiceImpl;

/**
 * Servlet implementation class UpdateExpense
 */
@WebServlet("/UpdateExpense")
public class UpdateExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ExpenseService service = new ExpenseServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//fetch expenseid
		//fetch expense information
		//store all expense information in expense obj
		//call updateExpenses method
		//return - display viewexpenses.jsp if 1
		//return - 
		int expenseid = Integer.parseInt(request.getParameter("eid"));
		
		Expense expense = new Expense();
		expense.setAmount(Double.parseDouble(request.getParameter("amount")));
		expense.setDescription(request.getParameter("description"));
		expense.setCategory(request.getParameter("category"));
		expense.setDate(Date.valueOf(request.getParameter("date")));
		
		int status = service.updateExpenses(expense, expenseid);
		if(status!=0) {
			//call the viewexpense method
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("userinfo");
			List<Expense> expenses = service.viewExpense(user.getUserid());
			request.setAttribute("list", expenses);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("viewexpenses.jsp");
			dispatch.include(request, response);
		}
		else {
			request.setAttribute("msg", "please enter valid details...!");
			RequestDispatcher dispatch = request.getRequestDispatcher("updateexpense.jsp");
			dispatch.include(request, response);
		}
	}
}
