package com.advsdc.group4.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class PasswordEncoderTest {
	
	static PasswordEncoder passwordEncoder = new PasswordEncoder();
	
	@Test
	public void encode() {
		passwordEncoder.setPassword("testPassword");
		assertNotNull(passwordEncoder.encode());
	}
	
	@Test
	public void getPassword() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = passwordEncoder.getClass().getDeclaredField("password");
		field.setAccessible(true);
		field.set(passwordEncoder, "testPassword");		
		assertEquals("testPassword", passwordEncoder.getPassword());
	}
	
	@Test
	public void setPassword() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		passwordEncoder.setPassword("testPassword");
		Field field = passwordEncoder.getClass().getDeclaredField("password");
		field.setAccessible(true);
		assertEquals("testPassword", field.get(passwordEncoder));
	}

}
