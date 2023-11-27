package com.nutrition.api.mapper;

import com.nutrition.api.requests.CreateFoodRequest;
import com.nutrition.api.domain.Food;

public class FoodMapper {

    public static Food toFood(CreateFoodRequest request) {
        return Food.builder()
                .name(request.getName())
                .energy(request.getEnergy())
                .fiber(request.getFiber())
                .protein(request.getProtein())
                .lipids(request.getLipids())
                .cholesterol(request.getCholesterol())
                .carbo((request.getCarbo()))
                .calcium(request.getCalcium())
                .magnesium(request.getMagnesium())
                .manganese(request.getManganese())
                .phosphor(request.getPhosphor())
                .iron(request.getIron())
                .sodium(request.getSodium())
                .potassium(request.getPotassium())
                .zinc(request.getZinc())
                .saturated(request.getSaturated())
                .monounsaturated(request.getMonounsaturated())
                .polyunsaturated(request.getPolyunsaturated())
                .b1(request.getB1())
                .b2(request.getB2())
                .b6(request.getB6())
                .b3(request.getB3())
                .vitaminC(request.getVitaminC())
                .build();
    }
}
