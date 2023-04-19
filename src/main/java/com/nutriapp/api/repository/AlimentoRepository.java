package com.nutriapp.api.repository;

import com.nutriapp.api.domain.nutricao.Alimento;
import org.springframework.data.mongodb.repository.ExistsQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlimentoRepository extends MongoRepository<Alimento, String> {
    @ExistsQuery("{ 'word' : ?0}")
    boolean existsByWord(String word);

    @Query("{s:'?0'}")
    List<Alimento> findByNameStartsWith(String s);
}
