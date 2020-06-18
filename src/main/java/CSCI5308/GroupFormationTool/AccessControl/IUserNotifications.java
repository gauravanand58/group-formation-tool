package CSCI5308.GroupFormationTool.AccessControl;

import javax.mail.MessagingException;

public interface IUserNotifications {
	public void sendUserLoginCredentials(User user, String rawPassword) throws MessagingException;
}