package com.apolloproject.budget.model;

public enum RepeatIntervalType {
	MONTHLY("Monthly"), DAILY("Daily"), WEEKLY("Weekly"), NON_REPEATING("None");
	
	public String description;
	private RepeatIntervalType(String description) {
		this.description = description;
	}
}
