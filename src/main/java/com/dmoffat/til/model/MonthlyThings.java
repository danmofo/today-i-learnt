package com.dmoffat.til.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.joda.time.DateTime;

import com.dmoffat.til.utils.Utilities;

/**
 * Represents a collection of Things for the month.
 * 
 * When constructed, things will contain a hashmap whose keys can be iterated
 * to display a calendar view in the following format:
 * 
 * [x, x, x, 1, 2, 3, 4,
 *  5, 6, 7, 8, 9,10,11,
 *  ..
 *  ..
 * 26,27,28,29,30, x, x]
 * 
 * Numbers are days and 'x' represents days in the previous/next month
 * so that we can populate a weekly calendar view.
 * 
 * To differentiate between days that belong to this month and those that don't,
 * those that do belong are positive numbers and those that don't are negative.
 * 
 * 
 * todo: split this class up into CalendarMonth & ThingsCalendarMonth so that the calendar
 * logic can be used in other views. There is way too much calendar related logic in here.
 * 
 * @author danielmoffat
 *
 */
public class MonthlyThings {
	// LinkedHashMap retains insertion order. A regular hashmap makes no guarantee about iteration order.
	private HashMap<Integer, List<Thing>> things = new LinkedHashMap<Integer, List<Thing>>();
	private DateTime month;
	
	private DateTime previousMonth;
	private DateTime nextMonth;
	private DateTime previousYear;
	private DateTime nextYear;
	
	private int thingCount;
	
	/**
	 * @param month The month
	 * @param ts The Thing objects created in the month
	 */
	public MonthlyThings(DateTime month, List<Thing> ts) {
		
		this.month = month;
		
		this.previousMonth = calculatePreviousMonth();
		this.nextMonth = calculateNextMonth();
		this.previousYear = calculatePreviousYear();
		this.nextYear = calculateNextYear();
		
		this.thingCount = ts.size();
				
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
			things.put(-j, null);
		}
		
		// Initialise an empty list for day of the month to hold things.
		for (int i = 0; i < daysOfMonth.length; i++) {
			things.put(daysOfMonth[i], new ArrayList<Thing>());
		}
		
		// Add the Thing objects to their respective day
		for(Thing thing : ts) {
			int m = thing.getAdded().dayOfMonth().get();
			
			things.get(m).add(thing);
		}
				
		// If the start of the month lands on a Saturday / Sunday (6/7)
		// then we need to add an extra row to accommodate the overflow.
		int requiredSize = things.size() <= 35 ? 35 : 42;
		
		// Calculate the days to display from the next month
		int overlap = requiredSize - things.size();
		
		// Add the overlap to the end of the month
		for(int k = 1; k <= overlap; k++) {
			things.put(-k, null);
		}
	}
	
	private DateTime calculatePreviousMonth() {
		return this.month.minusMonths(1);
	}
	
	private DateTime calculatePreviousYear() {
		return this.month.minusYears(1);
	}
	
	private DateTime calculateNextMonth() {
		return this.month.plusMonths(1);
	}
	
	private DateTime calculateNextYear() {
		return this.month.plusYears(1);
	}
	
	public HashMap<Integer, List<Thing>> getThings() {
		return this.things;
	}
	
	public DateTime getMonth() {
		return this.month;
	}
	
	
	public DateTime getPreviousMonth() {
		return previousMonth;
	}

	public DateTime getNextMonth() {
		return nextMonth;
	}

	public DateTime getPreviousYear() {
		return previousYear;
	}

	public DateTime getNextYear() {
		return nextYear;
	}
	
	public int getThingCount() {
		return thingCount;
	}

	private MonthlyThings() {}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MonthlyThings [things=");
		builder.append(things);
		builder.append(", month=");
		builder.append(month);
		builder.append(", previousMonth=");
		builder.append(previousMonth);
		builder.append(", nextMonth=");
		builder.append(nextMonth);
		builder.append(", previousYear=");
		builder.append(previousYear);
		builder.append(", nextYear=");
		builder.append(nextYear);
		builder.append(", thingCount=");
		builder.append(thingCount);
		builder.append("]");
		return builder.toString();
	}
}