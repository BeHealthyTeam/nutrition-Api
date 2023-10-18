package com.nutrition.api.repository;

import com.nutrition.api.domain.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class MealMongoTemplateRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Meal> findAllByDate(Date date) {
        Query query = new Query(Criteria.where("date").regex(date.toString(), "i"));
        return mongoTemplate.find(query, Meal.class);
    }

}
