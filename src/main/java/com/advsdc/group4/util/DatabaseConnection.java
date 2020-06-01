package com.advsdc.group4.util;

import java.sql.Connection; 
import java.sql.DriverManager; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConnection {
	 private static Connection con ; 
	@Autowired
	 static DBConfiguration dbConfiguration ;
 
	    public static Connection getConnection() 
	    { 
	    	
	    	
	        try { 
	        	System.out.println("check:"+dbConfiguration.getPassword());
	        	Class.forName(dbConfiguration.getDriver()).getClass(); 
	            con = DriverManager.getConnection(dbConfiguration.getUrl(), dbConfiguration.getUsername(), dbConfiguration.getPassword()); 
	        } 
	        catch (Exception e) { 

	            con = null;
	        	
       } 
	        return con; 
    } 
	    
	    private DatabaseConnection(DBConfiguration dbConfiguration) {
	    	DatabaseConnection.dbConfiguration = dbConfiguration;
		}

}
