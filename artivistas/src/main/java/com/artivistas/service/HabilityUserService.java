package com.artivistas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivistas.model.HabilityUser;
import com.artivistas.model.ProfileUser;
import com.artivistas.model.User;
import com.artivistas.repository.HabilityUserRepository;
import com.artivistas.repository.UserRepository;

@Service
public class HabilityUserService {

	@Autowired
	HabilityUserRepository<HabilityUser> habilityRepository;
	
	@Transactional
	public HabilityUser save(HabilityUser activity) {
		return habilityRepository.save(activity);
	}

	public List<HabilityUser> findAllByProfileUser(ProfileUser profileUser) {
		
		return habilityRepository.findByProfileUser(profileUser);
	}
	
}
