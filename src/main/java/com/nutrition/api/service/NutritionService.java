package com.nutrition.api.service;

import com.nutrition.api.domain.Food;
import com.nutrition.api.domain.Meal;
import com.nutrition.api.domain.Recipe;
import com.nutrition.api.mapper.FoodMapper;
import com.nutrition.api.mapper.MealMapper;
import com.nutrition.api.mapper.RecipeMapper;
import com.nutrition.api.repository.*;
import com.nutrition.api.requests.CreateFoodRequest;
import com.nutrition.api.requests.CreateMealRequest;
import com.nutrition.api.requests.CreateRecipeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NutritionService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private FoodMongoTemplateRepository foodMongoTemplateRepository;

    @Autowired
    private RecipeMongoTemplateRepository recipeMongoTemplateRepository;

    @Autowired
    private MealMongoTemplateRepository mealMongoTemplateRepository;

    public void createFood(CreateFoodRequest request) {
        Food food = FoodMapper.toFood(request);
        foodRepository.save(food);

    }
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }
    public List<Food> searchFood(String charOrWord) {
        return foodMongoTemplateRepository.findAllByName(charOrWord);
    }


    public void createRecipe(CreateRecipeRequest request) {
        Recipe recipe = RecipeMapper.toRecipe(request);
        recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    public List<Recipe> searchRecipe(String charOrWord) {
        return recipeMongoTemplateRepository.findAllByName(charOrWord);
    }

    public void createMeal(CreateMealRequest request){
        Meal meal = MealMapper.toMeal(request);
        mealRepository.save(meal);
    }
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }
    public List<Meal> findAllMealsByDate(Date date){
        return mealMongoTemplateRepository.findAllByDate(date);
    }


}
