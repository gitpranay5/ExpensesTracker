package com.jsp.expensetracker.service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.jsp.expensetracker.dao.ExpenseDao;
import com.jsp.expensetracker.dao.ExpenseDaoImpl;
import com.jsp.expensetracker.entity.Expense;

public class ExpenseServiceImpl implements ExpenseService{
	
	private ExpenseDao expensedao = new ExpenseDaoImpl();
		
		@Override
		public int addExpense(Expense expense, int userid) {
			
			try {
				return expensedao.addExpense(expense, userid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}

		@Override
		public List<Expense> viewExpense(int userid) {
			
			try {
				return expensedao.viewExpenses(userid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public int deleteExpense(int expenseid) {
			
			try {
				return expensedao.deleteExpenseById(expenseid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}

		@Override
		public Expense findExpenseById(int expenseid) {
			try {
				return expensedao.findExpenseById(expenseid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public int updateExpenses(Expense expense, int expenseid) {
			try {
				return expensedao.updateExpenses(expense, expenseid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}

		@Override
		public List<Expense> totalExpenseList(int userid, Date start, Date end) {
			try {
				return expensedao.totalExpenseList(userid, start, end);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public List<Expense> filterExpenseByCategory(String category, int userid) {
			try {
				return expensedao.viewExpenses(userid).stream().filter(t -> t.getCategory().equals(category))
						.collect(Collectors.toList());
			} catch (Exception e) {

				e.printStackTrace();
			}
			return null;
		}

		@Override
		public List<Expense> filterExpenseByAmountRange(int start, int end, int userid) {
			try {
				return expensedao.viewExpenses(userid).stream().filter(t -> t.getAmount() >= start && t.getAmount() <= end)
						.collect(Collectors.toList());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

}
