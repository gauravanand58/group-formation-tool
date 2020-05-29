package com.advsdc.group4.Landing.util;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
  
@Component
public class DatabaseConnection {
	 private static Connection con = null;
	  
 	@Autowired
	DBConfiguration configuration;
 
	    public  Connection getConnection() 
	    { 
	    	String url = configuration.getUrl(); 
	        String user = configuration.getUsername(); 
	        String pass = configuration.getPassword(); 
	    	
	        try { 
	        	System.out.println("check:"+url);
	            Class.forName(configuration.getDriver()).getClass(); 
	            con = DriverManager.getConnection(url, user, pass); 
	        } 
	        catch (ClassNotFoundException | SQLException e) { 

	            System.out.println("DbConnect:"+e);
	        	e.printStackTrace();
       } 
	        return con; 
    } 

}
