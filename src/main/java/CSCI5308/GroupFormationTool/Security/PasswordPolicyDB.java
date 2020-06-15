package CSCI5308.GroupFormationTool.Security;

import java.sql.ResultSet;
import java.sql.SQLException;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class PasswordPolicyDB implements IPasswordPolicyPersistance {

	@Override
	public void loadUserPasswordPolicies(PasswordPolicyConfiguration policyConfiguration) {

		CallStoredProcedure proc = null;
		try
		{
			proc = new CallStoredProcedure("spLoadPasswordPolicy()");
			ResultSet results = proc.executeWithResults();
			if (null != results)
			{
				while (results.next())
				{
					policyConfiguration.setMaxLength(results.getInt("maxLen"));
					policyConfiguration.setMinLength(results.getInt("minLen"));
					policyConfiguration.setMinUpperChar(results.getInt("minUpperChar"));
					policyConfiguration.setMinLowerChar(results.getInt("minLowerChar"));
					policyConfiguration.setMinSplChar(results.getInt("minSplChar"));
					policyConfiguration.setNotAllowedChar(results.getString("notAllowedChar"));
					policyConfiguration.setPasswordHistoryCount(results.getInt("passwordHistoryCount"));
					
				}
			}
		}
		catch (SQLException e)
		{
			// Logging needed.
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
	
		
	}

}
