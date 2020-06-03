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
 
	    public  static Connection getConnection() 
	    { try { 
        	Class.forName(dbConfiguration.getDriverClassName()).getClass(); 
            con = DriverManager.getConnection(dbConfiguration.getUrl(), dbConfiguration.getUsername(), dbConfiguration.getPassword()); 
        } 
        catch (Exception e) { 
        	con = null;
        	System.out.println("Exception:"+e);
   } 
        return con; 
    } 
	    private DatabaseConnection(DBConfiguration dbConfiguration) {
	    	DatabaseConnection.dbConfiguration = dbConfiguration;
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
