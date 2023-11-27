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
