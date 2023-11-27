package com.nutrition.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class Meal{

    @Id
    @NotNull
    private String id;
    @NotNull
    private String userId;
    @NotNull
    private LocalDate date;
    @NotNull
    private String dayTurn;
    private List<FoodAsMeal> foodsMeal;
    private List<RecipeAsMeal> recipesMeal;

}
