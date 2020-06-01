package com.advsdc.group4.Signup.service;

import org.springframework.stereotype.Service;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Signup.dao.SignUpDao;
import com.advsdc.group4.Signup.dao.SignUpDaoImpl;
import com.advsdc.group4.util.PasswordEncoder;

@Service
public class SignUpServiceImpl implements SignUpService {

	SignUpDao signupDao;
	
	public SignUpServiceImpl() {
		signupDao = new SignUpDaoImpl();
	}
	
	@Override
	public String addUserToDB(IUser user) {
		
		// check if user already exists
		boolean userExists = signupDao.userExists(user);
		if(userExists) {
			return "User Exists";
		}
		
		// encrypt password
		PasswordEncoder passwordEncoder = new PasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
				
		// set role as Guest
		user.setRole(5);
		
		boolean userAdded = signupDao.addUser(user);
		if(!userAdded) {
			return "Error";
		}
		
		return "User Added";
	}

}
