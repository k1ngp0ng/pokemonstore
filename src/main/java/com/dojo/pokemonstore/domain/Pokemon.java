package com.dojo.pokemonstore.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    Integer id;

    @NotNull
    @Size(min=1)
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(nullable = false)
    Double weight;

    @NotNull
    @Column(nullable = false)
    Double height;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=10)
    PokemonType pokemonType;

    String imageUrl;

    public Integer getId() { return id; }
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
}
