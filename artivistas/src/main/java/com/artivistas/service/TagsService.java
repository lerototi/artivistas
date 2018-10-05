package com.artivistas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivistas.repository.TagsRepository;

@Service
public class TagsService {

	@Autowired
	private TagsRepository tagsRepository;
	
	
	@Transactional
	public Iterable findAll(){
		return tagsRepository.findAll();
	}
	
}
