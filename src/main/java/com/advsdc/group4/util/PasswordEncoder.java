package com.advsdc.group4.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder extends BCryptPasswordEncoder{
	
	public String encode(String password) {
		return super.encode(password);
	}
	
	public boolean match(String password, String encoded) {
		return super.matches(password, encoded);
	}
}
