package com.dmoffat.til.controller.admin;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dmoffat.til.model.Thing;
import com.dmoffat.til.service.ThingService;

/**
 * Handles all requests made to the Thing entity in administration area. 
 * @author danielmoffat
 *
 */
@Controller
@RequestMapping("/admin/thing/")
public class ThingController {
	
	public static final Logger logger = LoggerFactory.getLogger(ThingController.class);
	
	private ThingService thingService;
	
	@Autowired
	public ThingController(ThingService thingService) {
		this.thingService = thingService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		return "/admin/index";
	}
	
	@RequestMapping(value="find", method=RequestMethod.GET)
	public String find() {
		logger.info("{}", thingService.findByDate(new DateTime(2016, 10, 19, 0, 0)));
		
		return "";
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String addNewThing(Model m) {
		
		m.addAttribute("thing", new Thing());
		
		return "/admin/thing/add-thing";
	}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String addAddNewThing(@Valid Thing t, BindingResult result, Model m) {
		
		if(result.hasErrors()) {
			return "/admin/thing/add-thing";
		}
		
	
		thingService.add(t);
		
		logger.info("added {} to the database", t);
		
		
		return "redirect:/admin/thing/list";
	}
	
	@RequestMapping(value="edit/{id}", method=RequestMethod.GET)
	public String editThing(@PathVariable Long id, Model m) {
				
		Thing t = thingService.findById(id);
		
		m.addAttribute("thing", t);
		
		return "/admin/thing/edit-thing";
	}

	@RequestMapping(value="edit/{id}", method=RequestMethod.POST)
	public String postEditThing(@Valid Thing t, BindingResult result, Model m) {
		
		if(result.hasErrors()) {
			m.addAttribute("thing", t);
			return "/admin/thing/edit-thing";
		}
		
		thingService.update(t);
		
		logger.info("Updated t {}", t);
		
		return "redirect:/admin/thing/list";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String deleteThing(@RequestParam("id") Long id) {
		
		thingService.delete(id);
	
		return "redirect:/admin/thing/list";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String listThings(@PageableDefault(size=10) Pageable p, Model m) {
		
		m.addAttribute("things", thingService.list(p));
	

		return "/admin/thing/list-thing";
	}
	
	
	
	
	
}
