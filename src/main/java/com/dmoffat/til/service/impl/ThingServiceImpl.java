package com.dmoffat.til.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmoffat.til.model.Thing;
import com.dmoffat.til.repository.ThingRepository;
import com.dmoffat.til.service.ThingService;
import com.dmoffat.til.utils.Utilities;

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
	public List<Thing> list() {
		return Utilities.makeList(thingRepository.findAll());
	}

	@Override
	public Thing findById(Long id) {	
		return thingRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		thingRepository.delete(id);
	}
	
}
