package com.nutrition.api.repository;

import com.nutrition.api.domain.Food;
import org.springframework.data.mongodb.repository.ExistsQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FoodRepository extends MongoRepository<Food, String> {
    @ExistsQuery("{ 'word' : ?0}")
    boolean existsByWord(String word);

    @Query("{s:'?0'}")
    List<Food> findByNameStartsWith(String s);
}
