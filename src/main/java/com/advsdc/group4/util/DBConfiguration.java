package com.advsdc.group4.util;

public class DBConfiguration {
	
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://(host=db-5308.cs.dal.ca,port=3306)/CSCI5308_4_DEVINT?serverTimezone=AST";
	private static String username = "CSCI5308_4_DEVINT_USER";
	private static String password = "CSCI5308_4_DEVINT_4202";
	
	public DBConfiguration() {
	}
	
	public static String getUrl() {
		return url;
	}
	
	public static String getDriver() {
		return driver;
	}
	
	public static String getUserName() {
		return username;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static void setDriver(String driver) {
		DBConfiguration.driver = driver;
	}

	public static void setUrl(String url) {
		DBConfiguration.url = url;
	}

	public static void setUsername(String username) {
		DBConfiguration.username = username;
	}

	public static void setPassword(String password) {
		DBConfiguration.password = password;
	}
}

