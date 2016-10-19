package com.dmoffat.til.service;

import java.util.List;

import javax.transaction.Transactional;

import com.dmoffat.til.model.Tag;

@Transactional
public interface TagService {
	void add(Tag t);
	Tag update(Tag t);
	List<Tag> list();
	Tag findById(Long id);
	void delete(Long id);
}
