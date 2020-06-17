package CSCI5308.GroupFormationTool.SecurityTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordPolicyConfiguration;

public class PasswordPolicyConfigurationTest {
	
	PasswordPolicyDBMock persistanceMock = new PasswordPolicyDBMock();
	@Test
	public void constructorTest() {
		PasswordPolicyDBMock persistanceMock = new PasswordPolicyDBMock();
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		assertTrue(configuration.getMaxLength()==6);
		assertTrue(configuration.getMinLength()==1);
		assertTrue(configuration.getMinLowerChar()==2);
		assertTrue(configuration.getMinUpperChar()==2);
		assertTrue(configuration.getMinSplChar()==2);
		assertTrue(configuration.getNotAllowedChar().equals("@#$%^"));
		assertTrue(configuration.getPasswordHistoryCount()==3);
	}
	
	@Test
	public void setMaxLengthTest() {
		
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setMaxLength(2);
		assertTrue(configuration.getMaxLength()==2);
	}
	
	@Test
	public void getMaxLengthTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		assertTrue(configuration.getMaxLength()==6);
	}
	
	@Test
	public void setMinLengthTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setMinLength(1);
		assertTrue(configuration.getMinLength()==1);
	}

	@Test
	public void getMinLengthTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		System.out.println("xcxc:"+configuration.getMinLength());
		assertTrue(configuration.getMinLength()==1);
	}


	
	@Test
	public void getMinLowerCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		assertTrue(configuration.getMinLowerChar()==2);
	}


	@Test
	public void setMinLowerCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setMinLowerChar(2);
		assertTrue(configuration.getMinLowerChar()==2);
	}
	
	@Test
	public void getMinUpperCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		assertTrue(configuration.getMinUpperChar()==2);
	}
	
	@Test
	public void setMinUpperCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setMinUpperChar(2);
		assertTrue(configuration.getMinUpperChar()==2);
	}
	
	
	@Test
	public void getMinSplCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		assertTrue(configuration.getMinSplChar()==2);
	}
	
	@Test
	public void setMinSplCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setMinSplChar(2);
		assertTrue(configuration.getMinSplChar()==2);
	}

	@Test
	public void getPasswordHistoryCountTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		assertTrue(configuration.getPasswordHistoryCount()==3);
	}
	
	@Test
	public void setPasswordHistoryCountTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setPasswordHistoryCount(3);
		assertTrue(configuration.getPasswordHistoryCount()==3);
	}
	
	@Test
	public void getNotAllowedCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		assertTrue(configuration.getNotAllowedChar().equals("@#$%^"));
	}
	
	@Test
	public void setNotAllowedCharTest() {
		PasswordPolicyConfiguration  configuration = PasswordPolicyConfiguration.instance(persistanceMock);
		configuration.setNotAllowedChar("$%@");
		assertTrue(configuration.getNotAllowedChar().equals("$%@"));
	}
	
	

	@Test
	public void getPasswordPoliciesTest() {
		assertNotNull(PasswordPolicyConfiguration.getPasswordPolicies());
	}
	
}
