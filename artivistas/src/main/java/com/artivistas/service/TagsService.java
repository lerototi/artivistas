package com.artivistas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.artivistas.model.Tags;
import com.artivistas.repository.TagsRepository;

@Service
public class TagsService {

	@Autowired
	private TagsRepository tagsRepository;
	
	
	@Transactional
	public Iterable findAll(){
		return tagsRepository.findAll();
	}


	public List<Tags> buildAutocompleteList(String query) {
		@SuppressWarnings("unchecked")
		List<Tags> allTags = UtilService.toList(this.findAll());
		List<Tags> filteredTags = new ArrayList<Tags>();
		
		System.out.println("chamei");
		
		if (!query.startsWith("#"))
			query = "#" + query;
		

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

	
}
