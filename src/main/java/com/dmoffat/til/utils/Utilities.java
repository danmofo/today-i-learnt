package com.dmoffat.til.utils;

import org.joda.time.DateTime;


public class Utilities {
	/**
	 * Creates an int array from a DateTime. Useful when you need
	 * to iterate over days of a month.
	 * @param date
	 * @return
	 */
	public static int[] getDaysOfMonth(DateTime date) {
				
		int[] days = new int[date.dayOfMonth().getMaximumValue()];
		
		for (int i = 0; i < days.length; i++) {
			days[i] = i + 1;
		}
		
		return days;
	}
}
