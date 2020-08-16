package com.bapadua.demo.repository;

import com.bapadua.demo.model.Pokemon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PokeDexRepository extends ReactiveMongoRepository <Pokemon, String> {

}
