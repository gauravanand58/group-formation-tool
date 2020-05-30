package com.advsdc.group4.Model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import com.advsdc.group4.Model.User;

public class UserTest {
	
	@Test
	public void getFirstName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		User user = new User();
		Field field = user.getClass().getDeclaredField("firstName");
		field.setAccessible(true);
		field.set(user, "fName");		
		assertEquals("fName", user.getFirstName());
	}
	
	@Test
	public void setFirstName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		User user = new User();
		user.setFirstName("fName");
		Field field = user.getClass().getDeclaredField("firstName");
		field.setAccessible(true);
		assertEquals("fName", field.get(user));
	}
	
	@Test
	public void getLastName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		User user = new User();
		Field field = user.getClass().getDeclaredField("lastName");
		field.setAccessible(true);
		field.set(user, "lName");		
		assertEquals("lName", user.getLastName());
	}
	
	@Test
	public void setLastName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		User user = new User();
		user.setLastName("lName");
		Field field = user.getClass().getDeclaredField("lastName");
		field.setAccessible(true);
		assertEquals("lName", field.get(user));
	}
	
	@Test
	public void getEmail() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		User user = new User();
		Field field = user.getClass().getDeclaredField("email");
		field.setAccessible(true);
		field.set(user, "test@test.com");		
		assertEquals("test@test.com", user.getEmail());
	}
	
	@Test
	public void setEmail() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		User user = new User();
		user.setEmail("test@test.com");
		Field field = user.getClass().getDeclaredField("email");
		field.setAccessible(true);
		assertEquals("test@test.com", field.get(user));
	}
	
	@Test
	public void getBannerID() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		User user = new User();
		Field field = user.getClass().getDeclaredField("bannerID");
		field.setAccessible(true);
		field.set(user, "B000000");		
		assertEquals("B000000", user.getBannerID());
	}
	
	@Test
	public void setBannerID() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		User user = new User();
		user.setBannerID("B000000");
		Field field = user.getClass().getDeclaredField("bannerID");
		field.setAccessible(true);
		assertEquals("B000000", field.get(user));
	}
	
	@Test
	public void getPassword() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		User user = new User();
		Field field = user.getClass().getDeclaredField("password");
		field.setAccessible(true);
		field.set(user, "abc123");		
		assertEquals("abc123", user.getPassword());
	}
	
	@Test
	public void setPassword() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		User user = new User();
		user.setPassword("abc123");
		Field field = user.getClass().getDeclaredField("password");
		field.setAccessible(true);
		assertEquals("abc123", field.get(user));
	}
	
	@Test
	public void getRole() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		User user = new User();
		Field field = user.getClass().getDeclaredField("role");
		field.setAccessible(true);
		field.set(user, 10);		
		assertEquals(10, user.getRole());
	}
	
	@Test
	public void setRole() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		User user = new User();
		user.setRole(10);
		Field field = user.getClass().getDeclaredField("role");
		field.setAccessible(true);
		assertEquals(10, field.get(user));
	}
	
}
