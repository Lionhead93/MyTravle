package com.youlove.common;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.youlove.service.domain.Time;

public class TimeZoneId {
	
	public static List<Time> getTimezone() {
		List<Time> timeList = new ArrayList<>();
		Time timez = new Time();
		String[] local = TimeZone.getAvailableIDs();
		Date date = new Date();
		//2019-06-17 14:21:28 (EEST +0300)
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss (z Z)");
		int left = 0;
		int right = 0;
		int center = 0;
		//13:23:40
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		TimeZone time;
		for(String i : local) {
			time = TimeZone.getTimeZone(i);
			df.setTimeZone(time);
			
			if(i.startsWith("Asia/Seoul")) {
				//System.out.format("%s%n%s%n%n", time.getDisplayName(),df.format(date));
				timez.setCountryName("한국");
				timez.setTime(df.format(date));
				timeList.add(timez);
				timez = new Time();
			}
			if(i.startsWith("America/New_York")) {
				//System.out.format("%s%n%s%n%n", time.getDisplayName(),df.format(date));
				timez.setCountryName("미국");
				timez.setTime(df.format(date));
				timeList.add(timez);
				timez = new Time();
			}
			if(i.startsWith("Australia/Sydney")) {
				//System.out.format("%s%n%s%n%n", time.getDisplayName(),df.format(date));
				timez.setCountryName("호주");
				timez.setTime(df.format(date));
				timeList.add(timez);
				timez = new Time();
			}
			if(i.startsWith("America/Sao_Paulo")) {
				//System.out.format("%s%n%s%n%n", time.getDisplayName(),df.format(date));
				timez.setCountryName("브라질");
				timez.setTime(df.format(date));
				timeList.add(timez);
				timez = new Time();
			}
			if(i.startsWith("Europe/Moscow")) {
				//System.out.format("%s%n%s%n%n", time.getDisplayName(),df.format(date));
				timez.setCountryName("러시아");
				timez.setTime(df.format(date));
				timeList.add(timez);
				timez = new Time();
			}
			
			//System.out.println(i);
			if(i.startsWith("Europe")) {
				
				
//				if(time.getDisplayName().startsWith("중앙 유럽") || time.getDisplayName().startsWith("동유럽") || time.getDisplayName().startsWith("서유럽")) {
					if(time.getDisplayName().startsWith("중앙 유럽") && center == 0) {
						//System.out.format("%s%n%s%n%n", time.getDisplayName(),df.format(date));
						center++;
						timez.setCountryName("중앙유럽");
						timez.setTime(df.format(date));
						//timez.setTimeGap("7시간 00분");
						timeList.add(timez);
						timez = new Time();
					}
					if(time.getDisplayName().startsWith("동유럽") && right == 0) {
						//System.out.format("%s%n%s%n%n", time.getDisplayName(),df.format(date));
						right++;
						timez.setCountryName("동유럽");
						timez.setTime(df.format(date));
						//timez.setTimeGap("6시간 00분");
						timeList.add(timez);
						timez = new Time();
					}
					if(time.getDisplayName().startsWith("서유럽") && left == 0) {
						//System.out.format("%s%n%s%n%n", time.getDisplayName(),df.format(date));
						left++;
						timez.setCountryName("서유럽");
						timez.setTime(df.format(date));
						//timez.setTimeGap("8시간 00분");
						timeList.add(timez);
						timez = new Time();
					}
					
					//중앙유럽,동유럽,서유럽
					//System.out.format("%s%n%s%n%n", time.getDisplayName(),df.format(date));
					
					
					
					
					//System.out.println(TimeZone.getTimeZone(i));
//				}
				
			
			}
		}
		
		return timeList;
		
	}
}

