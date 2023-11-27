package com.nutrition.api.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @NotNull
    private String id;
    @NotNull
    private String name;
    private List<Ingredient> ingredients;
    private Double totalWeigth;

}
