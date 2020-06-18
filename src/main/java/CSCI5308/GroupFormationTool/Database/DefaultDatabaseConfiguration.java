package CSCI5308.GroupFormationTool.Database;

public class DefaultDatabaseConfiguration implements IDatabaseConfiguration
{	
	private static final String URL = System.getenv("db_url");
	private static final String USER = System.getenv("db_username");
	private static final String PASSWORD = System.getenv("db_password");

	public String getDatabaseUserName()
	{
		return USER;
	}

	public String getDatabasePassword()
	{
		return PASSWORD;
	}

	public String getDatabaseURL()
	{
		return URL;
	}
}
