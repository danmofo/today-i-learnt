package com.dmoffat.til.model.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.joda.time.DateTime;

import com.dmoffat.til.model.Thing;
import com.dmoffat.til.utils.Utilities;

/**
 * Represents a single month on a calendar to be displayed in a weekly grid
 * @author danielmoffat
 *
 */
public class CalendarMonth {
	// LinkedHashMap retains insertion order. A regular hashmap makes no guarantee about iteration order.
	private HashMap<Integer, List<Object>> items = new LinkedHashMap<Integer, List<Object>>();
	
	// The month in time this represents
	private DateTime month;
	
	public CalendarMonth(DateTime month) {
		
		this.month = month;
						
		int[] daysOfMonth = Utilities.getDaysOfMonth(month); 
		
		// The day of the week the month starts on
		int start = month.dayOfWeek().get();
		
		// Amount of days to add before the start of the month
		int daysBeforeStartOfMonth = start - 1;

		int lastDayOfPreviousMonth = month.minusMonths(1).dayOfMonth().getMaximumValue();		
		
		// Add the days before the start of the month, with a negative number as the key,
		// otherwise the things will get mixed up because their key will be the same as days
		// from the previous month
		for(int j = lastDayOfPreviousMonth - (daysBeforeStartOfMonth - 1); j <= lastDayOfPreviousMonth; j++) {
			items.put(-j, null);
		}
		
		// Initialise an empty list for day of the month to hold things.
		for (int i = 0; i < daysOfMonth.length; i++) {
			items.put(daysOfMonth[i], new ArrayList<Object>());
		}
		
		// If the start of the month lands on a Saturday / Sunday (6/7)
		// then we need to add an extra row to accommodate the overflow.
		int requiredSize = items.size() <= 35 ? 35 : 42;
		
		// Calculate the days to display from the next month
		int overlap = requiredSize - items.size();
		
		// Add the overlap to the end of the month
		for(int k = 1; k <= overlap; k++) {
			items.put(-k, null);
		}
	}

	public HashMap<Integer, List<Object>> getItems() {
		return items;
	}

	public DateTime getMonth() {
		return month;
	}

	public static void main(String[] args) {
		
		System.out.println(new CalendarMonth(DateTime.now()).getItems());
		
	}
}
