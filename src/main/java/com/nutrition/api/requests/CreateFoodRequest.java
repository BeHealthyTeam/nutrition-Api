package com.nutrition.api.requests;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateFoodRequest {
    private String name;
    @NotNull
    private Double energy;
    @NotNull
    private Double fiber;
    @NotNull
    private Double protein;
    @NotNull
    private Double lipids;
    @NotNull
    private Double cholesterol;
    @NotNull
    private Double carbo;
    @NotNull
    private Double calcium;
    @NotNull
    private Double magnesium;
    @NotNull
    private Double manganese;
    @NotNull
    private Double phosphor;
    @NotNull
    private Double iron;
    @NotNull
    private Double sodium;
    @NotNull
    private Double potassium;
    @NotNull
    private Double zinc;
    @NotNull
    private Double saturated;
    @NotNull
    private Double monounsaturated;
    @NotNull
    private Double polyunsaturated;
    @NotNull
    private Double b1;
    @NotNull
    private Double b2;
    @NotNull
    private Double b6;
    @NotNull
    private Double b3;
    @NotNull
    private Double vitaminC;
}
