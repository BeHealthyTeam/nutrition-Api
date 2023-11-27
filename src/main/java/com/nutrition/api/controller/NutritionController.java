package com.nutrition.api.controller;

import com.nutrition.api.domain.Meal;
import com.nutrition.api.requests.CreateFoodRequest;
import com.nutrition.api.domain.Food;
import com.nutrition.api.domain.Recipe;
import com.nutrition.api.requests.CreateMealRequest;
import com.nutrition.api.requests.CreateRecipeRequest;
import com.nutrition.api.service.NutritionService;
import javax.validation.Valid;

import com.nutrition.api.utils.ConsumedNutrientsDTO;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/nutrition")
public class NutritionController {

    private final NutritionService nutritionService;
    public NutritionController(NutritionService nutritionService){
        this.nutritionService = nutritionService;
    }

    // FOODS
    @PostMapping("/food")
    public void createFood(@Valid @RequestBody CreateFoodRequest request){
        nutritionService.createFood(request);
    };

    @GetMapping("/food")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Food> getAllFoods() {
        return nutritionService.getAllFoods();
    }

    @GetMapping("/food/{charOrWord}")
    public List<Food> searchFood(@PathVariable String charOrWord) {
        return nutritionService.searchFood(charOrWord);
    }

    // RECIPES
    @PostMapping("/recipe")
    public void createRecipe(@Valid @RequestBody CreateRecipeRequest request){
        nutritionService.createRecipe(request);
    };
    @GetMapping("/recipe")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Recipe> getAllRecipes() {
        return nutritionService.getAllRecipes();
    }

    @GetMapping("/recipe/{charOrWord}")
    public List<Recipe> searchRecipe(@PathVariable String charOrWord) {
        return nutritionService.searchRecipe(charOrWord);
    }

    // MEALS
    @PostMapping("/meal")
    public void createMeal(@Valid @RequestBody CreateMealRequest request){
        nutritionService.createMeal(request);
    };

    @GetMapping("/meal")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Meal> getAllMeals() {
        return nutritionService.getAllMeals();
    }

    @GetMapping("/meal/{date}")
    public List<Meal> searchMealByDate(@PathVariable("date") LocalDate date) {
        return nutritionService.findAllMealsByDate(date);
    }

    @GetMapping("/meal/calendar/{yearAndMonth}")
    public List<Meal> searchMealByMonth(@PathVariable("yearAndMonth") String yearAndMonth) {
        return nutritionService.findAllMealsByMonth(yearAndMonth);
    }

    @GetMapping("/report/consumedNutrientsByMonth/{yearAndMonth}")
    public ConsumedNutrientsDTO consumedNutrientsInMonth(@PathVariable("yearAndMonth") String yearAndMonth){
        return nutritionService.allNutrientsByMonth(yearAndMonth);
    }
    @GetMapping("/report/consumedNutrientsByWeek/{yearAndMonth}/{week}")
    public ConsumedNutrientsDTO consumedNutrientsInWeek(@PathVariable("yearAndMonth") String yearAndMonth, @PathVariable("week") Integer week){
        return nutritionService.allNutrientsByWeek(yearAndMonth, week);
    }
}
