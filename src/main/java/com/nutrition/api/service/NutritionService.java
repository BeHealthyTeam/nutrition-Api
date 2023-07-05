package com.nutrition.api.service;

import com.nutrition.api.domain.Food;
import com.nutrition.api.domain.Recipe;
import com.nutrition.api.mapper.FoodMapper;
import com.nutrition.api.mapper.RecipeMapper;
import com.nutrition.api.repository.FoodMongoTemplateRepository;
import com.nutrition.api.repository.FoodRepository;
import com.nutrition.api.repository.RecipeRepository;
import com.nutrition.api.repository.MealRepository;
import com.nutrition.api.requests.CreateFoodRequest;
import com.nutrition.api.requests.CreateRecipeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
