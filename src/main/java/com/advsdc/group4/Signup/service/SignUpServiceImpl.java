package com.advsdc.group4.Signup.service;

import org.springframework.stereotype.Service;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Signup.dao.SignUpDao;
import com.advsdc.group4.Signup.dao.SignUpDaoImpl;

@Service
public class SignUpServiceImpl implements SignUpService {

	SignUpDao signupDao;
	
	public SignUpServiceImpl() {
		signupDao = new SignUpDaoImpl();
	}
	
	@Override
	public boolean addUserToDB(IUser user) {
		return signupDao.addUser(user);
	}

	@Override
	public boolean userExists(IUser user) {
		return signupDao.userExists(user);
	}

}
