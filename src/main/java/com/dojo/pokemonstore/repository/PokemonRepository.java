package com.dojo.pokemonstore.repository;

import com.dojo.pokemonstore.domain.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    List<Pokemon> findAllByOrderByName();
}
