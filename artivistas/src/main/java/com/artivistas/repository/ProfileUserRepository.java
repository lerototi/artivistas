package com.artivistas.repository;

import org.springframework.data.repository.CrudRepository;

import com.artivistas.model.ProfileUser;

public interface ProfileUserRepository<U> extends CrudRepository<ProfileUser, Long> {

}
