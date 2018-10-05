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

	public List<String> completeText(String query) {

		List<String> results = new ArrayList<String>();
		// TODO Sugestions Tag
		return results;
	}

	public List<Tags> completeTags(String query) {

		@SuppressWarnings("unchecked")
		List<Tags> allTags = UtilService.toList(tagsService.findAll());
		List<Tags> filteredTags = new ArrayList<Tags>();

		System.out.println(allTags.size());

		if (!query.startsWith("#"))
			query = "#" + query;

		System.out.println(query);

		for (int i = 0; i < allTags.size(); i++) {
			Tags tag = allTags.get(i);
			Tags queryTag = new Tags();
			
			
			//if TAG start with QUERY
			if (tag.getNameTag().toLowerCase().startsWith(query.toLowerCase())) {
				
				//Vefify if List filteredTag is input. if YES add QUERY
				if (filteredTags.size()==0) {
					
					queryTag.setNameTag(query);
					filteredTags.add(queryTag);
				}
				
				//vefify if current TAG is inside of filteredTags 
				boolean listHasTheTag= false;
				for (int j = 0; j < filteredTags.size(); j++) {
						
					if (filteredTags.get(j).getNameTag().equals(tag.getNameTag())) {
						listHasTheTag = true;
					}else
						listHasTheTag = false;
						
					}
				//include
				if (!listHasTheTag) {
					filteredTags.add(tag);
				}
			}
			
			//Verify if the query is in the BD lista tags
			if (!tag.getNameTag().toLowerCase().startsWith(query)) {
				
				
				if (filteredTags.size()==0) {
					
					queryTag.setNameTag(query);
					filteredTags.add(queryTag);
					
				}
						
			}
			
		}

		return filteredTags;
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
