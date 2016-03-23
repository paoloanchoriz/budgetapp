package com.apolloproject.budget.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "budgetEntry")
public class BudgetEntry extends Entry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7909619842546570062L;

	private boolean isFixed;

	public boolean isFixed() {
		return isFixed;
	}

	public void setFixed(boolean isFixed) {
		this.isFixed = isFixed;
	}
	
}
