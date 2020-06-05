package com.advsdc.group4.CourseAdminPage.service;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailServiceImpl implements EmailService{

	@Override
	public void sendEmail(String to,String subject,String body) throws AddressException, MessagingException, IOException {
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

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		   msg.setSubject(subject);
		   msg.setContent(body, "text/html");
		   Transport.send(msg);   
		}

}
