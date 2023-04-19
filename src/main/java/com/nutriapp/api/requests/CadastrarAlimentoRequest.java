package com.nutriapp.api.requests;

import lombok.Data;
import lombok.NonNull;
@Data
public class CadastrarAlimentoRequest {

    @NonNull
    private String nome;
    @NonNull
    private String unidade;
    @NonNull
    private float energia;
    @NonNull
    private float fibra;
    @NonNull
    private float proteina;
    @NonNull
    private float lipideos;
    @NonNull
    private float colesterol;
    @NonNull
    private float carbo;
    @NonNull
    private float calcio;
    @NonNull
    private float magnesio;
    @NonNull
    private float manganes;
    @NonNull
    private float fosforo;
    @NonNull
    private float ferro;
    @NonNull
    private float sodio;
    @NonNull
    private float potassio;
    @NonNull
    private float zinco;
    @NonNull
    private float saturados;
    @NonNull
    private float mono;
    @NonNull
    private float poli;
    @NonNull
    private float b12;
    @NonNull
    private float b2;
    @NonNull
    private float b6;
    @NonNull
    private float b3;
    @NonNull
    private float vitaminaC;
}
