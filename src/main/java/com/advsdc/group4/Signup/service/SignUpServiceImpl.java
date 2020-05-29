package com.advsdc.group4.Signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advsdc.group4.Model.User;
import com.advsdc.group4.Signup.dao.SignUpDao;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	SignUpDao signupDao;
	
	@Override
	public boolean addUserToDB(User user) {
		return signupDao.addEntry(user);
	}

}
