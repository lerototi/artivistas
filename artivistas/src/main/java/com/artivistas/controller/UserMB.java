package com.artivistas.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.artivistas.model.User;
import com.artivistas.service.UserService;


@ManagedBean
public class UserMB extends SpringBeanAutowiringSupport{
	
	@Autowired
	public UserService userService;
	private User currentUser;
	UserDetails userDetails;
	
	public String getCurrentUserName() {
		
		userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return userDetails.getUsername();
	}
	
public User getCurrentUser() {
		
		if(currentUser ==null) {
			currentUser = new User();
			getCurrentUserName();
			 currentUser = userService.findByMail(userDetails.getUsername());
			 System.out.println("Current User: "+currentUser.getPflUser().getName());
			return currentUser;
			
		}else
			
		return currentUser;
	}
	
	public String register() {
		return "/account/signup.xhtml?faces-redirect=true";
	}
	
	
	public String showCurrentUserData() {
		//currentUser = loginMB.getCurrentUser();
		
		return "/pfl/profileuser.xhtml?faces-redirect=true";
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
}
