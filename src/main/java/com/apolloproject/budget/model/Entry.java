package com.apolloproject.budget.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.annotation.Id;


public class Entry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 667796086957428556L;
	
	@Id
	private BigInteger id;
	
	private String name;
	private String description;
	private String category;
	
	private BigDecimal amount;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean returnVal = false;
		if(o instanceof Entry) {
			returnVal = this.id.equals(((Entry) o).id);
		}
		return returnVal;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
