package com.advsdc.group4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import com.advsdc.group4.util.DBConfiguration;


@SpringBootApplication(exclude = {
SecurityAutoConfiguration.class })

public class Group4Application {
	
	public static void main(String[] args) {
		//SpringApplication.run(Group4Application.class, args);
		
		final ApplicationContext ctx = SpringApplication.run(Group4Application.class, args);
		System.out.println(DBConfiguration.getUrl());
		System.out.println(DBConfiguration.getDriver());

	}
	


}
