package com.jsp.expensetracker.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jsp.expensetracker.entity.Expense;
import com.jsp.expensetracker.utility.SingletonClass;

public class ExpenseDaoImpl implements ExpenseDao {
	
	private Connection connect = SingletonClass.getSingletonClassObject().getConnection();
	//create platform 
	private PreparedStatement pstm;

	@Override
	public int addExpense(Expense expense, int userid) throws Exception {
		
		String query = "insert into expenses(amount,category,description,date,userid) values(?,?,?,?,?)";
		pstm = connect.prepareStatement(query);
		pstm.setDouble(1,expense.getAmount());
		pstm.setString(2,expense.getCategory());
		pstm.setString(3,expense.getDescription());
		pstm.setDate(4,expense.getDate());
		pstm.setInt(5,userid);
		
		int status = pstm.executeUpdate();
		
		if(status != 0) {
			String selectQuery = "select Last_Insert_Id()";
			pstm = connect.prepareStatement(selectQuery);
			
			ResultSet rs = pstm.executeQuery();
			if(rs.isBeforeFirst()) {
				rs.next();
				int expenseId = rs.getInt(1);
				return expenseId;
			}
		}
		return 0;
	}

	@Override
	public List<Expense> viewExpenses(int userid) throws Exception {
		
		String query = "select * from expenses where userid=?";
		pstm = connect.prepareStatement(query);
		pstm.setInt(1, userid);
		ResultSet rs = pstm.executeQuery();
		
		//creating object for list 
		List<Expense> expenseList = new ArrayList<Expense>();
		if(rs.isBeforeFirst()) {
			while(rs.next()) {
				//retrieve the data from db 
				//store the data inside the expense object
				Expense expense = new Expense();
				expense.setAmount(rs.getDouble("amount"));
				expense.setDescription(rs.getString("description"));
				expense.setDate(rs.getDate("date"));
				expense.setCategory(rs.getString("category"));
				expense.setExpenseid(rs.getInt("expenseid"));
				
				//add expense object inlist object
				expenseList.add(expense);
				
			}
			//System.out.println("expense added succesfully...");
			return expenseList;
		}
		return null;
	}

	@Override
	public int deleteExpenseById(int expenseid) throws Exception {
		
		//delete query to delete the expense from expenses table
		String query = "delete from expenses where expenseid = ?";
		pstm = connect.prepareStatement(query);
		pstm.setInt(1, expenseid);
		int status = pstm.executeUpdate();
		return status;
	}

	@Override
	public Expense findExpenseById(int expenseid) throws Exception {
		
		String query = "select * from expenses where expenseid =?";
		pstm = connect.prepareStatement(query);
		pstm.setInt(1, expenseid);
		ResultSet rs =pstm.executeQuery();
		if(rs.isBeforeFirst()) {
			rs.next();
			Expense expense = new Expense();
			expense.setAmount(rs.getDouble("amount"));
			expense.setDescription(rs.getString("description"));
			expense.setDate(rs.getDate("date"));
			expense.setCategory(rs.getString("category"));
			expense.setExpenseid(rs.getInt("expenseid"));
			return expense;
			
		}
		return null;
	}

	@Override
	public int updateExpenses(Expense expense, int expenseid) throws Exception {
		String query = "update expenses set amount=?,description=?,category=?,date=? where expenseid=?";
		pstm = connect.prepareStatement(query);
		pstm.setDouble(1, expense.getAmount());
		pstm.setString(2, expense.getDescription());
		pstm.setString(3, expense.getCategory());
		pstm.setDate(4, expense.getDate());
		pstm.setInt(5, expenseid);
		
		int status = pstm.executeUpdate();
		return status;
	}

	@Override
	public List<Expense> totalExpenseList(int userid, Date start, Date end) throws Exception {
		String query = "select * from expenses where date between ? and ?"
				+ " and userid = ?";
		pstm = connect.prepareStatement(query);
		pstm.setDate(1, start);
		pstm.setDate(2, end);
		pstm.setInt(3, userid);
		ResultSet rs = pstm.executeQuery();
		List<Expense> expenseList = new ArrayList<Expense>();
		if(rs.isBeforeFirst()) {
			while(rs.next()) {
				Expense expense = new Expense();
				expense.setAmount(rs.getDouble("amount"));
				expense.setCategory(rs.getString("category"));
				expense.setDate(rs.getDate("date"));
				expense.setDescription(rs.getString("description"));
				//add expenseId
				expense.setExpenseid(rs.getInt("expenseid"));
				expenseList.add(expense);
			}
			return expenseList;
		}
		return null;
	}

}
