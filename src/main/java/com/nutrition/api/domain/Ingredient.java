package com.nutrition.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Ingredient {

    private Food food;
    private double quantity;

}
