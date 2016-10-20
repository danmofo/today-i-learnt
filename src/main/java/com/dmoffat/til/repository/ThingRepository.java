package com.dmoffat.til.repository;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dmoffat.til.model.Thing;


public interface ThingRepository extends CrudRepository<Thing, Long>{
	
	// @Query("from Thing t join fetch t.tags tags")
	@Query("from Thing t left join fetch t.tags tags")
	public List<Thing> findAll();
	
//	@Query("from Thing t left join fetch t.tags tags where t.added between :start and :end")
	public List<Thing> findAllByAddedBetween(@Param("start") DateTime start, @Param("end") DateTime end);
	
}
