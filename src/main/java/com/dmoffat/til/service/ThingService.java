package com.dmoffat.til.service;

import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.joda.time.YearMonth;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dmoffat.til.model.MonthlyThings;
import com.dmoffat.til.model.Thing;

@Transactional
public interface ThingService {
	
	/**
	 * Add a Thing
	 * @param t
	 */
	void add(Thing t);
	
	/**
	 * Update a Thing
	 * @param t
	 * @return
	 */
	Thing update(Thing t);
	
	/**
	 * List Thing objects
	 * @param p
	 * @return
	 */
	Page<Thing> list(Pageable p);
	
	/**
	 * Delete a Thing object by id
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * Find Thing by id
	 * @param id
	 * @return
	 */
	Thing findById(Long id);
	
	/**
	 * Find Thing objects that were created on a specific day of the year
	 * @param date
	 * @return
	 */
	Page<Thing> findByDay(DateTime date);
	
	/**
	 * Find Thing objects that were created between start and end.
	 * @param start
	 * @param end
	 * @return
	 */
	List<Thing> findByDateRange(DateTime start, DateTime end);
	
	/**
	 * Find Thing objects that were created on a specific month of the year
	 * @param month
	 * @return
	 */
	MonthlyThings findByMonth(int year, int month);
}
