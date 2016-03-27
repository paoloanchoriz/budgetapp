package com.apolloproject.budget.controllers;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apolloproject.budget.model.Budget;
import com.apolloproject.budget.model.BudgetEntry;
import com.apolloproject.budget.model.EntryType;
import com.apolloproject.budget.repositories.BudgetRepository;

@Controller
@RequestMapping("/budgetEntry")
public class BudgetEntryController {
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	@RequestMapping(value ="/{budgetId}", method = RequestMethod.GET)
	public String addEntry(@PathVariable(value = "budgetId") BigInteger budgetId, Model model) {
		Budget budget = budgetRepository.findOne(budgetId);
		BudgetEntry budgetEntry = new BudgetEntry();
		budgetEntry.setType(EntryType.FIXED);
		model.addAttribute("budgetEntry", budgetEntry);
		model.addAttribute("budget", budget);
		return "expenseAllocationForm";
	}
	
	@RequestMapping(value = "/{budgetId}", method = RequestMethod.POST)
	public String addEntry(@PathVariable(value = "budgetId") BigInteger budgetId,
			@ModelAttribute("budgetEntry") BudgetEntry entry, BindingResult result, Model model) {
		Budget budget = budgetRepository.findOne(budgetId);
		budgetRepository.save(budget);
		return "redirect:/budget/" + String.valueOf(budget.getId());
	}
	
}
