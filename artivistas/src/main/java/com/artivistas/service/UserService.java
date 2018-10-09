package com.artivistas.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivistas.model.Authority;
import com.artivistas.model.ProfileUser;
import com.artivistas.model.User;
import com.artivistas.repository.AuthorityRepository;
import com.artivistas.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository<User> userRepository;
	
	@Autowired
	AuthorityRepository<Authority> authorityRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public List<User> getAllUsers(){
		return (List<User>) userRepository.findAll();
	}
	
	private User currentUser;

	private UserDetails userDetails;
	
	@Transactional
	public User findByMail(String mail){
		return userRepository.findByMail(mail);
	}
	
	/*@Transactional
	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}*/
	
	@Transactional
	public boolean addUser(User user, ProfileUser profileUser) {
		boolean saved = false;
		
		//Activate user
		user.setEnabled(true);
		
		//Set actual date
		Date date = new Date();	
		profileUser.setDateOfCreationProfile(date);
		
		//Encripter password
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));		
		
		//Add authority USER to new user
		Authority userAuthority = authorityRepository.findByRole("USER");
		
		user.setAuthorities(new ArrayList<Authority>(Arrays.asList(userAuthority)));
		
		System.out.println(user.getAuthorities().size());
		System.out.println(user.getAuthorities().get(0));
		 for (Authority authority : user.getAuthorities()) {
			 System.out.println(authority.getRole());
			
		}
		//set relation with profile
		profileUser.setUser(user);
		user.setPflUser(profileUser);
		
		
		
		try {
			 saved = userRepository.save(user) != null;
		} catch (Exception e) {
			System.err.println("USER ALREADy REGISTRED"+ e);
		}
		
		
		return saved;
	}
	
	public Boolean alredyRegistraded(String mail) {		
		return userRepository.findByMail(mail) != null;
	}
	
	@Transactional 
	public boolean updateUser(User user) {
		return userRepository.save(user) != null;
	}
	
	@Transactional
	public void deleteUser(Long userId) {
		userRepository.delete(userId);
	}
	
	
	@Transactional
	public User getById(Long id) {
		return userRepository.findOne(id);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public User getCurrentUser() {
		if(currentUser ==null) {
			currentUser = new User();
			getNameCurrentUser();
			 currentUser = this.findByMail(userDetails.getUsername());
			 System.out.println("Current User: "+currentUser.getPflUser().getName());
			return currentUser;
			
		}else
			
		return currentUser;
		
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getNameCurrentUser() {
		userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return userDetails.getUsername();
		
	}

	
}
