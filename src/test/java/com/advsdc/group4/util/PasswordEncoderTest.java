package com.advsdc.group4.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class PasswordEncoderTest {
	
	static PasswordEncoder passwordEncoder = new PasswordEncoder();
	
	@Test
	public void encode() {
		assertNotNull(passwordEncoder.encode("testPassword"));
	}
	
}
