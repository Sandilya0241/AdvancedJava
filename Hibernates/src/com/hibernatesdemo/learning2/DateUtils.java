package com.hibernatesdemo.learning2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Date parseDate(String strDate) throws ParseException {
		Date formattedDate = formatter.parse(strDate);
		return formattedDate;
	}
	
	public static String formatDate(Date theDate) {
		String stringDate = null;
		if(theDate != null) {
			stringDate = formatter.format(theDate);
		}
		return stringDate;
	}
}
