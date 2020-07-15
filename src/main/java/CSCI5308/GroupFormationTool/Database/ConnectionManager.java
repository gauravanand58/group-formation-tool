package CSCI5308.GroupFormationTool.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.SystemConfig;

public class ConnectionManager {
	private static ConnectionManager uniqueInstance = null;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String dbURL;
	private String dbUserName;
	private String dbPassword;

	public ConnectionManager() {
		IDatabaseConfiguration config = SystemConfig.instance().getDatabaseConfiguration();
		dbURL = config.getDatabaseURL();
		dbUserName = config.getDatabaseUserName();
		dbPassword = config.getDatabasePassword();
		logger.info("URL of database:"+dbURL);
		logger.info("User name of database:"+dbUserName);
	}

	public static ConnectionManager instance() {
		if (null == uniqueInstance) {
			uniqueInstance = new ConnectionManager();
		}
		return uniqueInstance;
	}

	public Connection getDBConnection() throws SQLException {
		return DriverManager.getConnection(dbURL, dbUserName, dbPassword);
	}
}
