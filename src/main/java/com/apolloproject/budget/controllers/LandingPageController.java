package com.apolloproject.budget.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apolloproject.budget.model.BudgetEntry;
import com.apolloproject.budget.repositories.SampleRepository;

@Controller
public class LandingPageController {

	@Autowired
	private SampleRepository sampleRepository;
	
	@RequestMapping("/")
	public String hello(
			@RequestParam(name = "name", required = false, defaultValue = "Benedict")String name, 
			Model model) {
		BudgetEntry budgetEntry = sampleRepository.findOne(12345l);
		System.out.println(budgetEntry.getDescription());
		System.out.println(budgetEntry.getName());
		
		model.addAttribute("name", name);
		return "landingPage";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
}
