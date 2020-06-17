package CSCI5308.GroupFormationTool.SecurityTest;

import CSCI5308.GroupFormationTool.Security.IPasswordPolicyPersistance;
import CSCI5308.GroupFormationTool.Security.PasswordPolicyConfiguration;

public class PasswordPolicyDBMock implements IPasswordPolicyPersistance {

	@Override
	public void loadUserPasswordPolicies(PasswordPolicyConfiguration policyConfiguration) {
		policyConfiguration.setMaxLength(6);
		policyConfiguration.setMinLength(1);
		policyConfiguration.setMinLowerChar(2);
		policyConfiguration.setMinUpperChar(2);
		policyConfiguration.setMinSplChar(2);
		policyConfiguration.setNotAllowedChar("@#$%^");
		policyConfiguration.setPasswordHistoryCount(3);
		
	}

}
