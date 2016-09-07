package com.gss.commons;

import java.util.Calendar;
import java.util.Date;

public class Utils {
	public static String getDate(){
		String str = null;
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int mouth = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		String mm = null;
		if(mouth < 10){
			mm = "0" + mouth;
		}else {
			mm = "" + mouth;
		}
		
		str = "" + year + mm + day;
		
		return str;
	}
	
	public static String date2String(Date date){
		String daString = null;
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int mouth = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		String mm = null;
		if(mouth < 10){
			mm = "0" + mouth;
		}else {
			mm = "" + mouth;
		}
		
		daString = year + "-" + mm + "-" + day;
		return daString;
	}
}
