package com.artivistas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.artivistas.model.HabilityClassification;
import com.artivistas.model.ProfileUser;
import com.artivistas.service.CategoryHabService;
import com.artivistas.service.ProfileUserService;
import com.artivistas.service.UserService;

@ManagedBean
@ViewScoped
public class ProfileUserMB extends SpringBeanAutowiringSupport{
	
	
	public ProfileUserMB() {
		if (profileUser==null) {
			System.out.println("new profile user");
			profileUser = userServive.getCurrentUser().getPflUser();
		}
	}

	private List<HabilityClassification> categoryHabs;
	private String[] selectedTags;
	private ProfileUser profileUser;

	@Autowired
	private UserService userServive;
	
	@Autowired
	private CategoryHabService categoryHabService;
	
	@Autowired
	private ProfileUserService profileUserService;

	public List<HabilityClassification> getCategoryHabs() {
		return categoryHabs;
	}
	
	public String saveOrUpdate() {
		ProfileUser savedProfile = new ProfileUser();
	
		savedProfile = userServive.getCurrentUser().getPflUser();
		savedProfile.setDescription(profileUser.getDescription());
		savedProfile.setFacebook(profileUser.getFacebook());
		savedProfile.setInstagram(profileUser.getInstagram());
		
		
		profileUserService.save(savedProfile);
		
		return "/pfl/profileuser.jsf?faces-redirect=true";
	}
	
	public String cancelar() {
		
		return "/profile/profileuser.jsf";
	}
	
	public String loadProfileData() {
		System.out.println("Bio");
		
		profileUser = new ProfileUser();
		profileUser = profileUserService.findUserProfileByUser(userServive.getCurrentUser());
	
	return "/pfl/updateBio.jsf?faces-redirect=true";
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


	public ProfileUser getProfileUser() {
		return profileUser;
	}


	public void setProfileUser(ProfileUser profileUser) {
		this.profileUser = profileUser;
	}


	public void setCategoryHabs(List<HabilityClassification> categoryHabs) {
		this.categoryHabs = categoryHabs;
	}
	
	
	
}
