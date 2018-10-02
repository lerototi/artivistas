package com.artivistas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivistas.model.HabilityUser;
import com.artivistas.repository.HabilityUserRepository;

@Service
public class HabilityUserService {

	@Autowired
	HabilityUserRepository<HabilityUser> activityRepository;
	
	@Transactional
	public HabilityUser save(HabilityUser activity) {
		return activityRepository.save(activity);
	}
	
}
