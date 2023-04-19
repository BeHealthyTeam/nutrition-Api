package com.nutriapp.api.repository;

import com.nutriapp.api.domain.nutricao.Receita;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository  extends MongoRepository<Receita, String> {
}
