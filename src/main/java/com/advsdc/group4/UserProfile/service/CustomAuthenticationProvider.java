package com.advsdc.group4.UserProfile.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.advsdc.group4.UserProfile.dao.IUserAuthDao;
import com.advsdc.group4.UserProfile.dao.UserAuthDaoImpl;

public class CustomAuthenticationProvider implements AuthenticationProvider{

	IUserAuthDao authDao;
	IUserAuthService authService ;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		try {
			String username = authentication.getPrincipal().toString();
			String password = authentication.getCredentials().toString();
			
			
			if(authService.validateUserCredentials(username, password, authDao)) {
				System.out.println("authService: logedIn");
				ArrayList<GrantedAuthority> roles = new ArrayList<>();
				List<String> roleList = authService.fetchUserRoles(username, authDao);
				for (String role : roleList) {
					 roles.add(new SimpleGrantedAuthority(role));
					
				}
               
                return new UsernamePasswordAuthenticationToken(username, password, roles);
			}else {
                throw new BadCredentialsException("1000");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);

	}
	
	public CustomAuthenticationProvider(){
		this.authService = new UserAuthServiceImpl();
		this.authDao = new UserAuthDaoImpl();
	}
	

	

}
