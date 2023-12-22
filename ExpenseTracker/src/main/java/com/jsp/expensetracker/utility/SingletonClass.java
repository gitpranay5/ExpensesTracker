package com.jsp.expensetracker.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//the class for which programmer can create only one object
public class SingletonClass {

	private static SingletonClass sc;
	
	//to establish the connection 
	private Connection connect;
	
	private SingletonClass() {
		
	}
	
	public static SingletonClass getSingletonClassObject() {
		if(sc==null) {
			sc = new SingletonClass();
			System.out.println("Singleton object created...");
			return sc;
		}
		return sc;
	}
	
	
	//connection method 
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/expensetracker51?user=root&password=12345";
		if(connect == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connect = DriverManager.getConnection(url);
				System.out.println("Connection Established...");
				return connect;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connect;
	}
	
	
}
