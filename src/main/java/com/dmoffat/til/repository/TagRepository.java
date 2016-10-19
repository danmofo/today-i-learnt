package com.dmoffat.til.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dmoffat.til.model.Tag;


public interface TagRepository extends CrudRepository<Tag, Long>{
	public List<Tag> findAll();
}
