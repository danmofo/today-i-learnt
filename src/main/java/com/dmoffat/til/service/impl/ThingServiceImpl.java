package com.dmoffat.til.service.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.YearMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dmoffat.til.model.MonthlyThings;
import com.dmoffat.til.model.Thing;
import com.dmoffat.til.repository.ThingRepository;
import com.dmoffat.til.service.ThingService;

@Service("thingService")
public class ThingServiceImpl implements ThingService {

	private ThingRepository thingRepository;
	
	@Autowired
	public ThingServiceImpl(ThingRepository thingRepository) {
		this.thingRepository = thingRepository;
	}
	
	@Override
	public void add(Thing t) {
		thingRepository.save(t);
	}

	@Override
	public Thing update(Thing t) {
		return thingRepository.save(t);
	}
	
	@Override
	public Page<Thing> findByDay(DateTime time) {
		return thingRepository.findAllByAddedBetween(time, time.plusDays(1).minusSeconds(1), new PageRequest(0, 1));
	}

	@Override
	public Page<Thing> list(Pageable p) {
		return thingRepository.findAll(p);
	}

	@Override
	public Thing findById(Long id) {	
		return thingRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		thingRepository.delete(id);
	}

	@Override
	public List<Thing> findByDateRange(DateTime start, DateTime end) {
		return thingRepository.findAllByAddedBetweenOrderByAddedAsc(start, end);
	}

	@Override
	public MonthlyThings findByMonth(int year, int month) {
		DateTime start = new DateTime(year, month, 1, 0, 0);
		DateTime end = new DateTime(year, month, start.dayOfMonth().getMaximumValue(), 0, 0);
		
		return new MonthlyThings(start, thingRepository.findAllByAddedBetweenOrderByAddedAsc(start, end));
	}
	
}
