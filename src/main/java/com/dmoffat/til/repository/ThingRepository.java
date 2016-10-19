package com.dmoffat.til.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dmoffat.til.model.Thing;


public interface ThingRepository extends CrudRepository<Thing, Long>{
	public List<Thing> findAll();
}
