package com.nutriapp.api.requests;

import com.nutriapp.api.domain.nutricao.Alimento;
import com.nutriapp.api.domain.nutricao.Ingrediente;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class CadastrarReceitaRequest {

    @NonNull
    private String nome;
    @NonNull
    private List<Ingrediente> ingredientes;

}
