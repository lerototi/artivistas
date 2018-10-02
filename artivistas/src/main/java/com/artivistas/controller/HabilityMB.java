package com.artivistas.controller;

import javax.faces.bean.ManagedBean;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.artivistas.model.HabilityUser;

@ManagedBean
public class HabilityMB extends SpringBeanAutowiringSupport{


	private HabilityUser habilityUser;
	
	
	public void save() {
		
		
	}


	public HabilityUser getHabilityUser() {
		return habilityUser;
	}


	public void setHabilityUser(HabilityUser habilityUser) {
		this.habilityUser = habilityUser;
	}
	
	
	
	
}
