package com.dmoffat.til.controller.admin;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmoffat.til.model.Tag;
import com.dmoffat.til.service.TagService;

/**
 * Handles all requests made to the Tag entity in administration area. 
 * @author danielmoffat
 *
 */
@Controller
@RequestMapping("/admin/tag/")
public class TagController {
	
	public static final Logger logger = LoggerFactory.getLogger(TagController.class);
	
	private TagService tagService;
	
	@Autowired
	public TagController(TagService tagService) {
		this.tagService = tagService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		return "/admin/index";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String addNewtag(Model m) {
		
		m.addAttribute("tag", new Tag());
		
		return "/admin/tag/add-tag";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String addAddNewtag(@Valid Tag t, BindingResult result, Model m) {
		
		if(result.hasErrors()) {
			return "/admin/tag/add-tag";
		}
		
	
		tagService.add(t);
		
		logger.info("Added {} to the database", t);
		
		
		return "redirect:/admin/tag/list";
	}
	
	@RequestMapping(value="edit/{id}", method=RequestMethod.GET)
	public String edittag(@PathVariable Long id, Model m) {
				
		Tag t = tagService.findById(id);
		
		m.addAttribute("tag", t);
		
		return "/admin/tag/edit-tag";
	}

	@RequestMapping(value="edit/{id}", method=RequestMethod.POST)
	public String postEdittag(@Valid Tag t, BindingResult result, Model m) {
		
		if(result.hasErrors()) {
			m.addAttribute("tag", t);
			return "/admin/tag/edit-tag";
		}
		
		tagService.update(t);
		
		logger.info("Updated Tag {}", t);
		
		return "redirect:/admin/tag/list";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String deletetag(@RequestParam("id") Long id) {
		
		tagService.delete(id);
	
		return "redirect:/admin/tag/list";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String listtags(Model m, @PageableDefault(size=3) Pageable p) {
		
		m.addAttribute("tags", tagService.list(p));

		return "/admin/tag/list-tag";
	}	
}
