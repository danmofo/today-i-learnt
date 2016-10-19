package com.dmoffat.til.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Administration homepage and general pages 
 * @author danielmoffat
 *
 */
@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		return "/admin/index";
	}
}
