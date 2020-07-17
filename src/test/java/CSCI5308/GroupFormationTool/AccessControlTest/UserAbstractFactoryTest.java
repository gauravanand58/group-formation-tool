package CSCI5308.GroupFormationTool.AccessControlTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.AccessControl.UserAbstractFactory;


public class UserAbstractFactoryTest {
	@Test
	public void instanceTest() {
		UserAbstractFactory instance = UserAbstractFactory.instance();
		assertTrue(null != instance);
	}

	@Test
	public void setFactoryTest() {
		UserAbstractFactory instance = UserAbstractFactory.instance();
		instance.setFactory(instance);
		assertTrue(instance instanceof UserAbstractFactory);
	}
}
