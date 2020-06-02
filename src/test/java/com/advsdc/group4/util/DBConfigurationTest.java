package com.advsdc.group4.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DBConfigurationTest {
//	static DBConfiguration configuration;
//	@BeforeAll
//	public static void getDBConfiguration() {
//		configuration =  new DBConfiguration();
//	}
	@Test
	public void getUrlTest() {
		
		//configuration.setUrl("jdbc:mysql://(host=db-5308.cs.dal.ca,port=3306)/CSCI5308_4_DEVINT?serverTimezone=AST");
		assertEquals("jdbc:mysql://(host=db-5308.cs.dal.ca,port=3306)/CSCI5308_4_DEVINT?serverTimezone=AST", DBConfiguration.getUrl());
	}
	
	@Test
	public void getDriverTest() {
		//configuration.setDriver("com.mysql.jdbc.Driver");
		assertEquals("com.mysql.cj.jdbc.Driver", DBConfiguration.getDriver());
	}
	
	@Test
	public void getUsernameTest() {
		//configuration.setUsername("CSCI5308_4_DEVINT_USER");
		assertEquals("CSCI5308_4_DEVINT_USER", DBConfiguration.getUserName());
	}
	
	@Test
	public void getPasswordTest() {
		//configuration.setPassword("CSCI5308_4_DEVINT_4202");
		assertEquals("CSCI5308_4_DEVINT_4202", DBConfiguration.getPassword());
	}
}
