package com.example.recipewebsiteapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recipe_ingredients")
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NotBlank
    @Column(name = "ingredient_name")
    String name;

    @NotBlank
    @Column(name = "ingredient_count")
    Float count;

    @NotBlank
    @Column(name = "ingredient_unit")
    String unit;

    public RecipeIngredient(String name, Float count, String unit) {
        this.name = name;
        this.count = count;
        this.unit = unit;
    }
}
