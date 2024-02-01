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

    @NotBlank
    @Column(name = "link_to_img")
    String linkToImg = "https://photos.google.com/photo/AF1QipNzWwv4FFEu98G2j6pp1ntTcIeThsnrkz9Lfd4";

    @Column(name = "update_date")
    String updateDate;

    public Recipe(String recipeName,
                  String dishType,
                  String prepTime,
                  List<RecipeIngredient> ingredients,
                  List<RecipeInstruction> instructions,
                  String linkToImg,
                  String updateDate) {
        this.recipeName = recipeName;
        this.dishType = dishType;
        this.prepTime = prepTime;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.linkToImg = linkToImg;
        this.updateDate = updateDate;
    }

    public void addInstructions(RecipeInstruction instruction) {
        if (instructions == null) {
            instructions = new ArrayList<>();
        }

        instructions.add(instruction);
    }

    public void addIngredient(RecipeIngredient ingredient) {
        if (ingredients == null) {
            ingredients = new ArrayList<>();
        }

        ingredients.add(ingredient);
    }

}
