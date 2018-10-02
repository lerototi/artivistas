package com.artivistas.repository;

import org.springframework.data.repository.CrudRepository;

import com.artivistas.model.HabilityUser;

public interface HabilityUserRepository<U> extends CrudRepository<HabilityUser, Long> {

}
