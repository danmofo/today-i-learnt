package com.dmoffat.til.service;

import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dmoffat.til.model.Thing;

@Transactional
public interface ThingService {
	void add(Thing t);
	Thing update(Thing t);
	Page<Thing> list(Pageable p);
	
	void delete(Long id);
	
	Thing findById(Long id);
	Page<Thing> findByDate(DateTime date);
	List<Thing> findByDateRange(DateTime start, DateTime end);
}
