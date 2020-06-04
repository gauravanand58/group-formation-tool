package com.advsdc.group4.UserProfile.service;


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
	
	CustomAuthenticationProvider authenticationProvider;
	
	
	public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);


	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	    		.csrf() 
	    		.disable() 
	    		
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
	                .permitAll();
	    
	    		
	}
	
	public AuthenticationSecurityConfig() {
		this.authenticationProvider = new CustomAuthenticationProvider();
	}
	


}


