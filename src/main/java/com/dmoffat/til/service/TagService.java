package com.dmoffat.til.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dmoffat.til.model.Tag;

@Transactional
public interface TagService {
	void add(Tag t);
	Tag update(Tag t);
	Page<Tag> list(Pageable p);
	Tag findById(Long id);
	void delete(Long id);
}
