package com.nutrition.api.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    @Id
    @NotNull
    private String id;
    @NotNull
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
