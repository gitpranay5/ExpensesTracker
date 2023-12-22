package com.jsp.expensetracker.service;

import java.io.InputStream;

import com.jsp.expensetracker.dao.UserDao;
import com.jsp.expensetracker.dao.UserDaoImpl;
import com.jsp.expensetracker.entity.User;

public class UserServiceImpl implements UserService {
	private UserDao userdao = new UserDaoImpl();
	private int userid;
	@Override
	public int register(User user, String cpassword) {
		
		if(user.getPassword().equals(cpassword)) {
			try {
				return userid = userdao.register(user);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	return userid;
	}
	@Override
	public User login(String username, String password) {
		try {
			return userdao.login(username, password);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String forgotPassword(String email) {
		// TODO Auto-generated method stub
		/*
		 * call the forgotpassword method- UserDao interface
		 * handle exception
		 * return respective data
		 */
		try {
			return userdao.forgotPassword(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public User findUserById(int id) {
		try {
			return userdao.findUserById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int updateProfile(User user, InputStream is) {
		try {
			return userdao.updateUserProfile(user, is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public byte[] getUserProfileImage(int userid) {
		try {
			return userdao.getUserProfileImage(userid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
