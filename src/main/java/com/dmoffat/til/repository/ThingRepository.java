package com.dmoffat.til.repository;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dmoffat.til.model.Thing;

public interface ThingRepository extends PagingAndSortingRepository<Thing, Long>{
	
	// Get all Things and their tags in one query 
//	@Query("from Thing t left join fetch t.tags")
//	public Page<Thing> findAllIncludingTags(Pageable p);
	
	public Page<Thing> findAll(Pageable p);
	
	public Page<Thing> findAllByAddedBetween(DateTime start, DateTime end, Pageable p);
	public List<Thing> findAllByAddedBetweenOrderByAddedAsc(DateTime start, DateTime end);
	
}
