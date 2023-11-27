package com.nutrition.api.repository;

import com.nutrition.api.domain.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Repository
public class MealMongoTemplateRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Meal> findAllByDate(LocalDate date, String email) {
        LocalDate endDate = date.plusDays(1).atStartOfDay().toLocalDate();
        Query query = new Query(Criteria.where("date").gte(date).lt(endDate).and("userId").is(email));
        return mongoTemplate.find(query, Meal.class);
    }
    public List<Meal> findAllByMonth(String yearAndMonth, String email) {
        String[] splitedYearAndMonth = yearAndMonth.split("-");
        int year = Integer.parseInt(splitedYearAndMonth[0]);
        int month = Integer.parseInt(splitedYearAndMonth[1]);

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);

        Query query = new Query(Criteria.where("date").gte(startDate).lte(endDate).and("userId").is(email));
        return mongoTemplate.find(query, Meal.class);
    }
    public List<Meal> findAllByWeek(String yearAndMonth, String email, Integer week) {
        String[] splitedYearAndMonth = yearAndMonth.split("-");
        int year = Integer.parseInt(splitedYearAndMonth[0]);
        int month = Integer.parseInt(splitedYearAndMonth[1]);

        LocalDate startDate = LocalDate.of(year, month, 1+(week*7));
        LocalDate endDate = startDate.plusDays(7);
        LocalDate firstDayOfWeek = startDate
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                .with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));


        Query query = new Query(Criteria.where("date").gte(firstDayOfWeek).lte(endDate).and("userId").is(email));
        return mongoTemplate.find(query, Meal.class);
    }
}
