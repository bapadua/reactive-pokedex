package com.bapadua.demo.services;

import com.bapadua.demo.model.Pokemon;
import com.bapadua.demo.repository.PokeDexRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PokedexService {
    private final PokeDexRepository repository;

    public PokedexService(PokeDexRepository repository) {
        this.repository = repository;
    }

    public Mono<Pokemon> save(Pokemon pokemon) {
        return repository.save(pokemon);
    }

    public Flux<Pokemon> list() {
        return repository.findAll();
    }

    public Mono<Pokemon> findById(final String id) {
        return repository.findById(id);
    }
}
