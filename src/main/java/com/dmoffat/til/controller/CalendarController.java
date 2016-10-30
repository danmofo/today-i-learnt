package com.dmoffat.til.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dmoffat.til.exceptions.InvalidDateException;
import com.dmoffat.til.model.MonthlyThings;
import com.dmoffat.til.service.ThingService;

@Controller
@RequestMapping(value="/calendar/")
public class CalendarController {
	
	private ThingService thingService;
	
	public CalendarController(ThingService thingService) {
		this.thingService = thingService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String thisMonth(Model m) {
		
		m.addAttribute("monthlyThings", thingService.findByMonth(2016, 10));
		
		return "/calendar/home";
	}
	
	// todo: use month name in url
	@RequestMapping(value="{year}/{month}", method=RequestMethod.GET)
	public String showMonth(@PathVariable("year") int year, @PathVariable("month") int month, Model m) {
		if(!isValidDate(year, month)) {
			throw new InvalidDateException("Invalid date!");
		}
		
		
		MonthlyThings things = thingService.findByMonth(year, month);
		
		m.addAttribute("monthlyThings", things);
		
		return "/calendar/home";
	}
	
	private boolean isValidDate(int year, int month) {
		return month > 0 && month < 13;
	}
	
}
