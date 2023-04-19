package com.nutriapp.api.domain.nutricao;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Receita{

    @Id
    private String id;
    @NonNull
    private String nome;
    private List<Ingrediente> ingredientes;

}
