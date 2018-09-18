package com.artivistas.repository;

import org.springframework.data.repository.CrudRepository;

import com.artivistas.model.Authority;

public interface AuthorityRepository<U> extends CrudRepository<Authority, Long> {

	Authority findByRole(String role);
	
	
}
