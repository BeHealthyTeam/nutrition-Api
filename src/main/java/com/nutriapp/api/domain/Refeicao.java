package com.nutriapp.api.domain.nutricao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor

public class Refeicao {
    private List<Receita> receitas;
    private List<Alimento> alimentos;

}
