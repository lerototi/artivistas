package com.artivistas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.artivistas.model.HabilityClassification;
import com.artivistas.service.CategoryHabService;

@ManagedBean
@RequestScoped
public class ProfileUserMB extends SpringBeanAutowiringSupport{

	private List<HabilityClassification> categoryHabs;
	private String[] selectedTags;
	
	@Autowired
	private CategoryHabService categoryHabService;

	public List<HabilityClassification> getCategoryHabs() {
		return categoryHabs;
	}


	public String[] getSelectedTags() {
		return selectedTags;
	}

	public void setSelectedTags(String[] selectedTags) {
		this.selectedTags = selectedTags;
	}

	public CategoryHabService getCategoryHabService() {
		return categoryHabService;
	}

	public void setCategoryHabService(CategoryHabService categoryHabService) {
		this.categoryHabService = categoryHabService;
	}
	
	
	
}
