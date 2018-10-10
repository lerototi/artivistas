package com.artivistas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.artivistas.model.HabilityUser;
import com.artivistas.model.ProfileUser;

public interface HabilityUserRepository<U> extends CrudRepository<HabilityUser, Long> {

	List<HabilityUser> findByProfileUser(ProfileUser profileUser);

}
