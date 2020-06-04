package com.advsdc.group4.CourseAdminPage.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface EmailService {
	public void sendEmail(String to,String subject,String message) throws AddressException, MessagingException, IOException;
}
