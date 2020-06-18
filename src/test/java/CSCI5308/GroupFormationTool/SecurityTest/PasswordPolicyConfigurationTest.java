package CSCI5308.GroupFormationTool.SecurityTest;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.Security.PasswordPolicyConfiguration;

@SuppressWarnings("deprecation")
public class PasswordPolicyConfigurationTest {
	PasswordPolicyDBMock persistanceMock = new PasswordPolicyDBMock();
	
	@Test
	public void constructorTest() {
		PasswordPolicyDBMock persistanceMock = new PasswordPolicyDBMock();
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		Assert.isTrue(configuration.getMaxLength()==6);
		Assert.isTrue(configuration.getMinLength()==1);
		Assert.isTrue(configuration.getMinLowerChar()==2);
		Assert.isTrue(configuration.getMinUpperChar()==2);
		Assert.isTrue(configuration.getMinSplChar()==2);
		Assert.isTrue(configuration.getNotAllowedChar().equals("@#$%^"));
		Assert.isTrue(configuration.getPasswordHistoryCount()==3);
	}
	
	@Test
	public void setMaxLengthTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setMaxLength(2);
		Assert.isTrue(configuration.getMaxLength()==2);
	}
	
	@Test
	public void getMaxLengthTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		Assert.isTrue(configuration.getMaxLength()==6);
	}
	
	@Test
	public void setMinLengthTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setMinLength(1);
		Assert.isTrue(configuration.getMinLength()==1);
	}

	@Test
	public void getMinLengthTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		System.out.println("xcxc:"+configuration.getMinLength());
		Assert.isTrue(configuration.getMinLength()==1);
	}
	
	@Test
	public void getMinLowerCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		Assert.isTrue(configuration.getMinLowerChar()==2);
	}

	@Test
	public void setMinLowerCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setMinLowerChar(2);
		Assert.isTrue(configuration.getMinLowerChar()==2);
	}
	
	@Test
	public void getMinUpperCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		Assert.isTrue(configuration.getMinUpperChar()==2);
	}
	
	@Test
	public void setMinUpperCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setMinUpperChar(2);
		Assert.isTrue(configuration.getMinUpperChar()==2);
	}
	
	@Test
	public void getMinSplCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		Assert.isTrue(configuration.getMinSplChar()==2);
	}
	
	@Test
	public void setMinSplCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setMinSplChar(2);
		Assert.isTrue(configuration.getMinSplChar()==2);
	}

	@Test
	public void getPasswordHistoryCountTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		Assert.isTrue(configuration.getPasswordHistoryCount()==3);
	}
	
	@Test
	public void setPasswordHistoryCountTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setPasswordHistoryCount(3);
		Assert.isTrue(configuration.getPasswordHistoryCount()==3);
	}
	
	@Test
	public void getNotAllowedCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		Assert.isTrue(configuration.getNotAllowedChar().equals("@#$%^"));
	}
	
	@Test
	public void setNotAllowedCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setNotAllowedChar("$%@");
		Assert.isTrue(configuration.getNotAllowedChar().equals("$%@"));
	}

	@Test
	public void getPasswordPoliciesTest() {
		Assert.notNull(PasswordPolicyConfiguration.getPasswordPolicies());
	}
}
