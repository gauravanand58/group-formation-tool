package com.advsdc.group4.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class DatabaseConnectionTest {
	@Test
	public void getConnectionTest() {
		Connection conn = null;
		try {

			conn = DriverManager.getConnection("jdbc:mysql://(host=db-5308.cs.dal.ca,port=3306)/CSCI5308_4_DEVINT?serverTimezone=AST", "CSCI5308_4_DEVINT_USER", "CSCI5308_4_DEVINT_4202");
			assertEquals(conn instanceof Connection,DatabaseConnection.getConnection() instanceof Connection );
		} catch (SQLException e) {
			assertEquals(null, conn);
		}
		
		
	
		
		
		
	}


}
