package br.com.artivistas;

import java.util.List;

import javax.xml.ws.WebServiceProvider;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.artivistas.model.Tags;
import com.artivistas.service.TagsService;
import com.artivistas.util.UtilService;

//TODO @RunWith(SpringJUnit4ClassRunner.class) and @ContextConfiguration(classes=AppConfig.class)
public class TestTags{
	
	@Autowired
	TagsService tagsSetvice;

	@Test
	public void buildListTags() {
		
		String query;
		List<Tags> allTags = UtilService.toList(tagsSetvice.findAll());
		
		query = "#";
		
		//Test equals
		Assert.assertEquals(query, tagsSetvice.buildAutocompleteList(query).get(0));
		
	}

}
