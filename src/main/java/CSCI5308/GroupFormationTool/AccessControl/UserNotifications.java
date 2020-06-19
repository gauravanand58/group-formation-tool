package CSCI5308.GroupFormationTool.AccessControl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class UserNotifications implements IUserNotifications {
	private String commonMessage = "Given are the credentials to access your account:\n";

	@Override
	public void sendUserLoginCredentials(User user, String rawPassword) throws MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("csci.5308.project@gmail.com", "csci.5308.project1234");
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("csci.5308.project@gmail.com", false));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
		msg.setSubject("Credentials for your newly created account");
		commonMessage += "Username:" + user.getBannerID() + "\nPassword:" + rawPassword;
		msg.setContent(commonMessage, "text/html");
		Transport.send(msg);
	}
}