package com.apolloproject.budget.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "budget")
public class Budget implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8430430317148514417L;

	@Id
	private long id;
	
	private long ownerId;
	
	private String name;
	private BigDecimal amount;
	private String description;
	
	private Date fromdate;
	private Date todate;
	
	private List<Entry> budgetEntries = new ArrayList<Entry>();
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}
	
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	
	public long getOwnerId() {
		return ownerId;
	}
	
	public void addEntry(Entry entry) {
		budgetEntries.add(entry);
	}
	
	public void removeEntry(Entry entry) {
		budgetEntries.remove(entry);
	}
	
}
