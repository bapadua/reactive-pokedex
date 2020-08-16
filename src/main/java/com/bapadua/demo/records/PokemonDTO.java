package com.bapadua.demo.records;

import com.bapadua.demo.model.Pokemon;

import java.util.Objects;

public class PokemonDTO {

    private String name;
    private String category;
    private String skill;
    private Double weigth;

    public PokemonDTO() {
    }

    public PokemonDTO(String name, String category, String skill, Double weigth) {
        this.name = name;
        this.category = category;
        this.skill = skill;
        this.weigth = weigth;
    }

    public Pokemon toEntity() {
        return new Pokemon(null, this.name, this.category, this.skill, this.weigth);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Double getWeigth() {
        return weigth;
    }

    public void setWeigth(Double weigth) {
        this.weigth = weigth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonDTO that = (PokemonDTO) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(category, that.category) &&
                Objects.equals(skill, that.skill) &&
                Objects.equals(weigth, that.weigth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, skill, weigth);
    }

    @Override
    public String toString() {
        return "PokemonDTO{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", skill='" + skill + '\'' +
                ", weigth=" + weigth +
                '}';
    }
}
