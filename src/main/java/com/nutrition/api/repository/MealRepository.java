package com.nutrition.api.repository;

import com.nutrition.api.domain.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MealRepository extends MongoRepository<Meal, String> {
}
