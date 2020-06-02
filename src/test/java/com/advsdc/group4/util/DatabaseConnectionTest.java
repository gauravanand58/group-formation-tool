package com.advsdc.group4.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.crypto.Data; 

public class DatabaseConnectionTest {
	
	@Test
	public void getConnectionTest() {
		Connection conn = null, expectedConn = null;
		DatabaseConnection databaseConnection = new DatabaseConnection();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://(host=db-5308.cs.dal.ca,port=3306)/CSCI5308_4_DEVINT?serverTimezone=AST", "CSCI5308_4_DEVINT_USER", "CSCI5308_4_DEVINT_4202");
			expectedConn = databaseConnection.getConnection();
			assertEquals(conn instanceof Connection, expectedConn instanceof Connection );
			assertNotNull(conn);
		} catch (SQLException e) {
			assertEquals(null, conn);
		} finally {
			try {
				conn.close();
				expectedConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
