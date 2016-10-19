package com.dmoffat.til.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dmoffat.til.model.Thing;


public interface ThingRepository extends CrudRepository<Thing, Long>{
	
	// @Query("from Thing t join fetch t.tags tags")
	@Query("from Thing t left join fetch t.tags tags")
	public List<Thing> findAll();
}
