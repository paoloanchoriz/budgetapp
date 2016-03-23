package com.apolloproject.budget.controllers;

import java.math.BigInteger;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apolloproject.budget.model.Budget;
import com.apolloproject.budget.repositories.BudgetRepository;

@Controller
@RequestMapping("/budget")
public class BudgetController {

	@Autowired
	private BudgetRepository budgetRepository;
	
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String budgetEditPage(@PathVariable(value = "id") BigInteger id, Model model) {
		Budget budget = budgetRepository.findOne(id);
		model.addAttribute("budget", budget);
		return "budgetForm";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String budgetPage(Model model) {
		model.addAttribute("budget", new Budget());
		return "budgetForm";
	}
	
	@RequestMapping(method = RequestMethod.POST, params = "action = save")
	public String budgetPage(@ModelAttribute(value = "budget") Budget budget, 
			BindingResult result, Model model) {
		budgetRepository.save(budget);
		return "redirect:/budget/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String budgetList(Model model) {
		BigInteger userId = new BigInteger("123456789"); // TODO: Replace with user Id
		List<Budget> budgetList = budgetRepository.findByOwnerId(userId);
		model.addAttribute("budgetList", budgetList);
		return "budgetList";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String budgetPage(@PathVariable(value = "id") BigInteger id, Model model) {
		Budget budget = budgetRepository.findOne(id);
		model.addAttribute("budget", budget);
		return "budget";
	}
}
