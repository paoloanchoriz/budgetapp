package com.apolloproject.budget.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apolloproject.budget.model.Budget;

@Controller
@RequestMapping("/budget")
public class BudgetController {
	
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String budgetPage(Model model) {
		model.addAttribute("budgetEntry", new Budget());
		return "budget";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String budgetPage(@ModelAttribute(value = "budget") Budget budget, 
			BindingResult result, Model model) {
		
		
		return "redirect:/budget";
	}
}
