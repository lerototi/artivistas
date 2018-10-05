package com.artivistas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.facelets.Tag;

import org.hibernate.integrator.spi.Integrator;
import org.hibernate.mapping.Array;
import org.omg.IOP.TAG_CODE_SETS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.artivistas.model.Tags;
import com.artivistas.service.TagsService;
import com.artivistas.service.UtilService;
import com.mysql.cj.conf.BooleanPropertyDefinition.AllowableValues;

import javassist.expr.NewArray;

@ManagedBean
public class TagsMB extends SpringBeanAutowiringSupport {

	private Tags tag;
	private List<Tags> selectedTags;

	@Autowired
	private TagsService tagsService;


	public List<Tags> autoCompleteTags(String query) {
		System.out.println("MB");
		return tagsService.buildAutocompleteList(query);
	}

	public Tags getTag() {
		return tag;
	}

	public void setTag(Tags tag) {
		this.tag = tag;
	}

	public List<Tags> getSelectedTags() {
		return selectedTags;
	}

	public void setSelectedTags(List<Tags> selectedTags) {
		this.selectedTags = selectedTags;
	}

}
