package com.advsdc.group4.Landing.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder extends BCryptPasswordEncoder{
	public String encode(String password) {
		return super.encode(password);
	}
}
