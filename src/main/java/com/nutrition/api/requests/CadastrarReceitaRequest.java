package com.nutrition.api.requests;

import com.nutrition.api.domain.Ingrediente;
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
