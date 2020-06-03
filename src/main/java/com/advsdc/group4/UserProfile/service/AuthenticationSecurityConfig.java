package com.advsdc.group4.UserProfile.service;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class AuthenticationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(passwordEncoder())
		.usersByUsernameQuery("Select UBannerID as username, UPassword  as password, true"
								+" from UserAuth where UBannerID = ? ;")
		.authoritiesByUsernameQuery("select BannerID as username, RoleName as authority from Users join User_Course_Assoc on UCBannerID=BannerID join Role on UCRoleID = ID where BannerID= ? ;");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	            .authorizeRequests()
                	.antMatchers("/resources/templates/**", "/").permitAll()	
	                .antMatchers("/user/**").hasAnyRole("Guest","TA","Student","Instructor")
	                .antMatchers("/admin/**").hasRole("Admin")
	                .and()
	                
	            .formLogin()
	                .loginPage("/")
	                .defaultSuccessUrl("/success.html")
					.failureUrl("/?error=true")
	                .permitAll()
	                .and()
	           
	           .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
	                .permitAll()
	           .and().exceptionHandling().accessDeniedPage("invalidSession");
	    
	    		
	}
	


}


