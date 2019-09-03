package com.youlove.common;

import java.util.Random;

public class RandomNumber {
	
	public static String getRandom() {
		Random ran = new Random();
		String number = "";
		for(int i = 0; i < 5; i++) {
			int num = ran.nextInt(9);
			number += num+"";
		}
		return number;
	}

}
