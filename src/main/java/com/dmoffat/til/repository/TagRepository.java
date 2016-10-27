package com.dmoffat.til.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dmoffat.til.model.Tag;


public interface TagRepository extends PagingAndSortingRepository<Tag, Long>{
	public Page<Tag> findAll(Pageable p);
}
