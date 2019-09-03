package com.youlove.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DateFormat {
	
	
	// �옉�꽦�떆媛�
	public static String minute() throws Exception {
		
		//�궇吏� �삎�떇 1992-08-02 17:52:34
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String time = format.format(System.currentTimeMillis());
		//System.out.println(time);
		
		return time;
	}
	
	public static String today() throws Exception {
		
		//�궇吏� �삎�떇 19920802
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		
		String time = format.format(System.currentTimeMillis());
		//System.out.println(time);
		
		return time;
	}
	
public static String[] hotelDate() throws Exception {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		
		
		String[] hotelDate = new String[2];
		
		cal.add(Calendar.DAY_OF_MONTH, 1);
		hotelDate[0]  = format.format(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, 3);
		hotelDate[1] = 	format.format(cal.getTime());
		
		
		return hotelDate;
	}

}
