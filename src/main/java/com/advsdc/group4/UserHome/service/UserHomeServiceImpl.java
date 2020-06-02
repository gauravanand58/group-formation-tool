package com.advsdc.group4.UserHome.service;

import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Model.User;
import com.advsdc.group4.UserHome.dao.IUserHomeDao;
import com.advsdc.group4.UserHome.dao.UserHomeDaoImpl;

public class UserHomeServiceImpl implements IUserHomeService{
	
	private IUserHomeDao userHomeDao;
	
	public UserHomeServiceImpl() {
		userHomeDao = new UserHomeDaoImpl();
	}
	
	public IUser loadUserCourseMap(String bannerID) {
		IUser user = new User(bannerID, userHomeDao);
		userHomeDao.loadUserCourseMap(user);
		return user;
	}
	
}
