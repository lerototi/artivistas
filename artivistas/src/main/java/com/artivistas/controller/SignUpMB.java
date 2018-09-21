package com.artivistas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.artivistas.model.ProfileUser;
import com.artivistas.model.User;
import com.artivistas.service.AuthorityService;
import com.artivistas.service.ProfileUserService;
import com.artivistas.service.UserService;

@RequestScope
@Component
public class SignUpMB {
	
	@Autowired
	private UserService userService;

	@Autowired
	private ProfileUserService profileUserService;
	
	@Autowired
	private AuthorityService authorityService;
	
	private User user = new User();
	private ProfileUser profileUser = new ProfileUser();
	
	
	private String confirmPw;
	
	public String save() {
		userService.addUser(user, profileUser);
		return "";
				
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getConfirmPw() {
		return confirmPw;
	}

	public void setConfirmPw(String confirmPw) {
		this.confirmPw = confirmPw;
	}

	public ProfileUser getProfileUser() {
		return profileUser;
	}

	public void setProfileUser(ProfileUser profileUser) {
		this.profileUser = profileUser;
	}
	
	
}
