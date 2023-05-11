package com.nutrition.api.repository;

import com.nutrition.api.domain.Refeicao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RefeicaoRepository extends MongoRepository<Refeicao, String> {
}
