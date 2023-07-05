package com.nutrition.api.requests;

import com.nutrition.api.domain.Ingredient;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CreateRecipeRequest {

    @NotNull
    private String name;
    @NotNull
    private List<Ingredient> ingredients;

}
