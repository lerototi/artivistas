package com.artivistas.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilService {
	
	
	private Date brithday;	
		
	
	public Date getBrithday(String brith){
		
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		try {
			brithday = f.parse(brith);
		} catch (ParseException e) {
			e.printStackTrace();
			e.printStackTrace();
		}
		
		System.out.println(brithday.getTime());
		return brithday;
	}

	public void setBrithday(Date brithday) {
		brithday = brithday;
	}

	public Date getAtualDate() {
		
		Calendar c = Calendar.getInstance();
		
		
		return c.getTime();
	}
	
	
	
	
	

}
