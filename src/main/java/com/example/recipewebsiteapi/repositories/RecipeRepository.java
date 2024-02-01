package com.example.recipewebsiteapi.repositories;

import com.example.recipewebsiteapi.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByDishTypeContainingIgnoreCaseAndRecipeNameContainingIgnoreCase(
            String dishType, String recipeName);

}
