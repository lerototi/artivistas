package com.artivistas.repository;

import org.springframework.data.repository.CrudRepository;

import com.artivistas.model.Tags;

public interface TagsRepository<U> extends CrudRepository<Tags, Long>{

}
