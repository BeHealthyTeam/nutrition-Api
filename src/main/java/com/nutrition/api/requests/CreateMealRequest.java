package com.nutrition.api.requests;

import com.nutrition.api.domain.FoodAsMeal;
import com.nutrition.api.domain.RecipeAsMeal;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class CreateMealRequest {
    @NotNull
    private String dayTurn;
    @NotNull
    private Date date;
    private List<FoodAsMeal> foodsMeal;
    private List<RecipeAsMeal> recipesMeal;
}
