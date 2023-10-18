package com.nutrition.api.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeAsMeal extends Recipe{
    private Double mealQuantity;
}
