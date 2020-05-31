package com.advsdc.group4.Model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;
import java.time.Instant;

import org.junit.jupiter.api.Test;
	import com.advsdc.group4.Model.UserAuth;
import com.advsdc.group4.UserProfile.dao.IUserAuthDao;
import com.advsdc.group4.UserProfile.dao.MockUserAuthDao;

public class UserAuthTest {
	private UserAuth createDefaultUser()
	{
		IUserAuthDao m = new MockUserAuthDao();
		return new UserAuth("B00835818", m);
		
	}
	
	@Test
	public void getBannerIDTest()
	{
		UserAuth u = createDefaultUser();
		assertEquals("B00835818", u.getBannerID());
	}
	@Test
	public void setBannerIDTest()
	{
		UserAuth u = new UserAuth();
		u.setBannerID("B00835818");
		assertEquals("B00835818", u.getBannerID());
	}
	
	@Test
	public void getPasswordTest()
	{
		UserAuth u = createDefaultUser();
		assertEquals("AA123", u.getPassword());
	}
	@Test
	public void setPasswordTest()
	{
		UserAuth u = new UserAuth();
		u.setPassword("A123");
		assertEquals("A123", u.getPassword());
	}
	
	@Test
	public void getOtpTest()
	{
		UserAuth u = createDefaultUser();
		assertEquals("A12d", u.getOtp());
	}
	@Test
	public void setOtpTest()
	{
		UserAuth u = new UserAuth();
		u.setOtp("A123");
		assertEquals("A123", u.getOtp());
	}
	
	@Test
	public void getTimeStampTest() {
		UserAuth u = createDefaultUser();
		assertNotNull(u.getTimestamp());
	}
	
	@Test
	public void setTimeStampTest()
	{
		UserAuth u = new UserAuth();
		u.setTimestamp(Timestamp.from(Instant.now()));;
		assertEquals(Timestamp.from(Instant.now()), u.getTimestamp());
	}
	
}
