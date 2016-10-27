package com.dmoffat.til.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dmoffat.til.model.Tag;
import com.dmoffat.til.repository.TagRepository;
import com.dmoffat.til.service.TagService;

@Service("tagService")
public class TagServiceImpl implements TagService {

	private TagRepository tagRepository;
	
	@Autowired
	public TagServiceImpl(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	@Override
	public void add(Tag t) {
		tagRepository.save(t);
	}

	@Override
	public Tag update(Tag t) {
		return tagRepository.save(t);
	}

	@Override
	public Page<Tag> list(Pageable p) {
		return tagRepository.findAll(p);
	}

	@Override
	public Tag findById(Long id) {	
		return tagRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		tagRepository.delete(id);
	}
	
}
