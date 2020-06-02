package com.advsdc.group4.UserProfile.forms;

public class GenerateOTP {
	String bannerId;
	boolean inValidUser = false;
	String email;
	String password;
	String opt;
	String confirmPassword;
	boolean inValidOtp = false;
	boolean passwordMismatch = false;
	boolean timeExceeded = false;
	boolean mailSent = false;
	String userEmail;
	boolean isPasswordReset = false;


	public String getBannerId() {
		return bannerId;
	}

	public void setBannerId(String bannerId) {
		this.bannerId = bannerId;
	}

	public boolean isInValidUser() {
		return inValidUser;
	}

	public void setInValidUser(boolean inValidUser) {
		this.inValidUser = inValidUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getOpt() {
		return opt;
	}

	public void setOpt(String opt) {
		this.opt = opt;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isInValidOtp() {
		return inValidOtp;
	}

	public void setInValidOtp(boolean inValidOtp) {
		this.inValidOtp = inValidOtp;
	}

	public boolean isPasswordMismatch() {
		return passwordMismatch;
	}

	public void setPasswordMismatch(boolean passwordMismatch) {
		this.passwordMismatch = passwordMismatch;
	}

	public boolean isTimeExceeded() {
		return timeExceeded;
	}

	public void setTimeExceeded(boolean timeExceeded) {
		this.timeExceeded = timeExceeded;
	}

	public boolean isMailSent() {
		return mailSent;
	}

	public void setMailSent(boolean mailSent) {
		this.mailSent = mailSent;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public boolean isPasswordReset() {
		return isPasswordReset;
	}

	public void setPasswordReset(boolean isPasswordReset) {
		this.isPasswordReset = isPasswordReset;
	}
	
	


}
