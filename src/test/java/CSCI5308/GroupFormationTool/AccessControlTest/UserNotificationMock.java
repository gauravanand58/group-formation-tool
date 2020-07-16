package CSCI5308.GroupFormationTool.AccessControlTest;

import javax.mail.MessagingException;

import CSCI5308.GroupFormationTool.AccessControl.IUserNotifications;
import CSCI5308.GroupFormationTool.AccessControl.User;

public class UserNotificationMock implements IUserNotifications {

	@Override
	public void sendUserLoginCredentials(User user, String rawPassword) throws MessagingException {
		
	}

}
