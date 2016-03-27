package com.apolloproject.budget.model;

import java.io.Serializable;


public class BudgetEntry extends Entry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7909619842546570062L;

	private EntryType type;
	
	public void setFixed(boolean isFixed) {
		
	}
	
	public boolean isFixed() {
		return type == EntryType.FIXED;
	}
	
	public EntryType getType() {
		return type;
	}

	public void setType(EntryType type) {
		this.type = type;
	}
	
}
