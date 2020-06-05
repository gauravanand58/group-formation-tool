package com.advsdc.group4.util;

public class DBConfiguration {
	
	private static String driver = "com.mysql.cj.jdbc.Driver";

	private static String url = System.getenv("db_url");
	private static String username = System.getenv("db_username");
	private static String password = System.getenv("db_password");
	
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

