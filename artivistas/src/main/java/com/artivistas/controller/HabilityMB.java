package com.artivistas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.artivistas.model.HabilityUser;
import com.artivistas.model.Tags;
import com.artivistas.service.HabilityUserService;
import com.artivistas.service.TagsService;
import com.artivistas.service.UserService;

@ManagedBean
public class HabilityMB extends SpringBeanAutowiringSupport{

	private List<Tags> selectedTags;
	
	private HabilityUser habilityUser = new HabilityUser();
	
	@Autowired
	private TagsService tagService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HabilityUserService habilityUserService;
	
	private List<HabilityUser> habilitiesUser;
	

	public String save() {
		
		List<Tags> persistedTags = new ArrayList<Tags>();
		
		tagService.verifyExistentsAndPersistNewTags(selectedTags);
		habilityUser.setTags(persistedTags);
		
		habilityUser.setProfileUser(userService.getCurrentUser().getPflUser());
		habilityUserService.save(habilityUser);
		
		return"/pfl/profileuser.jsf";
	}
	
	
	public void setHabilityUser(HabilityUser habilityUser) {
		this.habilityUser = habilityUser;
	}


	public List<Tags> getSelectedTags() {
		return selectedTags;
	}


	public void setSelectedTags(List<Tags> selectedTags) {
		this.selectedTags = selectedTags;
	}

	public List<HabilityUser> getHabilitiesUser() {
		return habilityUserService.findAllByProfileUser(userService.getCurrentUser().getPflUser());
	}

	public void setHabilitiesUser(List<HabilityUser> habilitiesUser) {
		this.habilitiesUser = habilitiesUser;
	}


	public HabilityUser getHabilityUser() {
		return habilityUser;
	}
	
}
