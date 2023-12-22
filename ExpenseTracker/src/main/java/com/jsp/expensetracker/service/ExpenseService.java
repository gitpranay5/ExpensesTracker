package com.jsp.expensetracker.service;

import java.sql.Date;
import java.util.List;

import com.jsp.expensetracker.entity.Expense;

public interface ExpenseService {
	int addExpense(Expense expense,int userid);
	
	List<Expense> viewExpense(int userid);
	
	int deleteExpense(int expenseid);
	
	Expense findExpenseById(int expenseid);
	
	int updateExpenses (Expense expense, int expenseid);
	
	List<Expense> totalExpenseList(int userid, Date start, Date end);
	
	List<Expense> filterExpenseByCategory(String category, int userid);
	
	List<Expense> filterExpenseByAmountRange(int start, int end, int userid);

}
