package com.advsdc.group4.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
public class DatabaseConnection {
	 private static Connection con = null;
 	
	    public Connection getConnection()
	    {
	    	String url = DBConfiguration.getUrl(); 
	        String user = DBConfiguration.getUserName(); 
	        String pass = DBConfiguration.getPassword(); 
	    	
	        try {
	        	System.out.println("check:"+url);
	            Class.forName(DBConfiguration.getDriver()).getClass(); 
	            con = DriverManager.getConnection(url, user, pass); 
	        } 
	        catch (ClassNotFoundException | SQLException e) { 

	            System.out.println("DbConnect:"+e);
	        	e.printStackTrace();
       }
	        return con; 
    }

}
