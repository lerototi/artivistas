package com.artivistas.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;



@Service
public class LoginService {

	@Autowired
	protected AuthenticationManager authenticationManager;
	
	/*@Autowired
	RequestCache requestCache;*/

	public void authenticateUserAndSession(String username, String password, HttpServletRequest request) {
		
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
			
			request.getSession();
			
			token.setDetails(new WebAuthenticationDetails(request));
			Authentication authenticationUser= authenticationManager.authenticate(token);
			
			SecurityContextHolder.getContext().setAuthentication(authenticationUser);
		} catch (Exception e) {
			System.err.println("Error: "+e);
		}
		
		
	}

	
}
