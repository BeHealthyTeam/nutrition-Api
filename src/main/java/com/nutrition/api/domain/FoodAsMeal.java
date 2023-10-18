package com.nutrition.api.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class FoodAsMeal extends Food{
    private Double mealQuantity;
}
