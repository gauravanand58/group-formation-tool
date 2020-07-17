package CSCI5308.GroupFormationTool.Security;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class PasswordPolicyDB implements IPasswordPolicyPersistance {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void loadUserPasswordPolicies(PasswordPolicyConfiguration policyConfiguration) {
		CallStoredProcedure proc = null;
		try {
			proc = new CallStoredProcedure("spLoadPasswordPolicy()");
			ResultSet results = proc.executeWithResults();
			if (null != results) {
				while (results.next()) {
					policyConfiguration.setMaxLength(results.getInt("maxLen"));
					policyConfiguration.setMinLength(results.getInt("minLen"));
					policyConfiguration.setMinUpperChar(results.getInt("minUpperChar"));
					policyConfiguration.setMinLowerChar(results.getInt("minLowerChar"));
					policyConfiguration.setMinSplChar(results.getInt("minSplChar"));
					policyConfiguration.setNotAllowedChar(results.getString("notAllowedChar"));
					policyConfiguration.setPasswordHistoryCount(results.getInt("passwordHistoryCount"));
				}
			}
		} catch (SQLException e) {
			logger.error("spLoadPasswordPolicy() throws SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
	}
}
