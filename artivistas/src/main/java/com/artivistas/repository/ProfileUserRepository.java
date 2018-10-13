package com.artivistas.repository;

import org.springframework.data.repository.CrudRepository;

import com.artivistas.model.ProfileUser;
import com.artivistas.model.User;

public interface ProfileUserRepository<U> extends CrudRepository<ProfileUser, Long> {

	ProfileUser findByUser(User user);

}
