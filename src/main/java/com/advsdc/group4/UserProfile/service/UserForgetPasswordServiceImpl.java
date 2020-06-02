package com.advsdc.group4.UserProfile.service;

import java.time.Duration;
import java.time.Instant;
import java.util.Properties;
import java.util.Random;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.Model.UserAuth;
import com.advsdc.group4.UserProfile.dao.IUserAuthDao;
import com.advsdc.group4.UserProfile.dao.IUserProfileDao;
import com.advsdc.group4.util.PasswordEncoder;

import javax.mail.*;
import javax.mail.internet.*;



public class UserForgetPasswordServiceImpl implements IUserForgetPasswordService {
	
	@Override
	public User getUserInfo(String bannerID, IUserProfileDao userDao) {
		User user = new User(bannerID, userDao);
		if(user.getEmail()!=null) {
			return user;
		}
		return null;
	}

	@Override
	public UserAuth getUserAuthInfo(String bannerID, IUserAuthDao userAuthDao) {
		
		UserAuth userAuth = new UserAuth(bannerID, userAuthDao);
		if(userAuth.getBannerID()!=null) {
			return userAuth;
		}
		return null;
	}

	@Override
	public boolean generateOtp(String userEmail, UserAuth userAuth, IUserAuthDao userAuthDao) {
		
		if(userEmail!=null) {
			String otpCode = "";
	        Random randVal = new Random(); 	  
	        String randValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789" ;
	        for (int i = 0; i < 6; i++) 
	        {  
	        	otpCode += randValues.charAt(randVal.nextInt(randValues.length())); 
	        } 
	        userAuth.setOtp(otpCode);
	        userAuthDao.saveOtp(userAuth);
			sendEmail(userEmail, otpCode);
			return true;
			
		}
		return false;
	}
	
	@Override
	public boolean validateOTP(String otp, String bannerID, IUserAuthDao userAuthDao) {
		UserAuth userAuth = new UserAuth(bannerID, userAuthDao);
		if(userAuth.getOtp()!=null && userAuth.getOtp().equals(otp)) {
			return true;
		}
		
		return false;
	}


	@Override
	public boolean checkExpiration(String bannerID, IUserAuthDao userAuthDao) {
		UserAuth userAuth = new UserAuth(bannerID, userAuthDao);
		if(userAuth!=null && userAuth.getTimestamp()!=null) {
		Instant currentTime = Instant.now();
		Instant otpCreatedTime = userAuth.getTimestamp().toInstant();
		if(Duration.between(currentTime, otpCreatedTime).toMillis()<10*60*100000 ) {
			return true;
		}	
		}
		return false;
	}

	

	@Override
	public boolean userResetPassword(String bannerId,String password, IUserAuthDao userAuthDao) {
		boolean status = false;
		UserAuth userAuth = new UserAuth(bannerId, userAuthDao);
		if(userAuth!=null && userAuth.getPassword()!=null) {
			PasswordEncoder encrypt = new PasswordEncoder();
			userAuth.setPassword(encrypt.encode(password));
			userAuthDao.userResetPassword(userAuth);
			status = true;
		}
		return status;
	}

	
	private void sendEmail(String userEmail, String otpCode) {

		String to = userEmail;
		String from = "mcproj7@gmail.com";
		String host = "smtp.gmail.com";
		Properties prop = System.getProperties();
		prop.put("mail.smtp.starttls.enable", "true");
		prop.setProperty("mail.smtp.host", host);
		prop.setProperty("mail.smtp.port", "587");
		prop.setProperty("mail.smtp.auth", "true");
		Session session = Session
				.getInstance(prop, new javax.mail.Authenticator(){
			        protected PasswordAuthentication getPasswordAuthentication() {
			            return new PasswordAuthentication( from, "euchunzbtywsqwgc");
			        }
			});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setContent("OTP is <b>"+otpCode+"</b> <br> This will expire in 10mins.", "text/html; charset=utf-8");

			message.setSubject("Your OTP for Group Formation Tool is generated!");
			Transport.send(message);
	        System.out.println("Sent message successfully....");

			
		}catch(Exception e) {
			System.out.println(e);
		}	
	}


	
}
