package com.artivistas.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.artivistas.model.Authority;
import com.artivistas.model.ProfileUser;
import com.artivistas.model.User;
import com.artivistas.service.AuthorityService;
import com.artivistas.service.ProfileUserService;
import com.artivistas.service.UserService;


public class DataStart {
	
	@Autowired
	private static UserService userService;
	
	@Autowired
	private static AuthorityService authorityService;
	
	public static void main(String[] args) {

		UtilService utilService = new UtilService();
		
		Authority auth = new Authority();
		auth.setRole("ADM");
		Authority auth2 = new Authority();
		auth2.setRole("USER");

		auth = authorityService.save(auth);
		auth = authorityService.save(auth2);
		
		List<Authority> authorities = new ArrayList<>();
		authorities.add(auth);
		authorities.add(auth2);
		
		User user = new User();
		user.setMail("lerototi@gmail.com");
		user.setPassword("1234");
		user.setCellphone("+55 61 998487-7797");
		user.setEnabled(true);
		user.setAuthorities(authorities);
		
		ProfileUser profileUser = new ProfileUser();		
		profileUser.setDateOfBrithday(utilService.getBrithday("17/08/1989"));
		profileUser.setDateOfCreationProfile(utilService.getAtualDate());
		profileUser.setFacebook("leroto");
		profileUser.setInstagram("@leroto");
		profileUser.setName("Leonardo");
		profileUser.setSurname("Torres");
		profileUser.setDescription("Eu sou o melhor programador do mundo, já está escrito!! Jah Bless");
		profileUser.setUser(user);
		
		userService.addUser(user, profileUser);
		
		authorities = new ArrayList<>();
		authorities.add(auth2);
		user.setAuthorities(authorities);
		
		
		user = new User();
		user.setMail("anaabrahao23@gmail.com");
		user.setPassword("4321");
		user.setEnabled(true);
		user.setCellphone("+55 61 9999-9999");
		
		profileUser = new ProfileUser();
		profileUser.setDateOfBrithday(utilService.getBrithday("17/08/1989"));
		profileUser.setDateOfCreationProfile(utilService.getAtualDate());
		profileUser.setFacebook("abrahaoana");
		profileUser.setInstagram("@abrahaoana");
		profileUser.setName("Ana");
		profileUser.setSurname("Abrahão");
		profileUser.setUser(user);
		profileUser.setDescription("Eu Sou a tatuadora mais linda e charmosa desse mundo!");
		
		userService.addUser(user, profileUser);
		
		
		
		
	}

}
