package com.dojo.pokemonstore.rest;

import com.dojo.pokemonstore.domain.Pokemon;
import com.dojo.pokemonstore.dto.PokemonDto;
import com.dojo.pokemonstore.repository.PokemonRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pokemons")
@Api(value = "API to search pokemons",
        description = "This API provides the capability to search pokemon all over the world", produces = "application/json")
public class PokemonRestController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @ApiOperation(value = "Create pokemon", produces = "application/json")
    @RequestMapping(method = RequestMethod.POST, path = "/", consumes = "application/json", produces = "application/json")
    public PokemonDto create(@RequestBody Pokemon pokemon) {
        pokemon = pokemonRepository.save(pokemon);
        PokemonDto pokemonDto = new PokemonDto(pokemon);
        return pokemonDto;
    }

    @ApiOperation(value = "Get list of the pokemons in the store", produces = "application/json")
    @RequestMapping(method = RequestMethod.GET, path = "/list", consumes = "application/json", produces = "application/json")
    public Page<Pokemon> list(Pageable pageable) {
        Page<Pokemon> pokemons = pokemonRepository.findAll(pageable);
        return pokemons;
    }
}
