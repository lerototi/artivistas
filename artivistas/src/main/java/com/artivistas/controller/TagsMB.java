package com.artivistas.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.artivistas.model.Tags;
import com.artivistas.service.TagsService;

@ManagedBean
public class TagsMB extends SpringBeanAutowiringSupport {

	private Tags tag;


	@Autowired
	private TagsService tagsService;

	
	public List<Tags> autoCompleteTags(String query) {
		return tagsService.buildAutocompleteList(query);
	}

	public Tags getTag() {
		return tag;
	}

	public void setTag(Tags tag) {
		this.tag = tag;
	}

}
