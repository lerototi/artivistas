package com.artivistas.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import com.artivistas.model.ProfileUser;
import com.artivistas.model.User;
import com.artivistas.service.LoginService;
import com.artivistas.service.UserService;

@SessionScope
@Controller
public class LoginMB {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;

	private User user;
	private ProfileUser profileUser;
	
	
	private String confirmPw;
	
/*	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@ModelAttribute("user")User user, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		
		loginService.authenticateUserAndSession(user.getMail(), user.getPassword(), request);
		
		return "redirect:/index.jsf";
	}*/
	
	@RequestMapping(value = "/account/signup", method = RequestMethod.POST)
	public String createNewUser(@ModelAttribute("user") User user, BindingResult result,
								@ModelAttribute("profileUser") ProfileUser profileUser , HttpServletRequest request, HttpServletResponse response) {
		
		if (result.hasErrors()) {
			return "/account/signup.jsf";
		}
		
		//Verification
		if (!userService.alredyRegistraded(user.getMail())) {
			String pw = user.getPassword();

			userService.addUser(user, profileUser);
			
			loginService.authenticateUserAndSession(user.getMail(),pw, request);
			return "/index.jsf";
		}else {
			
			result.rejectValue("mail","mail.error" ,"Username already registrated");
			System.out.println("alredyRegistrated");
			return"/account/signup.jsf";	
		}
				
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
