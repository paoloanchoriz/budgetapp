package com.apolloproject.budget.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "actualEntry")
public class ActualEntry extends Entry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2984133739638393307L;
	
	private long crossEntryId;

	public long getCrossEntryId() {
		return crossEntryId;
	}

	public void setCrossEntryId(long crossEntryId) {
		this.crossEntryId = crossEntryId;
	}
	
}
