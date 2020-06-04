package com.advsdc.group4.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	private static Connection con = null;
	
	public static Connection getConnection()
	{
		String url = DBConfiguration.getUrl(); 
		String user = DBConfiguration.getUserName(); 
		String pass = DBConfiguration.getPassword(); 
		
		try {
			if(con == null || !con.isValid(0)) {
			    Class.forName(DBConfiguration.getDriver()).getClass(); 
			    con = DriverManager.getConnection(url, user, pass); 
			}
		} 
		catch (ClassNotFoundException | SQLException e) { 
		
		    System.out.println("DbConnect:"+e);
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection() 
	{
		try {
			con.close();
		} catch (Exception e) {
			con = null;
		}
    } 
}

