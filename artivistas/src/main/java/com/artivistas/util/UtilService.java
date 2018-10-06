package com.artivistas.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
	
	public static <E> List<E> toList(Iterable<E> iterable){
		if(iterable instanceof List) {
		return (List<E>) iterable;
	}
		ArrayList<E> list = new ArrayList<>();
		if(iterable != null) {
			for(E e: iterable) {
				list.add(e);
			}
		}
		return list;
	}
	
	
	public void setBrithday(Date brithday) {
		brithday = brithday;
	}

	public Date getAtualDate() {
		
		Calendar c = Calendar.getInstance();
		
		
		return c.getTime();
	}
	
	
	
	
	

}
