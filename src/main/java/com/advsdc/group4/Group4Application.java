package com.advsdc.group4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import com.advsdc.group4.Landing.util.DBConfiguration;


@SpringBootApplication(exclude = {
SecurityAutoConfiguration.class })

@EnableConfigurationProperties

public class Group4Application {
	
	 
	public static void main(String[] args) {
		//SpringApplication.run(Group4Application.class, args);
		
		final ApplicationContext ctx = SpringApplication.run(Group4Application.class, args);
		final DBConfiguration dbConfig = ctx.getBean(DBConfiguration.class);
		System.out.println(dbConfig.getUrl());
		System.out.println(dbConfig.getDriver());

	}
	


}
