package CSCI5308.GroupFormationTool.AccessControlTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.AccessControl.UserSystemConfig;


public class UserSystemConfigTest {
	@Test
	public void instanceTest() {
		UserSystemConfig systemConfig = UserSystemConfig.instance();
		assertNotNull(systemConfig);
	}
	
	@Test
	public void getUserNotificationsTest() {
		assertNotNull(UserSystemConfig.instance().getUserNotifications());
	}

	@Test
	public void getUserDBTest() {
		assertNotNull(UserSystemConfig.instance().getUserDB());
	}	
	
	
}
