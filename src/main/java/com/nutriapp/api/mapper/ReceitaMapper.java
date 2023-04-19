package com.nutriapp.api.mapper.nutricao;

import com.nutriapp.api.domain.nutricao.Alimento;
import com.nutriapp.api.domain.nutricao.Receita;
import com.nutriapp.api.requests.CadastrarReceitaRequest;

import java.util.ArrayList;

public class ReceitaMapper {
    public static Receita toReceita(CadastrarReceitaRequest request){
        return Receita.builder()
                .nome(request.getNome())
                .ingredientes(request.getIngredientes())
                .build();
    }
}
