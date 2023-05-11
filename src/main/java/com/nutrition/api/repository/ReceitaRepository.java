package com.nutrition.api.repository;

import com.nutrition.api.domain.Receita;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository  extends MongoRepository<Receita, String> {
}
