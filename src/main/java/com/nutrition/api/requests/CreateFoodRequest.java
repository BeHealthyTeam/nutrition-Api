package com.nutrition.api.requests;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
public class CreateFoodRequest {
    private String name;
    @NotNull
    private String unity;
    @NotNull
    private float energy;
    @NotNull
    private float fiber;
    @NotNull
    private float protein;
    @NotNull
    private float lipids;
    @NotNull
    private float cholesterol;
    @NotNull
    private float carbo;
    @NotNull
    private float calcium;
    @NotNull
    private float magnesium;
    @NotNull
    private float manganese;
    @NotNull
    private float phosphor;
    @NotNull
    private float iron;
    @NotNull
    private float sodium;
    @NotNull
    private float potassium;
    @NotNull
    private float zinc;
    @NotNull
    private float saturated;
    @NotNull
    private float monounsaturated;
    @NotNull
    private float polyunsaturated;
    @NotNull
    private float b12;
    @NotNull
    private float b2;
    @NotNull
    private float b6;
    @NotNull
    private float b3;
    @NotNull
    private float vitaminC;
}
