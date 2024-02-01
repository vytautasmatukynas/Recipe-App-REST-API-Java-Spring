package com.example.recipewebsiteapi.services.interfaces;

import com.example.recipewebsiteapi.models.Recipe;
import com.example.recipewebsiteapi.models.RecipeIngredient;
import com.example.recipewebsiteapi.models.RecipeInstruction;

import java.util.List;

public interface RecipeService extends AppService<Recipe> {

    List<Recipe> searchForRecipe(String searchParam);

    RecipeInstruction addInstruction(Long id, RecipeInstruction instruction);

    RecipeIngredient addIngredient(Long id, RecipeIngredient ingredient);

    String removeInstruction(Long id, String name);

    String removeIngredient(Long id, String name);

}
