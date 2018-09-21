package com.artivistas.controller;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.artivistas.model.User;
import com.artivistas.service.UserService;

@ManagedBean
@SessionScope
@Component
public class UserMB {
	
	@Autowired
	public UserService userService;
	private User currentUser;
	UserDetails userDetails;
	
	public String getCurrentUserName() {
		
		userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return userDetails.getUsername();
	}
	
public User getCurrentUser() {
		
		System.out.println(currentUser ==null);
		if(currentUser ==null) {
			currentUser = new User();
			getCurrentUserName();
			 currentUser = userService.findByMail(userDetails.getUsername());
			 System.out.println("service "+currentUser.getPflUser().getName());
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
