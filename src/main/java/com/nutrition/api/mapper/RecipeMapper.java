package com.nutrition.api.mapper;

import com.nutrition.api.domain.Ingredient;
import com.nutrition.api.domain.Recipe;
import com.nutrition.api.requests.CreateRecipeRequest;

public class RecipeMapper {

    public static Recipe toRecipe(CreateRecipeRequest request){
        Double totalWeight = request.getIngredients().stream().mapToDouble(Ingredient::getQuantity).sum();
        return Recipe.builder()
                .name(request.getName())
                .ingredients(request.getIngredients())
                .totalWeigth(totalWeight)
                .build();
    }
}
