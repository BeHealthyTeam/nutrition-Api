package com.nutrition.api.mapper;

import com.nutrition.api.domain.Recipe;
import com.nutrition.api.requests.CreateRecipeRequest;

public class RecipeMapper {

    public static Recipe toRecipe(CreateRecipeRequest request){
        return Recipe.builder()
                .name(request.getName())
                .ingredients(request.getIngredients())
                .build();
    }
}
