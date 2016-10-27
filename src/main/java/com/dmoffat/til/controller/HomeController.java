package com.dmoffat.til.controller;

import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dmoffat.til.model.Thing;
import com.dmoffat.til.service.ThingService;

@Controller
public class HomeController {

	private ThingService thingService;
	
	public static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	public HomeController(ThingService thingService) {
		this.thingService = thingService;
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model m) {
				
		List<Thing> things = thingService.findByDateRange(DateTime.now().minusYears(10), DateTime.now());
		
		logger.info("{}", things.size());
		
		m.addAttribute("things", things);
		
		return "home";
	}
}
