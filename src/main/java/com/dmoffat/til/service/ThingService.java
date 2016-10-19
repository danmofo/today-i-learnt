package com.dmoffat.til.service;

import java.util.List;

import javax.transaction.Transactional;

import com.dmoffat.til.model.Thing;

@Transactional
public interface ThingService {
	void add(Thing t);
	Thing update(Thing t);
	List<Thing> list();
	Thing findById(Long id);
	void delete(Long id);
}
