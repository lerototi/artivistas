package com.artivistas.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivistas.model.ProfileUser;
import com.artivistas.model.User;
import com.artivistas.repository.ProfileUserRepository;

@Service
public class ProfileUserService {

	@Autowired
	ProfileUserRepository<ProfileUser> profileUserRepository;
	
	@Transactional
	public boolean addProfileUser(ProfileUser profileUser, User user) {
		
		profileUser.setUser(user);
		return profileUserRepository.save(profileUser) != null;
	}
	
}
