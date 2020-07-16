package CSCI5308.GroupFormationTool.Database;

public class DefaultDatabaseConfiguration implements IDatabaseConfiguration {

	private static final String URL = "jdbc:mysql://(host=db-5308.cs.dal.ca,port=3306)/CSCI5308_4_DEVINT?serverTimezone=AST";
	private static final String USER = "CSCI5308_4_DEVINT_USER";
	private static final String PASSWORD = "CSCI5308_4_DEVINT_4202";

	public String getDatabaseUserName() {
		return USER;
	}

	public String getDatabasePassword() {
		return PASSWORD;
	}

	public String getDatabaseURL() {
		return URL;
	}
}