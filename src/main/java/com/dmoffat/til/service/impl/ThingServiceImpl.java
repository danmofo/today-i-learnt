package com.dmoffat.til.service.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
	public Page<Thing> findByDate(DateTime time) {
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
		List<Thing> unsortedThings = thingRepository.findAllByAddedBetweenOrderByAddedAsc(start, end);
		
		return unsortedThings;
	}
	
}
