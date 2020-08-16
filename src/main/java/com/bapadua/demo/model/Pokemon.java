package com.bapadua.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Pokemon {

    @Id
    private String id;
    private String name;
    private String category;
    private String skill;
    private Double weigth;

    public Pokemon(String id, String name, String category, String skill, Double weigth) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.skill = skill;
        this.weigth = weigth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id) &&
                Objects.equals(name, pokemon.name) &&
                Objects.equals(category, pokemon.category) &&
                Objects.equals(skill, pokemon.skill) &&
                Objects.equals(weigth, pokemon.weigth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, skill, weigth);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", skill='" + skill + '\'' +
                ", weigth=" + weigth +
                '}';
    }
}
