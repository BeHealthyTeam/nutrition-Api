package com.nutrition.api.mapper;

import com.nutrition.api.domain.Receita;
import com.nutrition.api.requests.CadastrarAlimentoRequest;
import com.nutrition.api.requests.CadastrarReceitaRequest;

public class ReceitaMapper {
    public static Receita toReceita(CadastrarReceitaRequest request){
        return Receita.builder()
                .nome(request.getNome())
                .ingredientes(request.getIngredientes())
                .build();
    }
}
