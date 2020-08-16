package com.bapadua.demo;

import com.bapadua.demo.model.Pokemon;
import com.bapadua.demo.repository.PokeDexRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class PokedexNeriApplication {

	public static void main(String[] args) {

		SpringApplication.run(PokedexNeriApplication.class, args);	}

		@Bean
	CommandLineRunner init (ReactiveMongoOperations operations,
							PokeDexRepository repository) {
		return args -> {
			Flux<Pokemon> pokedex =Flux.just(
					new Pokemon(null, "Pikachu", "Eletric", "Thundershock", 4.5),
					new Pokemon(null, "Charizard", "Fire", "Flameshot", 4.5)
			).flatMap(repository::save);

			pokedex.thenMany(repository.findAll())
					.subscribe(System.out::println);
		};
	}
}
