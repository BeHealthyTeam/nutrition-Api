package com.nutriapp.api.domain.nutricao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class  Ingrediente {

    private Alimento alimento;
    private double quantidade;

}
