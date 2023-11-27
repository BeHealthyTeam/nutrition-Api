package com.nutrition.api.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NutrientsWithUnity {

    private Double nutrientValue;
    private String nutrientMeasureUnity;

    public NutrientsWithUnity() {
        this.nutrientValue = 0.0;
        this.nutrientMeasureUnity = "g";
    }

}
