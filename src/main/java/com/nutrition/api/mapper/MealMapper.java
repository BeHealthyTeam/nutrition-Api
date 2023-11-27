package com.nutrition.api.mapper;

import com.nutrition.api.domain.Meal;
import com.nutrition.api.requests.CreateMealRequest;

public class MealMapper {

    public static Meal toMeal(CreateMealRequest request){

        return Meal.builder()
                .date(request.getDate())
                .userId(request.getUserId())
                .dayTurn(request.getDayTurn())
                .foodsMeal(request.getFoodsMeal())
                .recipesMeal(request.getRecipesMeal())
                .build();
    }
}
