package com.jsp.expensetracker.dao;

import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Blob;
import org.apache.jasper.tagplugins.jstl.core.Catch;

import com.jsp.expensetracker.entity.User;
import com.jsp.expensetracker.utility.SingletonClass;


public class UserDaoImpl implements UserDao {
	//global declaration
	//estabish connection
	private Connection connect = SingletonClass.getSingletonClassObject().getConnection();
	//create platform 
	private PreparedStatement pstm;
	
	
	
	
	@Override
	public int register(User user) throws Exception {
		//insert query -- to insert data into the user table 
		String insert = "insert into user"
				+ "(username,fullname,email,mobile,password)"
				+ " values(?,?,?,?,?)";
	
		pstm = connect.prepareStatement(insert);
		
		//set values to the placeholders - takes values from user object

		//	String username = user.getUsername();
		//	pstm.setString(1, username);
		
		pstm.setString(1, user.getUsername());
		pstm.setString(2, user.getFullname());
		pstm.setString(3, user.getEmail());
		pstm.setString(4, user.getMobile());
		pstm.setString(5, user.getPassword());
		
		//execute select query
		int status = pstm.executeUpdate();
		System.out.println("Status of insert query = "+ status);
		//retreive userid from DB
		if(status != 0) {
			
			String select = "select userid from user where email=?";
			pstm = connect.prepareStatement(select);
			pstm.setString(1, user.getEmail());
			
			ResultSet rs = pstm.executeQuery();
			//return userid to the console
			 	if(rs.isBeforeFirst()) {
			 		rs.next();
			 		System.out.println("User = "+ rs.getInt("userid"));
			 		return rs.getInt("userid");
			 	}
		}
		return 0;
	}


	@Override
	public User login(String username, String password) throws Exception {
		
		String query = "select * from user where username=? and password=?";
		pstm = connect.prepareStatement(query);
		pstm.setString(1, username);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		
		if(rs.isBeforeFirst()) {
			
			rs.next();
			
			String un = rs.getString("username");
			String email = rs.getString("email");
			String mobile = rs.getString("mobile");
			String fullname = rs.getString("fullname");
			String pswd = rs.getString("password");
			int id = rs.getInt("userid");
			
			User usr = new User();
			usr.setUsername(un);
			usr.setFullname(fullname);
			usr.setEmail(email);
			usr.setMobile(mobile);
			usr.setPassword(pswd);
			usr.setUserid(id);
			 
			return usr;
		
		}
			
			//retrieve data from DB
	
		return null;
	}


	@Override
	public String forgotPassword(String email) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * 1. write the query - select query to fetch the password from db
		 * 2. create platform
		 * 3. assign values to the placeholder
		 * 4. execute select query
		 * 5. return respective data
		 */
		String select = "select password from user where email=?";
		pstm = connect.prepareStatement(select);
		pstm.setString(1, email);
		ResultSet rs = pstm.executeQuery();
		if(rs.isBeforeFirst()) {
			rs.next();
			
			 return rs.getString("password");
		}
		
		return null;
	}


	@Override
	public User findUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		
		String query = "select * from user where userid = ?";
		pstm = connect.prepareStatement(query);
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		
		if(rs.isBeforeFirst()) {
			rs.next();
			User user = new User();
			user.setEmail(rs.getString("email"));
			user.setFullname(rs.getString("fullname"));
			user.setMobile(rs.getString("mobile"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			
			user.setUserid(rs.getInt("userid"));
			return user;
		}
		return null;
	}


	@Override
	public int updateUserProfile(User user, InputStream is) throws Exception {
		String query = "update user set fullname =?, username=?, mobile=?, email=?,password=?, image=? where userid = ?";
			pstm = connect.prepareStatement(query);
			pstm.setString(1, user.getFullname());
			pstm.setString(2, user.getUsername());
			pstm.setString(3, user.getMobile());
			pstm.setString(4, user.getEmail());
			pstm.setString(5, user.getPassword());
			pstm.setBlob(6, is);
			pstm.setInt(7, user.getUserid());
			
			int status = pstm.executeUpdate();
			
			return status;
	}


	@Override
	public byte[] getUserProfileImage(int userid) throws Exception {
		String query = "select * from user where userid = ?";
		pstm = connect.prepareStatement(query);
		pstm.setInt(1, userid);
		
		ResultSet rs = pstm.executeQuery();
		if(rs.isBeforeFirst()) {
			rs.next();
			Blob blob = rs.getBlob("image");
			if(blob != null) {
			byte byteArray[] = blob.getBytes(1, (int)blob.length());
			return byteArray;
			}
		}
		return null;
	}
}


