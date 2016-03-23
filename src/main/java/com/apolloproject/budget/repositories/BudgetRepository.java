package com.apolloproject.budget.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apolloproject.budget.model.Budget;

public interface BudgetRepository extends MongoRepository<Budget, BigInteger> {
	
	public List<Budget> findByOwnerId(BigInteger ownerId);
	
}
