package com.apolloproject.budget.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apolloproject.budget.model.BudgetEntry;

public interface SampleRepository extends MongoRepository<BudgetEntry, Long> {

}
