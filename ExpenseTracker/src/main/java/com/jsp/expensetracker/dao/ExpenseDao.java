package com.jsp.expensetracker.dao;

import java.sql.Date;
import java.util.List;

import com.jsp.expensetracker.entity.Expense;

//add database operation on expense table
public interface ExpenseDao {
	
	int addExpense(Expense expense,int userid) throws Exception;
	
	List<Expense> viewExpenses(int userid) throws Exception;
	
	int deleteExpenseById(int expenseid) throws Exception;
	
	Expense findExpenseById(int expenseid) throws Exception;
	
	int updateExpenses (Expense expense, int expenseid) throws Exception;
	
	List<Expense> totalExpenseList(int userid, Date start, Date end) throws Exception;

}
