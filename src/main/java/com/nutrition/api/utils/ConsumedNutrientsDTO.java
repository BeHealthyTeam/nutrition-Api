package com.nutrition.api.utils;

import lombok.*;

@Getter
@Setter
@Builder
public class ConsumedNutrientsDTO {

    private NutrientsWithUnity energy;
    private NutrientsWithUnity fiber;
    private NutrientsWithUnity protein;
    private NutrientsWithUnity lipids;
    private NutrientsWithUnity cholesterol;
    private NutrientsWithUnity carbo;
    private NutrientsWithUnity calcium;
    private NutrientsWithUnity magnesium;
    private NutrientsWithUnity manganese;
    private NutrientsWithUnity phosphor;
    private NutrientsWithUnity iron;
    private NutrientsWithUnity sodium;
    private NutrientsWithUnity potassium;
    private NutrientsWithUnity zinc;
    private NutrientsWithUnity saturated;
    private NutrientsWithUnity monounsaturated;
    private NutrientsWithUnity polyunsaturated;
    private NutrientsWithUnity b1;
    private NutrientsWithUnity b2;
    private NutrientsWithUnity b6;
    private NutrientsWithUnity b3;
    private NutrientsWithUnity vitaminC;

    public static ConsumedNutrientsDTO getEmpty(){
        return ConsumedNutrientsDTO.builder()
                .energy(new NutrientsWithUnity())
                .fiber(new NutrientsWithUnity())
                .protein(new NutrientsWithUnity())
                .lipids(new NutrientsWithUnity())
                .cholesterol(new NutrientsWithUnity())
                .carbo(new NutrientsWithUnity())
                .calcium(new NutrientsWithUnity())
                .magnesium(new NutrientsWithUnity())
                .manganese(new NutrientsWithUnity())
                .phosphor(new NutrientsWithUnity())
                .iron(new NutrientsWithUnity())
                .sodium(new NutrientsWithUnity())
                .potassium(new NutrientsWithUnity())
                .zinc(new NutrientsWithUnity())
                .saturated(new NutrientsWithUnity())
                .monounsaturated(new NutrientsWithUnity())
                .polyunsaturated(new NutrientsWithUnity())
                .b1(new NutrientsWithUnity())
                .b2(new NutrientsWithUnity())
                .b6(new NutrientsWithUnity())
                .b3(new NutrientsWithUnity())
                .vitaminC(new NutrientsWithUnity())
                .build();
    }

}
