package com.dmoffat.til.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dmoffat.til.service.ThingService;

@Controller
public class HomeController {

	private ThingService thingService;
	
	@Autowired
	public HomeController(ThingService thingService) {
		this.thingService = thingService;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model m) {
		
		m.addAttribute("things", thingService.list());
		
		return "home";
	}
}
