package CSCI5308.GroupFormationTool;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class SystemConfigTest {
	@Test
	public void instanceTest() {
		SystemConfig systemConfig = SystemConfig.instance();
		assertNotNull(systemConfig);
	}

	@Test
	public void getPasswordEncryptionTest() {
		assertNotNull(SystemConfig.instance().getPasswordEncryption());
	}

	@Test
	public void getConfigurationTest() {
		assertNotNull(SystemConfig.instance().getConfiguration());
	}

	@Test
	public void getDatabaseConfigurationTest() {
		assertNotNull(SystemConfig.instance().getDatabaseConfiguration());
	}

	@Test
	public void getPasswordPolicyDBTest() {
		assertNotNull(SystemConfig.instance().getPasswordPolicyDB());
	}
	
	@Test
	public void getUserPasswordRelationshipDBTest() {
		assertNotNull(SystemConfig.instance().getUserPasswordRelationshipDB());
	}

}
