package com.advsdc.group4.Signup.service;

import org.springframework.stereotype.Service;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.Signup.dao.SignUpDao;

@Service
public class SignUpServiceImpl implements SignUpService {

	SignUpDao signupDao;
	User user;
	
	public SignUpServiceImpl(User user, SignUpDao dao) {
		signupDao = dao;
		this.user = user;
	}
	
	@Override
	public boolean addUserToDB() {
		return signupDao.addUser(user);
	}

	@Override
	public boolean userExists() {
		return signupDao.userExists(user);
	}

}
