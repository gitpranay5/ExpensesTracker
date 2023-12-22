package com.jsp.expensetracker.dao;

import java.io.InputStream;

import com.jsp.expensetracker.entity.User;

//all database operations on user table 
//data Access Object

public interface UserDao {
	
	int register(User user) throws Exception; //return id of user after inserting data

	User login(String username,String password) throws Exception;
	
	String forgotPassword(String email) throws Exception;
	
	User findUserById(int id) throws Exception;
	
	int updateUserProfile(User user, InputStream is) throws Exception;
	
	byte[] getUserProfileImage(int userid) throws Exception;
}

