package com.artivistas.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Transactional
	public List<User> getAllUsers(){
		return (List<User>) userRepository.findAll();
	}
	
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
		
		//Set actual date
		Date date = new Date();	
		profileUser.setDateOfCreationProfile(date);
		
		//TODO Encripter password
		//user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));		
		
		//TODO add authority to user
		//Authority userAuthority = authorityRepository.findByName("ROLE_USER");
		//user.setAuthorities(new ArrayList<Authority>(Arrays.asList(userAuthority)));
		
		//set relation whith profile
		profileUser.setUser(user);
		user.setPflUser(profileUser);
		return userRepository.save(user) != null;
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
}
