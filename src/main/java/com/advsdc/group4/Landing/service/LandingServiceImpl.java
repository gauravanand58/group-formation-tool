package com.advsdc.group4.Landing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.advsdc.group4.Landing.dao.LandingDao;

@Service
public class LandingServiceImpl implements LandingService {
	
	@Autowired
	LandingDao landingDao;

	@Override
	public String landingHome(Model model) {
		//template for Dao access
		String subTitle = landingDao.testDb();
		
		model.addAttribute("title", "Student Plus!");
		model.addAttribute("subtitle", subTitle);
		model.addAttribute("roles", subTitle);
		return "home";
	}

	
}
