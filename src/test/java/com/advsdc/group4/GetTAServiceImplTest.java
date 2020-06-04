package com.advsdc.group4;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import com.advsdc.group4.CourseAdminPage.dao.GetTADaoImpl;
import com.advsdc.group4.CourseAdminPage.service.GetTAServiceImpl;
import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Model.User;

@SpringBootTest
public class GetTAServiceImplTest {
	
	@Mock
	GetTADaoImpl dao;
	
	@InjectMocks
	GetTAServiceImpl service;
	
	@Test
	public void displayInfoTest() {
		IUser user=new User();
		user.setBannerID("B00834792");
		given(dao.getUser(user, 5308)).willReturn(null);
		String taInfo=service.displayInfo(user, 5308);	
		assertEquals(null,taInfo);
	}

	@Test
	public void enrollTATest() {
		IUser user=new User();
		user.setBannerID("B00800000");
		given(dao.insertTA(user, 5308)).willReturn(true);
		Boolean enrolledTA=service.enrollTA(user, 5308);	
		assertEquals(true,enrolledTA);
	}
}
