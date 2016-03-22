package com.apolloproject.budget.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apolloproject.budget.model.Budget;

public interface SampleRepository extends MongoRepository<Budget, Long> {

}
