package com.webapp.bookmyshowapp.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class DateUtil {
	
	/*
	 * Initialize Current Date&Time 
	 */
	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	static DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
	
    public static Date getCurrentDateAndTime() {	  
    	formatter.format(new Date());
    	return Date.from(Instant.now());	
    }
    
    public static String covertDateToString(Date date) {    	  
    	  return dateFormat.format(date);
    }
    
    public static long getMillis(Date date) {
    	return date.getTime(); 
    }
    
    public LocalDateTime getCurrentLocalDateTime() {
    	return LocalDateTime.now();
    }
}
