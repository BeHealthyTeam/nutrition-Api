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
import com.nutrition.api.utils.ConsumedNutrientsDTO;
import com.nutrition.api.utils.UserAuth;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NutritionService {

    private final FoodRepository foodRepository;

    private final RecipeRepository recipeRepository;

    private final MealRepository mealRepository;

    private final FoodMongoTemplateRepository foodMongoTemplateRepository;

    private final RecipeMongoTemplateRepository recipeMongoTemplateRepository;

    private final MealMongoTemplateRepository mealMongoTemplateRepository;

    public NutritionService(FoodRepository foodRepository, RecipeRepository recipeRepository, MealRepository mealRepository, FoodMongoTemplateRepository foodMongoTemplateRepository, RecipeMongoTemplateRepository recipeMongoTemplateRepository, MealMongoTemplateRepository mealMongoTemplateRepository) {
        this.foodRepository = foodRepository;
        this.recipeRepository = recipeRepository;
        this.mealRepository = mealRepository;
        this.foodMongoTemplateRepository = foodMongoTemplateRepository;
        this.recipeMongoTemplateRepository = recipeMongoTemplateRepository;
        this.mealMongoTemplateRepository = mealMongoTemplateRepository;
    }

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
    public List<Meal> findAllMealsByDate(LocalDate date){
        var email = UserAuth.get().getEmail();
        return mealMongoTemplateRepository.findAllByDate(date, email);
    }
    public List<Meal> findAllMealsByMonth(String yearAndMonth){
        var email = UserAuth.get().getEmail();
        return mealMongoTemplateRepository.findAllByMonth(yearAndMonth, email);
    }

    public ConsumedNutrientsDTO allNutrientsByMonth(String yearAndMonth){
        var email = UserAuth.get().getEmail();
        var meals = mealMongoTemplateRepository.findAllByMonth(yearAndMonth, email);

        return getConsumedNutrientsDTO(meals);

    }

    private ConsumedNutrientsDTO getConsumedNutrientsDTO(List<Meal> meals) {
        ConsumedNutrientsDTO consumed = ConsumedNutrientsDTO.getEmpty();

        meals.forEach(meal -> {
            var foodsList = meal.getFoodsMeal();
            var recipesList = meal.getRecipesMeal();
            foodsList.forEach(
                    foodAsMeal -> {
                        consumed.getEnergy().setNutrientValue(consumed.getEnergy().getNutrientValue()+foodAsMeal.getEnergy());
                        consumed.getEnergy().setNutrientMeasureUnity("Kcal");
                        consumed.getFiber().setNutrientValue(consumed.getFiber().getNutrientValue()+foodAsMeal.getFiber());
                        consumed.getProtein().setNutrientValue(consumed.getProtein().getNutrientValue()+foodAsMeal.getProtein());
                        consumed.getLipids().setNutrientValue(consumed.getLipids().getNutrientValue()+foodAsMeal.getLipids());
                        consumed.getCholesterol().setNutrientValue(consumed.getCholesterol().getNutrientValue()+foodAsMeal.getCholesterol());
                        consumed.getCholesterol().setNutrientMeasureUnity("mg");
                        consumed.getCarbo().setNutrientValue(consumed.getCarbo().getNutrientValue()+foodAsMeal.getCarbo());
                        consumed.getCalcium().setNutrientValue(consumed.getCalcium().getNutrientValue()+foodAsMeal.getCalcium());
                        consumed.getCalcium().setNutrientMeasureUnity("mg");
                        consumed.getMagnesium().setNutrientValue(consumed.getMagnesium().getNutrientValue()+foodAsMeal.getMagnesium());
                        consumed.getMagnesium().setNutrientMeasureUnity("mg");
                        consumed.getManganese().setNutrientValue(consumed.getManganese().getNutrientValue()+foodAsMeal.getManganese());
                        consumed.getManganese().setNutrientMeasureUnity("mg");
                        consumed.getPhosphor().setNutrientValue(consumed.getPhosphor().getNutrientValue()+foodAsMeal.getPhosphor());
                        consumed.getPhosphor().setNutrientMeasureUnity("mg");
                        consumed.getIron().setNutrientValue(consumed.getIron().getNutrientValue()+foodAsMeal.getIron());
                        consumed.getIron().setNutrientMeasureUnity("mg");
                        consumed.getSodium().setNutrientValue(consumed.getSodium().getNutrientValue()+foodAsMeal.getSodium());
                        consumed.getSodium().setNutrientMeasureUnity("mg");
                        consumed.getPotassium().setNutrientValue(consumed.getPotassium().getNutrientValue()+foodAsMeal.getPotassium());
                        consumed.getPotassium().setNutrientMeasureUnity("mg");
                        consumed.getZinc().setNutrientValue(consumed.getZinc().getNutrientValue()+foodAsMeal.getZinc());
                        consumed.getZinc().setNutrientMeasureUnity("mg");
                        consumed.getSaturated().setNutrientValue(consumed.getSaturated().getNutrientValue()+(foodAsMeal.getSaturated()));
                        consumed.getMonounsaturated().setNutrientValue(consumed.getMonounsaturated().getNutrientValue()+(foodAsMeal.getMonounsaturated()));
                        consumed.getPolyunsaturated().setNutrientValue(consumed.getPolyunsaturated().getNutrientValue()+(foodAsMeal.getPolyunsaturated()));
                        consumed.getB1().setNutrientValue(consumed.getB1().getNutrientValue()+foodAsMeal.getB1());
                        consumed.getB1().setNutrientMeasureUnity("mg");
                        consumed.getB2().setNutrientValue(consumed.getB2().getNutrientValue()+foodAsMeal.getB2());
                        consumed.getB2().setNutrientMeasureUnity("mg");
                        consumed.getB6().setNutrientValue(consumed.getB6().getNutrientValue()+foodAsMeal.getB6());
                        consumed.getB6().setNutrientMeasureUnity("mg");
                        consumed.getB3().setNutrientValue(consumed.getB3().getNutrientValue()+foodAsMeal.getB3());
                        consumed.getB3().setNutrientMeasureUnity("mg");
                        consumed.getVitaminC().setNutrientValue(consumed.getVitaminC().getNutrientValue()+foodAsMeal.getVitaminC());
                        consumed.getVitaminC().setNutrientMeasureUnity("mg");
                    });
            recipesList.forEach(
                    recipeAsMeal -> recipeAsMeal.getIngredients().forEach(
                            ingredient -> {
                                consumed.getEnergy().setNutrientValue(consumed.getEnergy().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getEnergy(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getEnergy().setNutrientMeasureUnity("Kcal");
                                consumed.getFiber().setNutrientValue(consumed.getFiber().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getFiber(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getProtein().setNutrientValue(consumed.getProtein().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getProtein(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getLipids().setNutrientValue(consumed.getLipids().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getLipids(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getCholesterol().setNutrientValue(consumed.getCholesterol().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getCholesterol(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getCarbo().setNutrientValue(consumed.getCarbo().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getCarbo(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getCalcium().setNutrientValue(consumed.getCalcium().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getCalcium(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getCalcium().setNutrientMeasureUnity("mg");
                                consumed.getMagnesium().setNutrientValue(consumed.getMagnesium().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getMagnesium(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getMagnesium().setNutrientMeasureUnity("mg");
                                consumed.getManganese().setNutrientValue(consumed.getManganese().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getManganese(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getManganese().setNutrientMeasureUnity("mg");
                                consumed.getPhosphor().setNutrientValue(consumed.getPhosphor().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getPhosphor(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getPhosphor().setNutrientMeasureUnity("mg");
                                consumed.getIron().setNutrientValue(consumed.getIron().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getIron(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getIron().setNutrientMeasureUnity("mg");
                                consumed.getSodium().setNutrientValue(consumed.getSodium().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getSodium(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getSodium().setNutrientMeasureUnity("mg");
                                consumed.getPotassium().setNutrientValue(consumed.getPotassium().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getPotassium(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getPotassium().setNutrientMeasureUnity("mg");
                                consumed.getZinc().setNutrientValue(consumed.getZinc().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getZinc(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getZinc().setNutrientMeasureUnity("mg");
                                consumed.getSaturated().setNutrientValue(consumed.getSaturated().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getSaturated(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getMonounsaturated().setNutrientValue(consumed.getMonounsaturated().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getMonounsaturated(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getPolyunsaturated().setNutrientValue(consumed.getPolyunsaturated().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getPolyunsaturated(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getB1().setNutrientValue(consumed.getB1().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getB1(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getB1().setNutrientMeasureUnity("mg");
                                consumed.getB2().setNutrientValue(consumed.getB2().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getB2(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getB2().setNutrientMeasureUnity("mg");
                                consumed.getB6().setNutrientValue(consumed.getB6().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getB6(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getB6().setNutrientMeasureUnity("mg");
                                consumed.getB3().setNutrientValue(consumed.getB3().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getB3(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getB3().setNutrientMeasureUnity("mg");
                                consumed.getVitaminC().setNutrientValue(consumed.getVitaminC().getNutrientValue() +
                                        (totalOfPropertyInRecipe(ingredient.getVitaminC(), ingredient.getQuantity(), recipeAsMeal.getMealQuantity(), recipeAsMeal.getTotalWeigth()))
                                );
                                consumed.getVitaminC().setNutrientMeasureUnity("mg");

                            }));
        });
        return consumed;
    }

    public ConsumedNutrientsDTO allNutrientsByWeek(String yearAndMonth, Integer week){
        var email = UserAuth.get().getEmail();
        var meals = mealMongoTemplateRepository.findAllByWeek(yearAndMonth, email, week);

        return getConsumedNutrientsDTO(meals);

    }
    public Double totalOfPropertyInRecipe(Double ingredientTableValue, Double quantityOfIngredientInRecipe, Double cosumedRecipeWeight, Double totalRecipeWeigth){
        Double quantityOfIngredientByOneHundredPercent = quantityOfIngredientInRecipe/100;
        double quantityOfRecipeCosumed = totalRecipeWeigth/cosumedRecipeWeight;

        return (quantityOfIngredientByOneHundredPercent * ingredientTableValue)/quantityOfRecipeCosumed;
    }

}
