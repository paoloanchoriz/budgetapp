package com.apolloproject.budget.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LandingPageController {

	@RequestMapping("/")
	public String hello(
			@RequestParam(name = "name", required = false, defaultValue = "Benedict")String name, 
			Model model) {
		model.addAttribute("name", name);
		return "landingPage";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
}
