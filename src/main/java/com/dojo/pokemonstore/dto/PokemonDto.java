package com.dojo.pokemonstore.dto;

import com.dojo.pokemonstore.domain.Pokemon;
import com.dojo.pokemonstore.domain.PokemonType;

/**
 * Created by scapillier on 09/05/17.
 */
public class PokemonDto {

    Integer id;
    String name;
    Double weight;
    Double height;
    PokemonType pokemonType;
    String imageUrl;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }
    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public PokemonDto() {}

    public PokemonDto(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.weight = pokemon.getWeight();
        this.height = pokemon.getHeight();
        this.pokemonType = pokemon.getPokemonType();
        this.imageUrl = pokemon.getImageUrl();
    }
}
