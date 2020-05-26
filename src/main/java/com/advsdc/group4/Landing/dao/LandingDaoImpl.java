package com.advsdc.group4.dao;

import org.springframework.stereotype.Service;

@Service
public class LandingDaoImpl implements LandingDao{

	@Override
	public String testDb() {
		// TODO implement jdbc operations here
		String subTitle = "Course and Group Tool";
		
		return subTitle;
		
	}

}
