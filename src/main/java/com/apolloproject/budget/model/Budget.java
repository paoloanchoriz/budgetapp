package com.apolloproject.budget.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "budget")
public class Budget implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8430430317148514417L;
	
	private static final SimpleDateFormat GLOBAL_DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
	
	@Id
	private BigInteger id;
	
	private BigInteger ownerId;
	
	private String name;
	private BigDecimal allocation;
	private String description;
	
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date fromdate;
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	private Date todate;
	
	private List<BudgetEntry> budgetEntries = new ArrayList<BudgetEntry>();
	private List<ActualEntry> actualEntries = new ArrayList<ActualEntry>();
	
	private RepeatIntervalType intervalType;
	
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
	
	public BigDecimal getAllocation() {
		return allocation;
	}

	public void setAllocation(BigDecimal allocation) {
		this.allocation = allocation;
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
	
	public void setOwnerId(BigInteger ownerId) {
		this.ownerId = ownerId;
	}
	
	public BigInteger getOwnerId() {
		return ownerId;
	}
	
	public void addBudgetEntry(BudgetEntry entry) {
		budgetEntries.add(entry);
	}
	
	public void removeBudgetEntry(BudgetEntry entry) {
		budgetEntries.remove(entry);
	}
	
	public void addActualEntry(ActualEntry entry) {
		actualEntries.add(entry);
	}
	
	public void removeActualEntry(ActualEntry entry) {
		actualEntries.remove(entry);
	}

	public RepeatIntervalType getIntervalType() {
		return intervalType;
	}

	public void setIntervalType(RepeatIntervalType intervalType) {
		this.intervalType = intervalType;
	}
	
	public String getInclusiveDates() {
		StringBuilder sb = new StringBuilder();
		boolean isFromAvailable = fromdate != null;
		boolean isToAvailable = todate != null;
		
		if(!isFromAvailable && !isToAvailable) {
			sb.append("N/A");
		} else {
			if(isFromAvailable) {
				sb.append(GLOBAL_DATE_FORMAT.format(fromdate));
			}
			
			if(isFromAvailable && isToAvailable) {
				sb.append(" to ");
			}
			
			if(isToAvailable) {
				sb.append(GLOBAL_DATE_FORMAT.format(todate));
			}
		}
		return sb.toString();
	}
}
