package com.dojo.pokemonstore.web;

import com.dojo.pokemonstore.domain.Pokemon;
import com.dojo.pokemonstore.dto.PokemonDto;
import com.dojo.pokemonstore.repository.PokemonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

    private static final Logger logger = LoggerFactory.getLogger(PokemonController.class);

    @Autowired
    private PokemonRepository pokemonRepository;

    @RequestMapping(method= RequestMethod.GET)
    public String display(@RequestParam(name="id", required=false) Integer id, Model model) {
        Pokemon pokemon;
        if (id != null) {
            pokemon = pokemonRepository.findOne(id);
        }
        else {
            pokemon = new Pokemon();
        }
        model.addAttribute("pokemon",pokemon);
        return "pokemonDetail";
    }

    @RequestMapping(method=RequestMethod.GET, path = "/add")
    public String add(Model model) {
        Pokemon pokemon = new Pokemon();
        model.addAttribute("pokemon", pokemon);
        return "pokemonAdd";
    }

    @RequestMapping(method=RequestMethod.POST, path="/add")
    public String createPokemon(@Valid Pokemon pokemon, Errors errors) {
        if (errors.hasErrors()) {
            return "pokemonAdd";
        }
        logger.info("Création du pokemon '{}'", pokemon.getName());
        pokemonRepository.save(pokemon);
        return "home";
    }

    @RequestMapping(method= RequestMethod.GET, path = "/list")
    public String list(Model model) {
        List<Pokemon> pokemons = pokemonRepository.findAllByOrderByName();
        model.addAttribute("pokemons", pokemons.stream().map(pokemon -> new PokemonDto(pokemon)).collect(Collectors.toList()));
        return "pokemonList";
    }
}
