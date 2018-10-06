package com.artivistas.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.artivistas.model.Tags;

@FacesConverter("tagsConverter")
public class TagsConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length()>0) {
			try {
				Tags tag = new Tags();
				tag.setNameTag(value);
				return tag;
				
			} catch (NumberFormatException e) {
				throw new ConverterException("Não foi possivel obter a empresa "+e.getMessage());
			}
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && value instanceof Tags) {
			
			return ((Tags) value).getNameTag();
		}
		return "";
	}

}
