package com.artivistas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivistas.model.HabilityClassification;
import com.artivistas.repository.HabilityClassificationRepository;

@Service
public class CategoryHabService {
	
	@Autowired
	private HabilityClassificationRepository classificationRepository;

	@Transactional
	public Iterable<HabilityClassification> listAll(){

		return classificationRepository.findAll();
		
	}
	
}
