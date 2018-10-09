package com.artivistas.controller;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.artivistas.model.User;
import com.artivistas.service.UserService;


@ManagedBean
public class UserMB extends SpringBeanAutowiringSupport{
	
	@Autowired
	public UserService userService;
	UserDetails userDetails;
	
	public String getCurrentUserName() {
		
		return userService.getNameCurrentUser();
	}
	
public User getCurrentUser() {
	
		return userService.getCurrentUser();
	}
	
	public String register() {
		return "/account/signup.xhtml?faces-redirect=true";
	}
	
	
	public String showCurrentUserData() {
		//currentUser = loginMB.getCurrentUser();
		
		return "/pfl/profileuser.xhtml?faces-redirect=true";
	}


	
}
