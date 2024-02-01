package com.example.recipewebsiteapi.repositories;

import com.example.recipewebsiteapi.models.Ingredient;
import com.example.recipewebsiteapi.models.IngredientUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameContainingIgnoreCase(String ingredientName);

}
