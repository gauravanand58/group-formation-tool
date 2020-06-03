package com.advsdc.group4.UserProfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.Model.UserAuth;
import com.advsdc.group4.UserProfile.dao.IUserAuthDao;
import com.advsdc.group4.UserProfile.dao.IUserProfileDao;
import com.advsdc.group4.UserProfile.dao.UserAuthDaoImpl;
import com.advsdc.group4.UserProfile.dao.UserProfileDaoImpl;
import com.advsdc.group4.UserProfile.forms.GenerateOTP;
import com.advsdc.group4.UserProfile.service.IUserForgetPasswordService;
import com.advsdc.group4.UserProfile.service.UserForgetPasswordServiceImpl;

@Controller
public class UserForgetPasswordController {
	
	IUserAuthDao userAuthDao;
	IUserProfileDao userDao;
	IUserForgetPasswordService forgetPasswordService;
	
	@GetMapping("/")
	public String userLogin(Model model) {
		return "home";
	}
	
	@GetMapping("/forgotpassword")
	public String generatePassotp(Model model) {
		model.addAttribute("generateotp", new GenerateOTP());
		return "forgotpassword";
	}
	
	@PostMapping("/validateOTP")
	  public String userOTPGenerate(@ModelAttribute GenerateOTP generateotp,Model model) {
		  
		 User user = forgetPasswordService.getUserInfo(generateotp.getBannerId(),userDao);
		 if(user != null) {
			 generateotp.setUserEmail(user.getEmail());
			 generateotp.setMailSent(true);
			 UserAuth userAuth = forgetPasswordService.getUserAuthInfo(generateotp.getBannerId(),userAuthDao);
			
			 forgetPasswordService.generateOtp(user.getEmail(),userAuth,userAuthDao);

			model.addAttribute("generateotp", generateotp);
			return "newPassword";
		 } 
		 else {
			 generateotp.setInValidUser(true);
			 model.addAttribute("generateotp", generateotp);
			 return "forgotpassword";
		 }
	  }	
	
	
	@PostMapping("/resetpassword")
	  public String userResetPassword(@ModelAttribute GenerateOTP generateotp,Model model) {
		if(forgetPasswordService.getUserInfo(generateotp.getBannerId(), userDao)!=null) {
		if(!generateotp.getPassword().equals(generateotp.getConfirmPassword())){
			generateotp.setPasswordMismatch(true);
			generateotp.setInValidOtp(false);
			generateotp.setTimeExceeded(false);
			model.addAttribute("generateotp", generateotp);
			return "newPassword";
		}
		else if(!forgetPasswordService.validateOTP(generateotp.getOpt(), generateotp.getBannerId(), userAuthDao)) {
			generateotp.setInValidOtp(true);
			generateotp.setTimeExceeded(false);
			generateotp.setPasswordMismatch(false);
			model.addAttribute("generateotp", generateotp);
			return "newPassword";
		}
		else if(!forgetPasswordService.checkExpiration(generateotp.getBannerId(), userAuthDao)) {
			generateotp.setTimeExceeded(true);
			generateotp.setInValidOtp(false);
			generateotp.setPasswordMismatch(false);
			model.addAttribute("generateotp", generateotp);
			return "newPassword";
		}else {
			forgetPasswordService.userResetPassword(generateotp.getBannerId(), generateotp.getPassword(), userAuthDao);
			generateotp = new GenerateOTP();
			generateotp.setPasswordReset(true);
		}
		
		model.addAttribute("generateotp", generateotp);
		}else {
			generateotp.setInValidUser(true);
			model.addAttribute("generateotp", generateotp);
			return "newPassword";
		}
		model.addAttribute("passwordreset", generateotp.isPasswordReset());
		 return "home";
	  }
	
	public UserForgetPasswordController() {
		userAuthDao = new UserAuthDaoImpl();
		userDao = new UserProfileDaoImpl();
		forgetPasswordService = new UserForgetPasswordServiceImpl();
	}
	
	
}
