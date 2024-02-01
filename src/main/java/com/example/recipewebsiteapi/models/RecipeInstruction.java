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
@Table(name = "recipe_instructions")
public class RecipeInstruction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @NotBlank
    @Column(name = "instruction_number")
    Long number;

    @NotBlank
    @Column(name = "instruction_text")
    String text;

    public RecipeInstruction(Long number, String text) {
        this.number = number;
        this.text = text;
    }

}
