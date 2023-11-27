package com.nutrition.api.requests;

import com.nutrition.api.domain.FoodAsMeal;
import com.nutrition.api.domain.RecipeAsMeal;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class CreateMealRequest {
    @NotNull
    private String userId;
    @NotNull
    private String dayTurn;
    @NotNull
    private LocalDate date;
    private List<FoodAsMeal> foodsMeal;
    private List<RecipeAsMeal> recipesMeal;
}
