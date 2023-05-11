package com.nutrition.api.mapper;

import com.nutrition.api.requests.CadastrarAlimentoRequest;
import com.nutrition.api.domain.Alimento;

public class AlimentoMapper {

    public static Alimento toAlimento(CadastrarAlimentoRequest request) {
        return Alimento.builder()
                .nome(request.getNome())
                .unidade(request.getUnidade())
                .energia(request.getEnergia())
                .fibra(request.getFibra())
                .proteina(request.getProteina())
                .lipideos(request.getLipideos())
                .colesterol(request.getColesterol())
                .carbo(request.getCarbo())
                .calcio(request.getCalcio())
                .magnesio(request.getMagnesio())
                .manganes(request.getManganes())
                .fosforo(request.getFosforo())
                .ferro(request.getFerro())
                .sodio(request.getSodio())
                .potassio(request.getPotassio())
                .zinco(request.getZinco())
                .saturados(request.getSaturados())
                .mono(request.getMono())
                .poli(request.getPoli())
                .b12(request.getB12())
                .b2(request.getB2())
                .b6(request.getB6())
                .b3(request.getB3())
                .vitaminaC(request.getVitaminaC())
                .build();
    }
}
