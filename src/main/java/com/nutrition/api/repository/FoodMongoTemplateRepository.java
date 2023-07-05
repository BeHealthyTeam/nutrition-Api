package com.nutrition.api.repository;

import com.nutrition.api.domain.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoodMongoTemplateRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Food> findAllByName(String nameSubstring) {
        Query query = new Query(Criteria.where("name").regex(nameSubstring, "i"));
        return mongoTemplate.find(query, Food.class);
    }

}
