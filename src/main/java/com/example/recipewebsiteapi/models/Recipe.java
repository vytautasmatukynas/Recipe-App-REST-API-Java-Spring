package com.example.recipewebsiteapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NotBlank
    @Column(name = "recipe_name")
    String recipeName;

    @NotBlank
    @Column(name = "dish_type")
    private String dishType;

    @NotBlank
    @Column(name = "prep_time")
    String prepTime;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    List<RecipeIngredient> ingredients;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "instruction_id")
    List<RecipeInstruction> instructions;

    @Column(name = "update_date")
    String updateDate;

    public Recipe(String recipeName, String dishType, String prepTime, String updateDate) {
        this.recipeName = recipeName;
        this.dishType = dishType;
        this.prepTime = prepTime;
        this.updateDate = updateDate;
    }

    public void addInstructions(RecipeInstruction instruction) {
        if (instructions == null) {
            instructions = new ArrayList<>();
        }

        instructions.add(instruction);
    }

    public void removeInstructions(RecipeInstruction instruction) {
        if (instructions != null) {
            instructions.remove(instruction);
        }
    }

    public void addIngredient(RecipeIngredient ingredient) {
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }

        ingredients.add(ingredient);
    }

    public void removeIngredient(RecipeIngredient ingredient) {
        if (ingredients != null) {
            ingredients.remove(ingredient);
        }
    }

}
