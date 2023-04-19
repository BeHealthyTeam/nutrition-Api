package com.nutriapp.api.repository;

import com.nutriapp.api.domain.nutricao.Refeicao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RefeicaoRepository extends MongoRepository<Refeicao, String> {
}
