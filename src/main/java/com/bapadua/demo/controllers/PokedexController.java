package com.bapadua.demo.controllers;

import com.bapadua.demo.model.Pokemon;
import com.bapadua.demo.records.PokemonDTO;
import com.bapadua.demo.services.PokedexService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("pokemons")
public class PokedexController {

    private final PokedexService service;

    public PokedexController(PokedexService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Flux<Pokemon>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<Pokemon>> findById(@PathVariable("id") String id) {
        return service.findById(id)
        .map(pokemon -> ResponseEntity.ok(pokemon))
        .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<Pokemon> savePokemon(@RequestBody PokemonDTO pokemon) {
        return service.save(pokemon.toEntity());
    }

}
