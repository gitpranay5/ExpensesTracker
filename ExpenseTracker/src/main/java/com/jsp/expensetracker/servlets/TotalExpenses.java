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


@WebServlet("/TotalExpenses")
public class TotalExpenses extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
private ExpenseService service = new ExpenseServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date start = Date.valueOf(request.getParameter("start"));
		Date end = Date.valueOf(request.getParameter("end"));
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userinfo");
		
		List<Expense> totalExpenseList = service.totalExpenseList(user.getUserid(), start, end);
		
		if(totalExpenseList != null) {
			
			request.setAttribute("list", totalExpenseList);
			request.setAttribute("sum", totalExpenseList .stream()
					.mapToDouble(t -> t.getAmount())
					.sum());
			RequestDispatcher dispatch = request.getRequestDispatcher("viewexpenses.jsp");
			dispatch.include(request, response);
		}
		else {
			request.setAttribute("msg", "no records found...");
			RequestDispatcher dispatch = request.getRequestDispatcher("viewexpenses.jsp");
			dispatch.include(request, response);
		}
	}
}
