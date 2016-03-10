package org.wg.carbooking.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class webGetDate {

	public static String getDate(){
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return df.format(date);
	}
	
	public static long systemCurrentTimeMills(){
		long timeStamp = System.currentTimeMillis();
		return timeStamp;
	}
}
