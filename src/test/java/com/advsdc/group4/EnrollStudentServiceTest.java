package com.advsdc.group4;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import java.io.UnsupportedEncodingException;

import com.advsdc.group4.CourseAdminPage.dao.EnrollStudentDaoImpl;
import com.advsdc.group4.CourseAdminPage.service.EnrollStudentServiceImpl;
import com.advsdc.group4.Model.IUser;
import com.advsdc.group4.Model.User;

@SpringBootTest
public class EnrollStudentServiceTest {

	@Mock
	EnrollStudentDaoImpl dao;
	
	@InjectMocks
	EnrollStudentServiceImpl service;
	
	@Test
	public void readTest() throws UnsupportedEncodingException {
		IUser user=new User();
		user.setBannerID("B00899999");
    	user.setFirstName("Shrey");
    	user.setLastName("Vaghela");
    	user.setEmail("sh367824@dal.ca");
		user.setPassword("test_password");
		given(dao.insertStudentsInDB(user,5308)).willReturn(true);
		String mails = "B00899999,Shrey,Vaghela,sh367824@dal.ca";
		 MultipartFile file = new MockMultipartFile("file", "test.csv", "text/csv", mails.getBytes("utf-8"));
		assertEquals(true,service.readCSV(file, 5308));
		
		//Invalid csv file
		String mails1 = "";
		MultipartFile file1 = new MockMultipartFile("file", "test.csv", "text/csv", mails1.getBytes("utf-8"));
		assertEquals(false,service.readCSV(file1, 5308));
	}
}
