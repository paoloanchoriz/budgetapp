package com.apolloproject.budget.model;

public enum EntryType {
	FIXED("Fixed"), VARIABLE("Variable");
	public final String description;
	private EntryType(String description) {
		this.description = description;
	}
}
