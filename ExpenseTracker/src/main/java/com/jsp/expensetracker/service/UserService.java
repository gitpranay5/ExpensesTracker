package com.jsp.expensetracker.service;

import java.io.InputStream;
import com.jsp.expensetracker.entity.User;

public interface UserService {
	
	int register(User user, String cpassword);
	
	User login(String username,String password);
	
	String forgotPassword(String email);
	
	User findUserById(int id);
	
	int updateProfile(User user, InputStream is);
	
	byte[] getUserProfileImage(int userid);
}
